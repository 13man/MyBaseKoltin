package com.taichi.mybasekoltin.api

import com.taichi.mybasekoltin.entity.LoginRegisterResponse
import com.taichi.mybasekoltin.entity.LoginRegisterResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 客户端API 可以访问 服务器API
 */
interface WanAndroidAPI {

    /**
     * 注册的API
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerAction(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    )
            : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>>

    /**
     * 登录的API
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginAction(
        @Field("username") username: String,
        @Field("password") password: String
    )
            : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>>

}