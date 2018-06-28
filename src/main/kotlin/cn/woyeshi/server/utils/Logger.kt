package cn.woyeshi.server.utils

import org.slf4j.LoggerFactory

object Logger {

    fun <T> i(tag: Class<T>, msg: String?) {
        LoggerFactory.getLogger(tag).info("$tag --------------> $msg")
    }

    fun <T> d(tag: Class<T>, msg: String?) {
        LoggerFactory.getLogger(tag).debug("$tag --------------> $msg")
    }


    fun <T> w(tag: Class<T>, msg: String?) {
        LoggerFactory.getLogger(tag).warn("$tag --------------> $msg")
    }

    fun <T> e(tag: Class<T>, msg: String?) {
        LoggerFactory.getLogger(tag).error("$tag --------------> $msg")
    }


}