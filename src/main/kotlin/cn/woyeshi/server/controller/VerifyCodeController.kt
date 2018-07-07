package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.mapper.UserMapper
import cn.woyeshi.server.utils.Constants
import cn.woyeshi.server.utils.RedisUtils
import cn.woyeshi.server.utils.Results
import cn.woyeshi.server.utils.TextUtils
import com.sun.org.apache.xpath.internal.operations.Bool
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("code")
class VerifyCodeController : BaseController() {

    private val CODE_GENERATE_TIME_INTERVAL = 60000L           //两次获取验证码的时间间隔60秒

    @Autowired
    private val redisUtils: RedisUtils? = null

    @Autowired
    val userMapper: UserMapper? = null

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET])
    fun getVerifyCode(phone: String?, type: Int?): Result {
        if (TextUtils.isEmpty(phone)) {
            return Results.error(-1, "请输入手机号码")
        }
        if (type == null) {
            return Results.error(-1, "请设置获取的验证码的类型")
        }
        var lastTime = redisUtils?.get(Constants.RedisKeys.KEY_LAST_VERIFY_CODE_TIME + phone + "$type")
        if (lastTime == null) {
            lastTime = "0"
        }
        if (!isTypeValid(type)) {
            return Results.error(-1, "验证码类型错误")
        }
        val currentTime = System.currentTimeMillis()
        val remainTime = currentTime - lastTime.toLong()
        if (remainTime < CODE_GENERATE_TIME_INTERVAL) {        //两次时间间隔小于
            return Results.error(-1, "${CODE_GENERATE_TIME_INTERVAL / 1000}秒之内只能获取一次验证码(${(CODE_GENERATE_TIME_INTERVAL - remainTime) / 1000}S)")
        }
        redisUtils?.set(Constants.RedisKeys.KEY_LAST_VERIFY_CODE + "$phone$type", "6666", CODE_GENERATE_TIME_INTERVAL)         //测试用的默认验证码为6666
        redisUtils?.set(Constants.RedisKeys.KEY_LAST_VERIFY_CODE_TIME + phone + "$type", "${System.currentTimeMillis()}", CODE_GENERATE_TIME_INTERVAL)
        return Results.success("验证码已经发送，60秒内有效")
    }


    //判断验证码类型是否正确
    private fun isTypeValid(type: Int): Boolean {
        return when (type) {
            Constants.CODE_TYPE_REGISTER,
            Constants.CODE_TYPE_FIND_PWD,
            Constants.CODE_TYPE_MODE_PWD -> {
                true
            }
            else -> {
                false
            }
        }
    }
}