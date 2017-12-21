package com.example.acer.loginregiste.model;

import com.example.acer.loginregiste.IGetDataBase;
import com.example.acer.loginregiste.bean.RegistBean;
import com.example.acer.loginregiste.callBack.RegistModelCallBack;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acer on 2017/12/21.
 */

public class RegistModel {

    public void getData(final RegistModelCallBack registModelCallBack, String m, String p) {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://120.27.23.105/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGetDataBase iGetDataBase = retrofit.create(IGetDataBase.class);

        Observable<RegistBean> registBeanObservable = iGetDataBase.get(m, p);
        registBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegistBean>() {
                    @Override
                    public void accept(RegistBean bean) throws Exception {
                        registModelCallBack.success(bean);
                    }
                });



    }
}
