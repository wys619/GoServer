package cn.woyeshi.server.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by wys on 2017/2/15.
 * 官方示例工程中的测试代码
 */
@Controller
@RestController
class SampleController {

    @RequestMapping("/")
    @ResponseBody
    internal fun home(): String {
        return "Hello World!"
    }

}