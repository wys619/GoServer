package cn.woyeshi.server.filter

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.exceptions.BaseException
import cn.woyeshi.server.utils.ResultUtil
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody


@ControllerAdvice
class ExceptionHandle {

    @ExceptionHandler(value = [Exception::class])
    @ResponseBody
    fun handle(e: Exception): Result<*> {
        return if (e is BaseException) {
            ResultUtil.error(e.code, e.message)
        } else {
            //将系统异常以打印出来
            logger.info("[系统异常]{}", e)
            ResultUtil.error(-1, "未知错误")
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ExceptionHandle::class.java)
    }
}