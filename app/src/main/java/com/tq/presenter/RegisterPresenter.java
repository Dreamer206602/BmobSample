package com.tq.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.tq.IListener.IUserBiz;
import com.tq.IListener.OnRegisterListener;
import com.tq.IListener.biz.UserBiz;
import com.tq.activity.LoginActivity;
import com.tq.view.IUserRegisterView;

/**
 * Created by boobooL on 2016/4/12 0012
 * Created 邮箱 ：boobooMX@163.com
 */
public class RegisterPresenter {
    private IUserBiz mUserBiz;
    private IUserRegisterView mUserRegisterView;
    private Context mContext;

    public RegisterPresenter(Context context, IUserRegisterView userRegisterView) {
        mContext = context;
        mUserRegisterView = userRegisterView;
        this.mUserBiz=new UserBiz();
    }

    public void register(){
        if(TextUtils.isEmpty(mUserRegisterView.getPsd())||TextUtils.isEmpty(mUserRegisterView.getUsername())||
        TextUtils.isEmpty(mUserRegisterView.getConPsd())||TextUtils.isEmpty(mUserRegisterView.getEmail())){
            mUserRegisterView.ErrorOfUsnorPsdorEmail();
            return;
        }

        if(!mUserRegisterView.getConPsd().endsWith(mUserRegisterView.getPsd())){
            mUserRegisterView.ErrorOfConfingerPsd();
            return;
        }
        mUserRegisterView.showLoading();
        mUserBiz.register(mUserRegisterView.getUsername(), mUserRegisterView.getPsd(),
                mUserRegisterView.getEmail(), new OnRegisterListener() {
                    @Override
                    public void OnSuccess() {
                        mUserRegisterView.hideLoading();
                        mUserRegisterView.Success();
                        mUserRegisterView.FinishAty();

                    }

                    @Override
                    public void OnError() {
                        mUserRegisterView.hideLoading();
                        mUserRegisterView.Failed();

                    }
                },mUserRegisterView.getContext());
    }

    //跳转到注册的页面
    public  void  toLoginActivity(){
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
    }

}
