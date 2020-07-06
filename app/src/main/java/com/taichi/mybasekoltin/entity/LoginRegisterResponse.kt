package com.taichi.mybasekoltin.entity

//String? 允许服务器字段是null
data class LoginRegisterResponse(
    var admin: Boolean?,
    var chapterTops: List<Any>?,
    var collectIds: List<Any>?,
    var email: String?,
    var icon: String?,
    var id: Int?,
    var nickname: String?,
    var password: String?,
    var publicName: String?,
    var token: String?,
    var type: Int?,
    var username: String?
)