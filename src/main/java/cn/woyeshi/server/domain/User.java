package cn.woyeshi.server.domain;

import java.util.Date;

public class User {
    private String userId;

    private String userName;

    private String password;

    private String nickname;

    private Date birthday;

    private String gender;

    private String avartar;

    private String userType;

    private String city;

    private String weChatId;

    private String qq;

    private String sina;

    private String aliPay;

    private String email;

    private String phone;

    private String token;

    public User(String userId, String userName, String password, String nickname, Date birthday, String gender, String avartar, String userType, String city, String weChatId, String qq, String sina, String aliPay, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
        this.birthday = birthday;
        this.gender = gender;
        this.avartar = avartar;
        this.userType = userType;
        this.city = city;
        this.weChatId = weChatId;
        this.qq = qq;
        this.sina = sina;
        this.aliPay = aliPay;
        this.email = email;
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar == null ? null : avartar.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId == null ? null : weChatId.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getSina() {
        return sina;
    }

    public void setSina(String sina) {
        this.sina = sina == null ? null : sina.trim();
    }

    public String getAliPay() {
        return aliPay;
    }

    public void setAliPay(String aliPay) {
        this.aliPay = aliPay == null ? null : aliPay.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}