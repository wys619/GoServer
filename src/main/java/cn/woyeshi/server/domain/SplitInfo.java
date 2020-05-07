package cn.woyeshi.server.domain;

public class SplitInfo {
    private Integer splitId;

    private String appVersion;

    private String splitVersion;

    private String splitConfigUrl;

    public SplitInfo(Integer splitId, String appVersion, String splitVersion, String splitConfigUrl) {
        this.splitId = splitId;
        this.appVersion = appVersion;
        this.splitVersion = splitVersion;
        this.splitConfigUrl = splitConfigUrl;
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
}