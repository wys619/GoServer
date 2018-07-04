package cn.woyeshi.server.utils

import java.util.Random

object CharacterUtils {
    //方法1：length为产生的位数
    fun getRandomString(length: Int): String {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        val str = "ABCDEF1234567890"
        //由Random生成随机数
        val random = Random()
        val sb = StringBuffer()
        //长度为几就循环几次
        for (i in 0 until length) {
            //产生0-15的数字
            val number = random.nextInt(16)
            //将产生的数字通过length次承载到sb中
            sb.append(str[number])
        }
        //将承载的字符转换成字符串
        return sb.toString()
    }

    //方法1：length为产生的位数
    fun getRandomNumberString(length: Int): String {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        val str = "1234567890"
        //由Random生成随机数
        val random = Random()
        val sb = StringBuffer()
        //长度为几就循环几次
        for (i in 0 until length) {
            //产生0-15的数字
            val number = random.nextInt(16)
            //将产生的数字通过length次承载到sb中
            sb.append(str[number])
        }
        //将承载的字符转换成字符串
        return sb.toString()
    }

}