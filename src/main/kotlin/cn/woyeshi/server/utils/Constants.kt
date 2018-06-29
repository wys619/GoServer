package cn.woyeshi.server.utils

object Constants {

    const val DEFAULT_START_PAGE = 1
    const val DEFAULT_PAGE_SIZE = 10

    const val CODE_TYPE_REGISTER = 0
    const val CODE_TYPE_FIND_PWD = 1
    const val CODE_TYPE_MODE_PWD = 2

    const val ERROR_CODE_TOKEN_INVALID: Int = -1001         //登录失效


    object RedisKeys {
        const val KEY_LAST_VERIFY_CODE_TIME = "KEY_LAST_VERIFY_CODE_TIME"
    }


}