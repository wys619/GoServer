package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.domain.UploadResult
import cn.woyeshi.server.exceptions.BaseException
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
@RequestMapping("split")
class SplitController : BaseController() {


    @Value("\${cbs.splitDir}")
    private val location = ""

    @Value("\${splitDomain}")
    private val imageDomain = "http://127.0.0.1:8081/split/"

    @RequestMapping("/upload", method = [RequestMethod.POST])
    @ResponseBody
    fun uploadSplit(
            @RequestParam("file") file: MultipartFile,
            @RequestParam("splitVersion") splitVersion: String,
            @RequestParam("appVersion") appVersion: String
    ): Result {
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
        val cacheName = "$md5"
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