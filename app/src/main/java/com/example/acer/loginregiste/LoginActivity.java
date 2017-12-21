package com.example.acer.loginregiste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.loginregiste.bean.LoginBean;
import com.example.acer.loginregiste.callBack.LoginView;
import com.example.acer.loginregiste.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.login_mobile)
    EditText loginMobile;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
     LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter=new LoginPresenter(this);
        Intent intent = getIntent();
        String mobile = intent.getStringExtra("mobile");
        String password = intent.getStringExtra("password");
        loginMobile.setText(mobile);
        loginPassword.setText(password);
    }
    @Override
    public void success(LoginBean bean) {
        Toast.makeText(this,bean.toString()+"bean"+bean.getMsg(), Toast.LENGTH_SHORT).show();
        System.out.println(bean.toString()+"bean"+bean.getMsg());
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {

        String m = loginMobile.getText().toString();
        String p = loginPassword.getText().toString();
        if(!TextUtils.isEmpty(m)&!TextUtils.isEmpty(p)){
            loginPresenter.getData(m,p);
        }
    }
}
