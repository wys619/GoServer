package cn.woyeshi.server.exceptions

abstract class BaseException(val code: Int, val msg: String?) : RuntimeException(msg)