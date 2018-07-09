package cn.woyeshi.server.utils

import java.util.concurrent.TimeUnit
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.stereotype.Component

/**
 * redicache 工具类
 *
 */
@Component
class RedisUtils {

    @Autowired
    private val redisTemplate: RedisTemplate<String, String>? = null

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    fun remove(vararg keys: String) {
        for (key in keys) {
            remove(key)
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    fun removePattern(pattern: String) {
        val keys = redisTemplate!!.keys(pattern)
        if (keys.size > 0)
            redisTemplate.delete(keys)
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    fun remove(key: String) {
        if (exists(key)) {
            redisTemplate!!.delete(key)
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    fun exists(key: String): Boolean {
        return redisTemplate!!.hasKey(key)!!
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    operator fun get(key: String): String? {
        val operations = redisTemplate!!.opsForValue()
        return operations.get(key)
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    operator fun set(key: String, value: String): Boolean {
        var result = false
        try {
            val operations = redisTemplate!!.opsForValue()
            operations.set(key, value)
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    operator fun set(key: String, value: String, expireTime: Long?): Boolean {
        var result = false
        try {
            val operations: ValueOperations<String, String> = redisTemplate!!.opsForValue()
            operations.set(key, value)
            redisTemplate.expire(key, expireTime!!, TimeUnit.SECONDS)
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }
}