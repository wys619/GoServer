package cn.woyeshi.server

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletComponentScan


@ServletComponentScan
@SpringBootApplication
@MapperScan("cn.woyeshi.server.mapper")
class ServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ServerApplication::class.java, *args)
}
