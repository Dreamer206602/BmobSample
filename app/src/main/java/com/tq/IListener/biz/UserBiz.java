package com.tq.IListener.biz;

import android.content.Context;

import com.tq.IListener.IUserBiz;
import com.tq.IListener.OnLoginListener;
import com.tq.IListener.OnRegisterListener;
import com.tq.bean.User;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by boobooL on 2016/4/12 0012
 * Created 邮箱 ：boobooMX@163.com
 */
public class UserBiz implements IUserBiz {

    @Override
    public void login(String userName, String password, final OnLoginListener loginListener, Context context) {

        final User user=new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.login(context, new SaveListener() {
            @Override
            public void onSuccess() {
                loginListener.OnSuccess(user);
            }

            @Override
            public void onFailure(int i, String s) {
                loginListener.OnFailed();
            }
        });
    }

    @Override
    public void register(String userName, String password, String email, final OnRegisterListener registerListener, Context context) {
            User user=new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.signUp(context, new SaveListener() {
            @Override
            public void onSuccess() {
                registerListener.OnSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
                registerListener.OnError();
            }
        });
    }
}
