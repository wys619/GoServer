package cn.woyeshi.server.utils

import cn.woyeshi.server.filter.ExceptionHandle
import org.slf4j.LoggerFactory

object Logger {

    private val logger = LoggerFactory.getLogger(ExceptionHandle::class.java)

    fun i(tag: String, msg: String?) {
        logger.info("$tag --------------> $msg")
    }

    fun d(tag: String, msg: String?) {
        logger.debug("$tag --------------> $msg")
    }


    fun w(tag: String, msg: String?) {
        logger.warn("$tag --------------> $msg")
    }

    fun e(tag: String, msg: String?) {
        logger.error("$tag --------------> $msg")
    }


}