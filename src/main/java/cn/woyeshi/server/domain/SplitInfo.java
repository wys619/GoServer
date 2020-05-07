package cn.woyeshi.server.domain;

import java.util.Date;

public class SplitInfo {
    private Integer splitId;

    private String appVersion;

    private String splitVersion;

    private String splitConfigUrl;

    private String isAlert;

    private Date updateTime;

    private String changeLog;

    public SplitInfo(Integer splitId, String appVersion, String splitVersion, String splitConfigUrl, String isAlert, Date updateTime, String changeLog) {
        this.splitId = splitId;
        this.appVersion = appVersion;
        this.splitVersion = splitVersion;
        this.splitConfigUrl = splitConfigUrl;
        this.isAlert = isAlert;
        this.updateTime = updateTime;
        this.changeLog = changeLog;
    }

    public SplitInfo() {
        super();
    }

    public Integer getSplitId() {
        return splitId;
    }

    public void setSplitId(Integer splitId) {
        this.splitId = splitId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public String getSplitVersion() {
        return splitVersion;
    }

    public void setSplitVersion(String splitVersion) {
        this.splitVersion = splitVersion == null ? null : splitVersion.trim();
    }

    public String getSplitConfigUrl() {
        return splitConfigUrl;
    }

    public void setSplitConfigUrl(String splitConfigUrl) {
        this.splitConfigUrl = splitConfigUrl == null ? null : splitConfigUrl.trim();
    }

    public String getIsAlert() {
        return isAlert;
    }

    public void setIsAlert(String isAlert) {
        this.isAlert = isAlert == null ? null : isAlert.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog == null ? null : changeLog.trim();
    }
}