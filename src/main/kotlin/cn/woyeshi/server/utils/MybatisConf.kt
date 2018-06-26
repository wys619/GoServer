package cn.woyeshi.server.utils

import com.github.pagehelper.PageHelper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.util.Properties

@Configuration
class MybatisConf {
    @Bean
    fun pageHelper(): PageHelper {
        println("=========MyBatisConfiguration.pageHelper()")
        val pageHelper = PageHelper()
        val p = Properties()
        p.setProperty("offsetAsPageNum", "true")
        p.setProperty("rowBoundsWithCount", "true")
        p.setProperty("reasonable", "true")
        pageHelper.setProperties(p)
        return pageHelper
    }
} 