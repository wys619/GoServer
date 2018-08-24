package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.domain.UploadResult
import cn.woyeshi.server.exceptions.BaseException
import cn.woyeshi.server.utils.Logger
import cn.woyeshi.server.utils.MD5
import cn.woyeshi.server.utils.Results
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
    fun uploadImage(@RequestParam("file") file: MultipartFile, @RequestHeader("token") token: String): Result {
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
        val cacheName: String
        when (contentType) {
            "image/png" -> {
                cacheName = "$md5.png"
                if (saveFile(cacheName, file)) return Results.success("找到相同文件并已经复用", UploadResult("https://res.woyeshi.cn/images/$cacheName"))
            }
            "image/jpg" -> {
                cacheName = "$md5.jpg"
                if (saveFile(cacheName, file)) return Results.success("找到相同文件并已经复用", UploadResult("https://res.woyeshi.cn/images/$cacheName"))
            }
            "image/jpeg" -> {
                cacheName = "$md5.jpeg"
                if (saveFile(cacheName, file)) return Results.success("找到相同文件并已经复用", UploadResult("https://res.woyeshi.cn/images/$cacheName"))
            }
            else -> {
                throw BaseException(-1, "目前只支持jpg/jpeg或者png格式的图片")
            }
        }
        return Results.success(UploadResult("https://res.woyeshi.cn/images/$cacheName"))
    }

    private fun saveFile(cacheName: String, file: MultipartFile): Boolean {
        val dir = File(location)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val f = File("$location$cacheName")
        if (f.exists()) {
            return true
        }
        file.transferTo(f)
        return false
    }
}