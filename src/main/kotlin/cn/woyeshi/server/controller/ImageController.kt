package cn.woyeshi.server.controller

import cn.woyeshi.server.exceptions.BaseException
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest


@Controller
@RestController
@RequestMapping("images")
class ImageController : BaseController() {

    @RequestMapping("/upload", method = [RequestMethod.POST])
    @ResponseBody
    fun uploadImage(@RequestParam("file") file: MultipartFile, request: HttpServletRequest) {
        if (file.isEmpty) {
            throw BaseException(-1, "文件内容为空，请先选择一个文件！")
        }
//        val contentType = file.contentType
//        if (!contentType.contains("")) {
//
//        }


    }


}