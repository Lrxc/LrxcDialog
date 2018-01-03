package com.example.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Lrxc on 2018/1/3 12:19.
 * Email: Lrxc1117@163.com
 * <p>
 * 自定义进度条Dialog
 */

public class ProgressDialog extends Dialog implements View.OnClickListener {
    private OnClickListener listener;
    private ProgressBar progressBar;
    private TextView title, tv, btn;

    public ProgressDialog(@NonNull Context context) {
        super(context);
        initView(context);
    }

    //显示进度条
    private void initView(Context context) {
        View view = View.inflate(context, R.layout.dialog_progress, null);
        progressBar = view.findViewById(R.id.progressBar);
        title = view.findViewById(R.id.title);
        tv = view.findViewById(R.id.tv);
        btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(this);

        //去掉标题线
        requestWindowFeature(android.view.Window.FEATURE_NO_TITLE);
        setContentView(view);
        //点击外面不取消
        setCanceledOnTouchOutside(false);
        //背景透明
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            listener.onClick(this, 0);
        }
    }

    /**
     * 设置标题
     *
     * @param text
     * @return
     */
    public ProgressDialog setTitle(String text) {
        //显示标题
        title.setVisibility(View.VISIBLE);
        title.setText(text);
        return this;
    }

    /**
     * 设置加载进度
     *
     * @param progress
     * @return
     */
    public ProgressDialog setProgress(int progress) {
        progressBar.setProgress(progress);
        return this;
    }

    /**
     * 设置加载进度信息
     *
     * @param text 10/100
     * @return
     */
    public ProgressDialog setText(String text) {
        tv.setText(text);
        return this;
    }

    /**
     * 设置按钮的信息
     *
     * @param text
     * @return
     */
    public ProgressDialog setButton(String text, OnClickListener listener) {
        this.listener = listener;
        //显示按钮
        btn.setVisibility(View.VISIBLE);
        btn.setText(text);
        return this;
    }

    /**
     * 设置空白处是否可取消
     *
     * @param cancel
     * @return
     */
    public ProgressDialog canceledOnTouchOutside(boolean cancel) {
        setCanceledOnTouchOutside(cancel);
        return this;
    }

    /**
     * 设置是否可取消
     *
     * @param cancel
     * @return
     */
    public ProgressDialog cancelable(boolean cancel) {
        setCancelable(cancel);
        return this;
    }
}
