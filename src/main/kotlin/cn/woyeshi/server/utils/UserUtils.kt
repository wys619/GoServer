package cn.woyeshi.server.utils

import cn.woyeshi.server.domain.User
import cn.woyeshi.server.mapper.UserMapper

object UserUtils {

    private const val USER_LOGIN_VALID_TIME = 86400000L            //登录信息有效期为24小时

    fun setToken(redisUtils: RedisUtils, userId: String): String {
        val token = CharacterUtils.getRandomString(32)

        val oldToken = redisUtils["token_$userId"]
        if (TextUtils.isNotEmpty(oldToken)) {             //如果旧的token不为空
            redisUtils.remove("token_$userId")       //就先移除旧的token
            redisUtils.remove(oldToken!!)                 //移除token到userId的映射
        }
        redisUtils["token_$userId", token] = USER_LOGIN_VALID_TIME      //记录新的token
        redisUtils[token, userId] = USER_LOGIN_VALID_TIME               //建立新的映射
        return token
    }

    //判断token是否有效
    fun isTokenValid(redisUtils: RedisUtils, token: String?): Boolean {
        if (TextUtils.isEmpty(token)) {
            return false
        }
        return TextUtils.isNotEmpty(redisUtils[token!!])
    }

    //用token查询用户信息
    fun getUserInfoByToken(userMapper: UserMapper, redisUtils: RedisUtils, token: String?): User? {
        if (TextUtils.isEmpty(token)) {
            return null
        }
        return userMapper.selectByPrimaryKey(redisUtils[token!!])
    }

}