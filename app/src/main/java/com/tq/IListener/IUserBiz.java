package com.tq.IListener;

import android.content.Context;

/**
 * Created by boobooL on 2016/4/12 0012
 * Created 邮箱 ：boobooMX@163.com
 */
public interface IUserBiz {
    void login(String userName, String password, OnLoginListener loginListener, Context context);
    void register(String userName,String password,String email,OnRegisterListener registerListener,Context context);
}
