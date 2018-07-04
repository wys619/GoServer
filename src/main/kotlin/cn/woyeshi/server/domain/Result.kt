package cn.woyeshi.server.domain

class Result {

    /**
     * 错误码.
     */
    var code: Int? = null
        get() = if (field == null) {
            0
        } else field

    /**
     * 提示信息.
     */
    var msg: String? = null

    /**
     * 具体的内容.
     */
    var data: Any? = null
}