package cn.woyeshi.server.controller

import cn.woyeshi.server.domain.Result
import cn.woyeshi.server.domain.SplitInfo
import cn.woyeshi.server.domain.SplitInfoExample
import cn.woyeshi.server.exceptions.BaseException
import cn.woyeshi.server.mapper.SplitInfoMapper
import cn.woyeshi.server.utils.MD5
import cn.woyeshi.server.utils.Results
import cn.woyeshi.server.utils.TextUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*


@Controller
@RestController
@RequestMapping("split")
class SplitController : BaseController() {

    @Autowired
    private val splitInfoMapper: SplitInfoMapper? = null

    @Value("\${cbs.splitDir}")
    private val location = ""

    @Value("\${splitDomain}")
    private val splitDomain = ""

    @RequestMapping("/upload", method = [RequestMethod.POST])
    @ResponseBody
    fun uploadSplit(
            @RequestParam("file") file: MultipartFile,
            @RequestParam("splitVersion") splitVersion: String,
            @RequestParam("appVersion") appVersion: String,
            @RequestParam("isAlert") isAlert: String?,
            @RequestParam("changeLog") changeLog: String?,
            @RequestParam("isDebug") isDebug: String? = "0"
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
        saveFile(cacheName, file)
        val example = SplitInfoExample()
        val criteria = example.createCriteria()
        criteria.andAppVersionEqualTo(appVersion)
        criteria.andIsDebugEqualTo(isDebug)
        val list = splitInfoMapper?.selectByExample(example)
        var isExists = false
        val info = if (list?.isNotEmpty() == true) {
            isExists = true
            list[0]
        } else {
            SplitInfo()
        }
        info.splitVersion = splitVersion
        info.splitConfigUrl = cacheName
        info.appVersion = appVersion
        info.isAlert = isAlert ?: "0"
        info.changeLog = changeLog ?: ""
        info.updateTime = Date(System.currentTimeMillis())
        info.isDebug = isDebug
        val count = if (isExists) {
            splitInfoMapper?.updateByPrimaryKey(info)
        } else {
            splitInfoMapper?.insert(info)
        }
        return if (count == 1) {
            Results.success(info)
        } else {
            Results.error(-1, "上传失败")
        }
    }


    @RequestMapping("/query", method = [RequestMethod.GET, RequestMethod.POST])
    @ResponseBody
    fun querySplit(
            @RequestParam("appVersion") appVersion: String,
            @RequestParam("isDebug") isDebug: String?
    ): Result {
        if (TextUtils.isEmpty(appVersion)) {
            return Results.error(-1, "appVersion不能为空！")
        }
        val example = SplitInfoExample()
        val criteria = example.createCriteria()
        criteria.andAppVersionEqualTo(appVersion)
        criteria.andIsDebugEqualTo(isDebug)
        val list = splitInfoMapper?.selectByExample(example)
        return if (list?.isNotEmpty() == true) {
            val info = list[0]
            info.splitConfigUrl = "$splitDomain${info.splitConfigUrl}"
            Results.success(info)
        } else {
            Results.error(-1, "文件不存在！")
        }
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