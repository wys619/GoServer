package cn.woyeshi.server

import cn.woyeshi.server.utils.Logger
import cn.woyeshi.server.utils.MD5
import cn.woyeshi.server.utils.TextUtils
import org.junit.Test

class SampleTest {

    @Test
    fun getMd5() {
        val md5 = MD5.getMD5("abc1234".toByteArray())
        Logger.d(SampleTest::class.java, "$md5")
        assert(TextUtils.isNotEmpty(md5))
    }

}