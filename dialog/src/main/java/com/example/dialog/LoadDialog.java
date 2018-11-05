package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Lrxc on 2017/11/10.
 * Email: Lrxc1117@163.com
 * <p>
 * 自定义LoadDialog
 */

public class LoadDialog extends Dialog {
    private TextView msg, btn;

    public LoadDialog(@NonNull Context context) {
        super(context);
        initView(context);
    }

    //初始化
    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_load, null);
        msg = (TextView) view.findViewById(R.id.dialog_load_msg);
        btn = (TextView) view.findViewById(R.id.dialog_load_btn);

        //Android5.0以下去掉标题线(必须setContentView之前)
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        setContentView(view);
        //默认点击空白处不消失
        setCanceledOnTouchOutside(false);
        //背景透明
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        show();
    }

    /**
     * 设置加载信息
     *
     * @param text
     * @return
     */
    public LoadDialog setText(String text) {
        msg.setText(text);
        return this;
    }

    /**
     * 设置加载信息
     *
     * @param text 右下角按钮
     * @return
     */
    public LoadDialog setButton(String text, final OnClickBtnListener onClickListener) {
        btn.setVisibility(View.VISIBLE);
        btn.setText(text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(v);
                dismiss();
            }
        });
        return this;
    }


    /**
     * 设置空白处是否可取消
     *
     * @param cancel
     * @return
     */
    public LoadDialog canceledOnTouchOutside(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        return this;
    }

    /**
     * 设置是否可取消
     *
     * @param cancel
     * @return
     */
    public LoadDialog cancelable(boolean cancel) {
        setCancelable(cancel);
        return this;
    }
}
