package cn.woyeshi.server.mapper

import cn.woyeshi.server.domain.User
import cn.woyeshi.server.domain.UserExample

import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Service

@Service(value = "userMapper")
@Mapper
interface UserMapper {
    fun countByExample(example: UserExample): Long

    fun deleteByExample(example: UserExample): Int

    fun deleteByPrimaryKey(userId: String): Int

    fun insert(record: User): Int

    fun insertSelective(record: User): Int

    fun selectByExample(example: UserExample?): List<User>

    fun selectByPrimaryKey(userId: String): User

    fun updateByExampleSelective(@Param("record") record: User, @Param("example") example: UserExample): Int

    fun updateByExample(@Param("record") record: User, @Param("example") example: UserExample): Int

    fun updateByPrimaryKeySelective(record: User): Int

    fun updateByPrimaryKey(record: User): Int

    @Select("Select * from t_user where user_name = '\${userName}' and password = '\${password}'")
    @Results(Result(property = "userName", column = "user_name"), Result(property = "userId", column = "user_id"))
    fun selectByUserNameAndPwd(@Param("userName") userName: String, @Param("password") password: String): User
}