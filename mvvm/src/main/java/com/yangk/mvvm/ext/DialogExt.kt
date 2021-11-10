package com.yangk.mvvm.ext

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog

/**
 * 作者　: yangk
 * 时间　: 2020/11/18
 * 描述　:
 */
/**
 * 显示消息弹窗
 * @param message 显示对话框的内容 必填项
 * @param title 显示对话框的标题 默认 温馨提示
 * @param positiveButtonText 确定按钮文字 默认确定
 * @param positiveAction 点击确定按钮触发的方法 默认空方法
 * @param negativeButtonText 取消按钮文字 默认空 不为空时显示该按钮
 * @param negativeAction 点击取消按钮触发的方法 默认空方法
 *
 */
fun AppCompatActivity.showDialogMessage(
    message: String,
    title: String = "温馨提示",
    positiveButtonText: String = "确定",
    positiveAction: () -> Unit = {},
    negativeButtonText: String = "",
    negativeAction: () -> Unit = {}
) {
    if (!this.isFinishing) {
        MaterialDialog(this)
            .cornerRadius(8f)
            .cancelOnTouchOutside(false)
            .show {
                title(text = title)
                message(text = message)
                positiveButton(text = positiveButtonText) {
                    positiveAction.invoke()
                }
                if (negativeButtonText.isNotEmpty()) {
                    negativeButton(text = negativeButtonText) {
                        negativeAction.invoke()
                    }
                }
            }
    }
}

/**
 * @param message 显示对话框的内容 必填项
 * @param title 显示对话框的标题 默认 温馨提示
 * @param positiveButtonText 确定按钮文字 默认确定
 * @param positiveAction 点击确定按钮触发的方法 默认空方法
 * @param negativeButtonText 取消按钮文字 默认空 不为空时显示该按钮
 * @param negativeAction 点击取消按钮触发的方法 默认空方法
 */
fun Fragment.showDialogMessage(
    message: String,
    title: String = "温馨提示",
    positiveButtonText: String = "确定",
    positiveAction: () -> Unit = {},
    negativeButtonText: String = "",
    negativeAction: () -> Unit = {}
) {
    activity?.let {
        if (!it.isFinishing) {
            MaterialDialog(it)
                .cancelOnTouchOutside(false)
                .cornerRadius(8f)
                .show {
                    title(text = title)
                    message(text = message)
                    positiveButton(text = positiveButtonText) {
                        positiveAction.invoke()
                    }
                    if (negativeButtonText.isNotEmpty()) {
                        negativeButton(text = negativeButtonText) {
                            negativeAction.invoke()
                        }
                    }
                }
        }
    }
}




