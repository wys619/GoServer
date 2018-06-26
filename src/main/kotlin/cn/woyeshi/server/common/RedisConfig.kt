package cn.woyeshi.server.common

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.interceptor.KeyGenerator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import java.lang.reflect.Method
import java.util.*


/**
 * redis配置
 */
@Configuration
@EnableCaching
class RedisConfig : CachingConfigurerSupport() {


    /**
     * 生成key的策略
     *
     * @return
     */
    @Bean
    override fun keyGenerator(): KeyGenerator {
        return MyKeyGenerator()
    }

    /**
     * 管理缓存
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    fun cacheManager(redisTemplate: RedisTemplate<String, String>): CacheManager {
        val rcm = RedisCacheManager(redisTemplate)
        //设置缓存过期时间
        // rcm.setDefaultExpiration(60);//秒
        //设置value的过期时间
        val map = HashMap<String, Long>()
        map.put("test", 60L)
        rcm.setExpires(map)
        return rcm
    }

    /**
     * RedisTemplate配置
     * @param factory
     * @return
     */
    @Bean
    fun redisTemplate(factory: RedisConnectionFactory): RedisTemplate<String, String> {
        val template = StringRedisTemplate(factory)
        val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(Any::class.java)
        val om = ObjectMapper()
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
        jackson2JsonRedisSerializer.setObjectMapper(om)
        template.valueSerializer = jackson2JsonRedisSerializer//如果key是String 需要配置一下StringSerializer,不然key会乱码 /XX/XX
        template.afterPropertiesSet()
        return template
    }

    class MyKeyGenerator : KeyGenerator {
        override fun generate(target: Any?, method: Method?, vararg params: Any?): Any {
            val sb = StringBuilder()
            sb.append(target?.javaClass?.name)
            sb.append(method?.name)
            for (obj in params) {
                sb.append(obj.toString())
            }
            return sb.toString()
        }

    }

}
