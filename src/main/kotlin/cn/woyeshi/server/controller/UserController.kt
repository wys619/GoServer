package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.domain.User
import cn.woyeshi.server.domain.UserExample
import cn.woyeshi.server.exceptions.*
import cn.woyeshi.server.mapper.UserMapper
import cn.woyeshi.server.utils.*
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@RequestMapping("user")
@RestController
class UserController : BaseController() {

    @Autowired
    val userMapper: UserMapper? = null

    @Autowired
    val redisUtils: RedisUtils? = null

    /**
     * GET方式执行查询
     */
    @RequestMapping(method = [RequestMethod.GET])
    @ResponseBody
    fun queryUser(pageNum: Int?, pageSize: Int?, userName: String?, password: String?): Result? {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage<User>(pageNum, pageSize)
        } else {
            PageHelper.startPage<User>(Constants.DEFAULT_START_PAGE, Constants.DEFAULT_PAGE_SIZE)
        }
        val userExample = UserExample()
        val criteria = userExample.createCriteria()
        if (TextUtils.isNotEmpty(userName)) {
            criteria.andUserNameEqualTo(userName!!)
        }
        if (TextUtils.isNotEmpty(password)) {
            criteria.andPasswordEqualTo(password!!)
        }
        val list = userMapper?.selectByExample(userExample)
        if (list != null && list.isNotEmpty() && TextUtils.isNotEmpty(password)) {
            onLoginSuccess(list)
        } else if (TextUtils.isNotEmpty(password)) {                //登录的时候用户名或者密码不正确
            return onLoginFail(userName)
        }
        return Results.success(list ?: ArrayList<Any>())
    }

    //登录失败
    private fun onLoginFail(userName: String?): Result? {
        val userNameExample = UserExample()
        val userNameCriteria = userNameExample.createCriteria()
        if (TextUtils.isNotEmpty(userName)) {
            userNameCriteria.andUserNameEqualTo(userName!!)
        }
        val users = userMapper?.selectByExample(userNameExample)
        return if (users == null || users.isEmpty()) {
            Results.error(-1, "账号不存在")
        } else {
            Results.error(-1, "您输入的密码不正确")
        }
    }

    //
    private fun onLoginSuccess(list: List<User>) {
        val user: User = list[0]
        val token = UserUtils.setToken(redisUtils!!, user.userId)
        user.token = token
    }

    /**
     * POST方法执行添加用户记录
     */
    @RequestMapping(method = [RequestMethod.POST])
    fun register(userName: String?, password: String?, code: String?): Result {
        if (TextUtils.isEmpty(userName)) {
            throw UserNameEmptyException()
        }
        if (TextUtils.isEmpty(password)) {
            throw PasswordEmptyException()
        }
        if (TextUtils.isEmpty(code)) {
            throw BaseException(-1, "验证码不能为空")
        }
        val userExample = UserExample()
        val criteria = userExample.createCriteria()
        if (TextUtils.isNotEmpty(userName)) {
            criteria.andUserNameEqualTo(userName!!)
        }
        val u = userMapper?.selectByExample(userExample)
        if (u != null && u.isNotEmpty()) {
            throw UserNameExistsException()         //用户名已经存在了
        }
        val cachedCode = redisUtils?.get("${Constants.RedisKeys.KEY_LAST_VERIFY_CODE}$userName${Constants.CODE_TYPE_REGISTER}")
        if (TextUtils.isEmpty(cachedCode)) {
            return Results.error(-1, "验证码已失效，请重新获取")
        }
        if (cachedCode != code) {
            return Results.error(-1, "验证码错误，请重新输入")
        }
        val userId = CharacterUtils.getRandomString(32)
        val user = User()
        user.userId = userId
        user.userName = userName
        user.password = password
        user.regTime = Date()               //注册时间
        val affectCount = userMapper?.insert(user)
        if (affectCount == 1) {
            redisUtils?.remove("${Constants.RedisKeys.KEY_LAST_VERIFY_CODE}$userName${Constants.CODE_TYPE_REGISTER}")           //注册成功验证码使用之后就从内存中移除，并执行
            val token = UserUtils.setToken(redisUtils!!, userId)        //注册成功之后生成token并返回
            user.token = token
            return Results.success(user)
        }
        throw UserRegisterErrorException()
    }

    /**
     * 删除用户
     */
    @RequestMapping(method = [RequestMethod.DELETE])
    fun deleteUser(userId: String?): Result {
        if (TextUtils.isEmpty(userId)) {
            throw UserDeleteByEmptyIdException()
        }
        if (userMapper?.deleteByPrimaryKey(userId!!) == 1) {
            return Results.success()
        }
        throw UserNotExistException()
    }

    /**
     * 修改用户
     */
    @RequestMapping(method = [RequestMethod.PUT])
    fun updateUser(@RequestBody user: User?, @RequestHeader token: String?): Result {
        if (user == null || TextUtils.isEmpty(user.userId)) {
            throw UserNotExistException()
        }
        val u = UserUtils.getUserInfoByToken(userMapper!!, redisUtils!!, token)
        if (u == null || u.userId != user.userId) {
            throw TokenInvalidException()
        }
        if (userMapper?.updateByPrimaryKeySelective(user) == 1) {
            return Results.success(userMapper?.selectByPrimaryKey(user.userId))
        } else {
            throw UserUpdateErrorException()
        }
    }


}