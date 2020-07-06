package com.taichi.mybasekoltin.mvpkt.login

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.taichi.mybasekoltin.MainActivity
import com.taichi.mybasekoltin.R
import com.taichi.mybasekoltin.entity.LoginRegisterResponse
import com.taichi.mybasekoltin.mvpkt.base.BaseActivity
import com.taichi.mybasekoltin.mvpkt.rigister.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

//LoginView的实现
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    override fun createP(): LoginPresenter = LoginPresentrImpl(this)

    override fun getLayoutID(): Int = R.layout.activity_login

    override fun recycle() {
        persenter.unAttachView()
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        //登录成功
        Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun loginFialure(errorMsg: String?) {
        //登录失败
        Toast.makeText(this@LoginActivity, "登录失败：$errorMsg", Toast.LENGTH_SHORT).show()
    }

    override fun initListener() {
        user_login_bt.setOnClickListener(onClickListener)
        user_register_tv.setOnClickListener(onClickListener)
    }

    @SuppressLint("LogNotTimber")
    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.user_login_bt -> {
                val userNameStr = user_phone_et.text.toString().trim()
                val userPwdStr = user_password_et.text.toString()
                Log.d("LoginActivity", "userName:$userNameStr,  userPwd:$userPwdStr")
                // Log.i("LoginActivity", " R.id.tv_1 ")
                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (imm.isActive()) {
                    // 如果开启
                    imm.hideSoftInputFromWindow(
                        getCurrentFocus()?.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS
                    )
                }
                persenter.loginAction(this@LoginActivity, userNameStr, userPwdStr)
            }
            R.id.user_register_tv -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun initData() {
        //可以做一些初始化数据操作
    }


}
