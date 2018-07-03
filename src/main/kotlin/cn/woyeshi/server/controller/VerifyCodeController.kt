package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.mapper.UserMapper
import cn.woyeshi.server.utils.Constants
import cn.woyeshi.server.utils.RedisUtils
import cn.woyeshi.server.utils.ResultUtil
import cn.woyeshi.server.utils.TextUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("code")
class VerifyCodeController : BaseController() {

    private val CODE_GENERATE_TIME_INTERVAL = 30000           //两次获取验证码的时间间隔30秒

    @Autowired
    private val redisUtils: RedisUtils? = null

    @Autowired
    val userMapper: UserMapper? = null

    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET])
    fun getVerifyCode(phone: String?, type: Int?): Result<Any> {
        if (TextUtils.isEmpty(phone)) {
            return ResultUtil.error(-1, "请输入手机号码", null)
        }
        if (type == null) {
            return ResultUtil.error(-1, "请设置获取的验证码的类型", null)
        }
        var lastTime = redisUtils?.get(Constants.RedisKeys.KEY_LAST_VERIFY_CODE_TIME + phone)
        if (lastTime == null) {
            lastTime = "0"
        }

        val currentTime = System.currentTimeMillis()
        val remainTime = currentTime - lastTime.toInt()
        if (remainTime < CODE_GENERATE_TIME_INTERVAL) {        //两次时间间隔小于
            return ResultUtil.error(-1, "${CODE_GENERATE_TIME_INTERVAL/1000}秒之内只能获取一次验证码()", null)
        }
        when (type) {
            Constants.CODE_TYPE_REGISTER -> {      //注册类型的验证码

            }
            Constants.CODE_TYPE_FIND_PWD -> {       //找回密码类型的验证码

            }
            Constants.CODE_TYPE_MODE_PWD -> {       //修改密码

            }
            else -> {
                return ResultUtil.error(-1, "获取的验证码的类型错误", null)
            }
        }
        return ResultUtil.success()

    }


}