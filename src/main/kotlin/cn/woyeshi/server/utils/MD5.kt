package cn.woyeshi.server.utils

import java.security.MessageDigest

object MD5 {
    private val TAG = "MD5"

    fun getMD5(buffer: ByteArray): String? {
        Logger.i(MD5::class.java, "md5 start time" + System.currentTimeMillis())
        val hexDigits = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
        try {
            val mdTemp = MessageDigest.getInstance("MD5")
            mdTemp.update(buffer)
            val md = mdTemp.digest()
            val j = md.size
            val str = CharArray(j * 2)
            var k = 0
            for (byte0 in md) {
                str[k++] = hexDigits[byte0.toInt().ushr(4) and 0xf]
                str[k++] = hexDigits[byte0.toInt() and 0xf]
            }
            Logger.i(MD5::class.java, "md5 end time" + System.currentTimeMillis())
            return String(str)
        } catch (e: Exception) {
            return null
        }

    }
}
