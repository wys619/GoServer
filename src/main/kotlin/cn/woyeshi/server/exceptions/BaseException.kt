package cn.woyeshi.server.exceptions

open class BaseException(val code: Int, val msg: String?) : RuntimeException(msg)