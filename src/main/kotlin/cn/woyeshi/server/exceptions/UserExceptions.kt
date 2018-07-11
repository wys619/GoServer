package cn.woyeshi.server.exceptions

import cn.woyeshi.server.utils.ErrorCodes

abstract class UserException(code: Int, msg: String?) : BaseException(code, msg)


class UserNameEmptyException : UserException(code = ErrorCodes.ERROR_CODE_USER_NAME_IS_EMPTY, msg = "用户名不能为空")
class PasswordEmptyException : UserException(code = ErrorCodes.ERROR_CODE_PASSWORD_IS_EMPTY, msg = "密码不能为空")
class UserNameExistsException : UserException(code = ErrorCodes.ERROR_CODE_USER_NAME_EXISTS, msg = "该用户名已经存在")
class UserRegisterErrorException : UserException(code = ErrorCodes.ERROR_CODE_REGISTER_ERROR_EXCEPTION, msg = "服务器内部异常，注册失败")
class UserDeleteByEmptyIdException : UserException(code = ErrorCodes.ERROR_CODE_USER_ID_IS_EMPTY_EXCEPTION, msg = "用户ID不能为空")
class UserNotExistException : UserException(code = ErrorCodes.ERROR_CODE_USER_NOT_EXIST_EXCEPTION, msg = "该用户不存在")
class UserUpdateErrorException : UserException(code = ErrorCodes.ERROR_CODE_USER_UPDATE_ERROR_EXCEPTION, msg = "用户信息更新失败")
class TokenInvalidException : UserException(code = ErrorCodes.ERROR_CODE_TOKEN_INVALID_EXCEPTION, msg = "登录信息已过期")