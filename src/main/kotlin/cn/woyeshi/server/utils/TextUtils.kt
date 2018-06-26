package cn.woyeshi.server.utils

class TextUtils {
    companion object {
        fun isEmpty(str: String?): Boolean {
            if (str == null) {
                return true
            }
            if ("" == str.trim()) {
                return true
            }
            return false
        }

        fun isNotEmpty(str: String?): Boolean {
            if (str == null) {
                return false
            }
            if ("" == str.trim()) {
                return false
            }
            return true
        }
    }
}