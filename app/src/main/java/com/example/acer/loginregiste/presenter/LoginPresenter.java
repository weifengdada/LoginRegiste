package com.example.acer.loginregiste.presenter;

import com.example.acer.loginregiste.LoginActivity;
import com.example.acer.loginregiste.bean.LoginBean;
import com.example.acer.loginregiste.bean.RegistBean;
import com.example.acer.loginregiste.callBack.LoginModelCallBack;
import com.example.acer.loginregiste.callBack.LoginView;
import com.example.acer.loginregiste.callBack.RegistModelCallBack;
import com.example.acer.loginregiste.model.LoginModel;

/**
 * Created by acer on 2017/12/21.
 */

public class LoginPresenter {
    LoginView loginView;
    LoginModel loginModel;
    public LoginPresenter(LoginView loginView) {
        this.loginView=loginView;
        this.loginModel=new LoginModel();
    }

    public void getData(String m, String p) {

         loginModel.getData(new LoginModelCallBack() {
             @Override
             public void success(LoginBean bean) {
               if(loginView!=null){
                   loginView.success(bean);
               }
             }
         },m,p);


    }
}
