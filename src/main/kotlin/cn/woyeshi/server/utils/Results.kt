package cn.woyeshi.server.utils

import cn.woyeshi.server.domain.Result

object Results {

    fun success(): Result {
        val result = Result()
        result.code = 0
        result.msg = "操作成功"
        return result
    }

    fun success(t: Any?): Result {
        val result = Result()
        result.code = 0
        result.msg = "操作成功"
        result.data = t
        return result
    }


    fun error(code: Int?, msg: String, t: Any?): Result {
        val result = Result()
        result.code = code
        result.msg = msg
        result.data = t
        return result
    }

    fun error(code: Int?, msg: String): Result {
        val result = Result()
        result.code = code
        result.msg = msg
        return result
    }

    fun success(msg: String, t: Any?): Result {
        val result = Result()
        result.code = 0
        result.msg = msg
        result.data = t
        return result
    }

    fun success(msg: String): Result {
        val result = Result()
        result.code = 0
        result.msg = msg
        return result
    }

}