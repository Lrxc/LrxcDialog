package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Dialog
 * Created by Lrxc on 2017/11/10.
 */

public class LoadDialog {
    private LoadDialog loadDialog;
    private Dialog dialog;
    private TextView msg;

    public LoadDialog(Context context) {
        loadDialog = this;
        initView(context);
    }

    //初始化
    private void initView(Context context) {
        if (dialog != null && dialog.isShowing()) dialog.cancel();

        dialog = new Dialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_load, null);
        msg = (TextView) view.findViewById(R.id.dialog_load_msg);
        //Android5.0以下去掉标题线(必须setContentView之前)
        dialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        //背景透明
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    //设置加载信息
    public LoadDialog setText(String text) {
        msg.setText(text);
        return loadDialog;
    }

    //设置空白是否可取消
    public LoadDialog setCanceledOnTouchOutside(boolean cancel) {
        dialog.setCanceledOnTouchOutside(cancel);
        return loadDialog;
    }

    //设置显示
    public void show() {
        dialog.show();
    }

    //设置隐藏
    public void dismiss() {
        dialog.dismiss();
    }
}
