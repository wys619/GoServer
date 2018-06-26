package cn.woyeshi.server.domain

class User {
    var userId: String? = null
    var userName: String? = null
    var password: String? = null

    constructor(userId: String, userName: String, password: String) {
        this.userId = userId
        this.userName = userName
        this.password = password
    }

    constructor() : super() {}
}