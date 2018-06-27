package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.exceptions.BaseException
import cn.woyeshi.server.utils.Logger
import cn.woyeshi.server.utils.MD5
import cn.woyeshi.server.utils.ResultUtil
import cn.woyeshi.server.utils.TextUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File


@Controller
@RestController
@RequestMapping("images")
class ImageController : BaseController() {

    @Value("\${cbs.imagesDir}")
    private val location = ""

    @RequestMapping("/upload", method = [RequestMethod.POST])
    @ResponseBody
    fun uploadImage(@RequestParam("file") file: MultipartFile, @RequestHeader("token") token: String): Result<Any> {
        if (file.isEmpty) {
            throw BaseException(-1, "文件内容为空，请先选择一个文件！")
        }
        val contentType = file.contentType
        if (TextUtils.isEmpty(contentType)) {
            throw BaseException(-1, "未知文件类型")
        }
        if (file.size <= 0) {
            throw BaseException(-1, "非法文件")
        }
        val md5 = MD5.getMD5(file.bytes)
        if (TextUtils.isEmpty(md5)) {
            throw BaseException(-1, "文件摘要失败")
        }
        Logger.i(TAG, "token == $token")
        when (contentType) {
            "image/png" -> {
                val cacheName = "$md5.png"
                if (saveFile(cacheName, file)) return ResultUtil.success("找到相同文件并已经复用")
            }
            "image/jpg" -> {
                val cacheName = "$md5.jpg"
                if (saveFile(cacheName, file)) return ResultUtil.success("找到相同文件并已经复用")
            }
            "image/jpeg" -> {
                val cacheName = "$md5.jpeg"
                if (saveFile(cacheName, file)) return ResultUtil.success("找到相同文件并已经复用")
            }
            else -> {
                throw BaseException(-1, "目前只支持jpg/jpeg或者png格式的图片")
            }
        }
        return ResultUtil.success()
    }

    private fun saveFile(cacheName: String, file: MultipartFile): Boolean {
        val f = File("$location$cacheName")
        if (f.exists()) {
            return true
        }
        file.transferTo(f)
        return false
    }
}