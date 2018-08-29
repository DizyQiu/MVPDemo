package com.comwave.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IShowView, View.OnClickListener {
    private TextView textShow;
    private IPresenter iPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        textShow = findViewById(R.id.textShow);
        Button btnToast = findViewById(R.id.btnToast);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btnToast.setOnClickListener(this);

        iPresenter = new PresenterComl(this);
    }

    @Override
    public void show(String str) {
        textShow.setText(str);

    }

    @Override
    public void shoeToast(String str) {
        Toast.makeText(this, str + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            iPresenter.show();
        }

        if (v.getId() == R.id.btnToast) {
            iPresenter.showToast();
        }

    }
}
