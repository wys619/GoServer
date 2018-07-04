package cn.woyeshi.server.filter

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.exceptions.BaseException
import cn.woyeshi.server.utils.Results
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody


@ControllerAdvice
class ExceptionHandle {

    @ExceptionHandler(value = [Exception::class])
    @ResponseBody
    fun handle(e: Exception): Result{
        return if (e is BaseException) {
            Results.error(e.code, e.message ?: "", null)
        } else {
            //将系统异常以打印出来
            logger.info("[系统异常]", e)
            Results.error(-1, "未知错误", null)
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ExceptionHandle::class.java)
    }
}