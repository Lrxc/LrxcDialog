package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dialog.LoadDialog;
import com.example.dialog.OnClickBtnListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new LoadDialog(this)
                .setText("内容内容")
                .setButton("确定", new OnClickBtnListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }
}
