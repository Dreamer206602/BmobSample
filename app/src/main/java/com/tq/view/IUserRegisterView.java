package com.tq.view;

import android.content.Context;

/**
 * Created by boobooL on 2016/4/12 0012
 * Created 邮箱 ：boobooMX@163.com
 */
public interface IUserRegisterView {
    void Success();
    void Failed();
    void showLoading();
    void hideLoading();
    void FinishAty();
    String getUsername();
    String getPsd();
    String getEmail();
    String getConPsd();
    Context getContext();
    void ErrorOfUsnorPsdorEmail();
    void ErrorOfConfingerPsd();
}
