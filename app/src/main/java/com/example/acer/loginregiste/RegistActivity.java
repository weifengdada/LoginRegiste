package com.example.acer.loginregiste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.loginregiste.bean.RegistBean;
import com.example.acer.loginregiste.callBack.RegistView;
import com.example.acer.loginregiste.presenter.RegistPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistActivity extends AppCompatActivity implements RegistView {

    @BindView(R.id.regist_mobile)
    EditText registMobile;
    @BindView(R.id.regist_password)
    EditText registPassword;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    private RegistPresenter registPresenter;
    private String m;
    private String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
        registPresenter = new RegistPresenter(this);

    }
    @Override
    public void success(RegistBean bean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,LoginActivity.class);
        intent.putExtra("mobile",m);
        intent.putExtra("password",p);
        startActivity(intent);

    }

    @OnClick(R.id.btn_regist)
    public void onViewClicked() {
        m = registMobile.getText().toString();
        p = registPassword.getText().toString();
       if(!TextUtils.isEmpty(m)&!TextUtils.isEmpty(p)){
            registPresenter.getData(m, p);
       }

    }
}
