package com.example.acer.loginregiste.presenter;

import com.example.acer.loginregiste.RegistActivity;
import com.example.acer.loginregiste.bean.RegistBean;
import com.example.acer.loginregiste.callBack.RegistModelCallBack;
import com.example.acer.loginregiste.callBack.RegistView;
import com.example.acer.loginregiste.model.RegistModel;

/**
 * Created by acer on 2017/12/21.
 */

public class RegistPresenter {
    RegistView registView;
    RegistModel registModel;
    public RegistPresenter(RegistView registView) {
        this.registView=registView;
        this.registModel=new RegistModel();
    }

    public void getData(String m, String p) {


       registModel.getData(new RegistModelCallBack() {
           @Override
           public void success(RegistBean bean) {
                if(registView!=null){
                    registView.success(bean);

                }
           }
       },m,p);


    }
}
