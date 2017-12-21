package com.example.acer.loginregiste;

import com.example.acer.loginregiste.bean.LoginBean;
import com.example.acer.loginregiste.bean.RegistBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by acer on 2017/12/21.
 */

public interface IGetDataBase {
    @GET("user/reg")
    Observable<RegistBean> get(@Query("mobile") String mobile, @Query("password") String password);
    @GET("user/login")
    Observable<LoginBean> get2(@Query("mobile") String mobile, @Query("password") String password);
}
