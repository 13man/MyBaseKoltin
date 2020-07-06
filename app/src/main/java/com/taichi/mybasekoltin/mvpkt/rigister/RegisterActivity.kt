package com.taichi.mybasekoltin.mvpkt.rigister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.taichi.mybasekoltin.R
import com.taichi.mybasekoltin.entity.LoginRegisterResponse
import com.taichi.mybasekoltin.mvpkt.base.BaseActivity
import com.taichi.mybasekoltin.mvpkt.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    override fun createP(): RegisterPresenter =RegisterPresenterImpl(this)

    override fun initListener() {
        user_register_bt.setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun getLayoutID(): Int =R.layout.activity_register
    override fun recycle() {
        persenter.unAttachView()
    }

    override fun RegisterSucc(registerBean: LoginRegisterResponse?) {
        Toast.makeText(this, "注册成功😀", Toast.LENGTH_SHORT).show()
    }

    override fun RegisterError(errorMsg: String?) {
        Toast.makeText(this, "注册失败 ~ 呜呜呜", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.user_register_bt-> {
               val usernameStr = user_phone_et.text.toString().trim()
               var passwordStr = user_password_et.text.toString().trim()
               persenter.registerWanAndroid(this@RegisterActivity,usernameStr, passwordStr, passwordStr)
           }
       }
    }
}
