package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.domain.User
import cn.woyeshi.server.domain.UserExample
import cn.woyeshi.server.exceptions.*
import cn.woyeshi.server.mapper.UserMapper
import cn.woyeshi.server.utils.*
import com.github.pagehelper.PageHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RequestMapping("user")
@RestController
class UserController : BaseController() {

    @Autowired
    val userMapper: UserMapper? = null

    /**
     * GET方式执行查询
     */
    @RequestMapping(method = [RequestMethod.GET])
    @ResponseBody
    fun queryUser(pageNum: Int?, pageSize: Int?, userName: String?, password: String?): Result<Any>? {
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
            val user: User = list[0]
            val token = CharacterUtils.getRandomString(32)
            redisUtils?.set("token_${user.userId}", token, 86400000L)          //登录信息有效期为24小时
            user.token = token
            Logger.i(UserController::class.java, "user token generated:" + redisUtils?.get("token_${user.userId}"))
        }
        return ResultUtil.success(list)
    }

    /**
     * POST方法执行添加用户记录
     */
    @RequestMapping(method = [RequestMethod.POST])
    fun register(userName: String?, password: String?): Result<Any> {
        if (TextUtils.isEmpty(userName)) {
            throw UserNameEmptyException()
        }
        if (TextUtils.isEmpty(password)) {
            throw PasswordEmptyException()
        }
        val userExample = UserExample()
        val criteria = userExample.createCriteria()
        if (TextUtils.isNotEmpty(userName)) {
            criteria.andUserNameEqualTo(userName!!)
        }
        val u = userMapper?.selectByExample(userExample)
        if (u != null && u.isNotEmpty()) {
            throw UserNameExistsException()
        }
        val userId = CharacterUtils.getRandomString(32)
        val user = User()
        user.userId = userId
        user.userName = userName
        user.password = password
        val affectCount = userMapper?.insert(user)
        if (affectCount == 1) {
            return ResultUtil.success(user)
        }
        throw UserRegisterErrorException()
    }

    /**
     * 删除用户
     */
    @RequestMapping(method = [RequestMethod.DELETE])
    fun deleteUser(userId: String?): Result<Any> {
        if (TextUtils.isEmpty(userId)) {
            throw UserDeleteByEmptyIdException()
        }
        if (userMapper?.deleteByPrimaryKey(userId!!) == 1) {
            return ResultUtil.success()
        }
        throw UserNotExistException()
    }

    /**
     * 修改用户
     */
    @RequestMapping(method = [RequestMethod.PUT])
    fun updateUser(user: User?): Result<Any> {
        if (user == null || TextUtils.isEmpty(user.userId)) {
            throw UserNotExistException()
        }
        if (TextUtils.isEmpty(user.password) || TextUtils.isEmpty(user.userName)) {
            return ResultUtil.error(-1, "用户名或密码不能为空", null)
        }
        val record = userMapper?.selectByPrimaryKey(user.userId!!)
        if (record != null) {
            record.userName = user.userName
            record.password = user.password
            if (userMapper?.updateByPrimaryKey(record) == 1) {
                return ResultUtil.success(record)
            } else {
                throw UserUpdateErrorException()
            }
        } else {
            throw UserNotExistException()
        }
    }


}