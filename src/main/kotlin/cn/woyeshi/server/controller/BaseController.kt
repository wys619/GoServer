package cn.woyeshi.server.controller

import cn.woyeshi.server.utils.RedisUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class BaseController {

    val TAG: String = javaClass.simpleName

    @Autowired
    var redisUtils: RedisUtils? = null


}