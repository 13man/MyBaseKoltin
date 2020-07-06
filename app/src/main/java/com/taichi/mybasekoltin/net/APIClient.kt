package com.taichi.mybasekoltin.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIClient {

    private object Holder {
        val INSTANCE = APIClient()
    }

    //伴生
    companion object {
        val instance = Holder.INSTANCE
    }


    //WanAndroidAPI 实例化这个
    fun <T> instanceRetrofit(apiInterface: Class<T>): T {
        val mOkHttpClient = OkHttpClient().newBuilder()
            .readTimeout(10000, TimeUnit.SECONDS)
            .connectTimeout(10000, TimeUnit.SECONDS)
            .writeTimeout(10000, TimeUnit.SECONDS)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")

            .client(mOkHttpClient)

            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//Rxjava2 来处理
            .addConverterFactory(GsonConverterFactory.create())  //Gson 解析
            .build()
        return retrofit.create(apiInterface)
    }
}