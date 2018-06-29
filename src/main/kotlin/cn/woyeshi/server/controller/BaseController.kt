package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.User
import cn.woyeshi.server.mapper.UserMapper
import cn.woyeshi.server.utils.RedisUtils
import cn.woyeshi.server.utils.TextUtils
import org.springframework.web.bind.annotation.RestController

@RestController
class BaseController {

    val TAG: String = javaClass.simpleName


    fun getUserByToken(userMapper: UserMapper?, redisUtils: RedisUtils?, token: String?): User? {
        return if (token == null || TextUtils.isEmpty(token)) {
            null
        } else {
            val userId = redisUtils?.get(token)
            if (TextUtils.isEmpty(userId)) {
                null
            } else {
                val user = userMapper?.selectByPrimaryKey(userId!!)
                user
            }
        }

    }

}