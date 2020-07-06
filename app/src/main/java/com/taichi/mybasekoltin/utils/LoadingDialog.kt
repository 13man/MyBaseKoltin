package com.taichi.mybasekoltin.utils

import android.app.Dialog
import android.content.Context
import com.taichi.mybasekoltin.R

//单例
object LoadingDialog {
    // 内部生成的时候 根据INSTANCE  看起来感觉是 静态 因为可以 LoadingDialog.show
    private var dialog: Dialog? = null


    fun show(context: Context) {
        cancel()
        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }

    fun cancel() {
        dialog?.dismiss()
    }

}