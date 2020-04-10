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

    companion object {
        const val imageDomain = "http://192.168.190.100:8081/images/"
    }

    @RequestMapping("/upload", method = [RequestMethod.POST])
    @ResponseBody
    fun uploadImage(@RequestParam("file") file: MultipartFile): Result {
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
        val cacheName: String = when (contentType) {
            "image/png" -> {
                "$md5.png"
            }
            "image/jpg" -> {
                "$md5.jpg"
            }
            "image/jpeg" -> {
                "$md5.jpeg"
            }
            else -> {
                "$md5"
            }
        }
        if (saveFile(cacheName, file)) return Results.success("找到相同文件并已经复用", UploadResult("$imageDomain$cacheName"))
        return Results.success(UploadResult("$imageDomain$cacheName"))
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