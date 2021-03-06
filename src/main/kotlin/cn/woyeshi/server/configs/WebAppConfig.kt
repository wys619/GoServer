package cn.woyeshi.server.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import java.text.SimpleDateFormat
import java.util.*
import javax.servlet.MultipartConfigElement


@Configuration
class WebAppConfig : WebMvcConfigurerAdapter() {

    @Value("\${cbs.imagesPath}")
    private var mImagesPath: String? = null

    @Value("\${cbs.splitPath}")
    private var splitPath: String? = null

    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        var imagesPath = WebAppConfig::class.java.classLoader.getResource("")!!.path
        if (imagesPath.indexOf(".jar") > 0) {
            imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"))
        } else if (imagesPath.indexOf("classes") > 0) {
            imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"))
        }
        if (mImagesPath == "" || mImagesPath == "\${cbs.imagesPath}") {
            mImagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/files/"
        }
        if (splitPath == "" || splitPath == "\${cbs.splitPath}") {
            splitPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/split/"
        }
        registry!!.addResourceHandler("/files/**", "/split/**").addResourceLocations(mImagesPath!!, splitPath!!)
        super.addResourceHandlers(registry)
    }

    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory()
        //文件最大KB,MB
        factory.setMaxFileSize("200MB")
        //设置总上传数据总大小
        factory.setMaxRequestSize("1000MB")
        return factory.createMultipartConfig()
    }

    @Bean
    fun addNewConvert(): Converter<String, Date> {
        return Converter { source ->
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            sdf.parse(source)
        }
    }
}