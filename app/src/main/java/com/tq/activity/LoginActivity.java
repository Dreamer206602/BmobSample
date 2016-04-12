package com.tq.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tq.R;
import com.tq.bean.User;
import com.tq.presenter.LoginPresenter;
import com.tq.view.IUserLoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

public class LoginActivity extends AppCompatActivity implements IUserLoginView, View.OnClickListener {

    @Bind(R.id.User_Name)
    EditText mUserName;
    @Bind(R.id.User_Psd)
    EditText mUserPsd;
    @Bind(R.id.Login)
    Button mLogin;
    @Bind(R.id.tvWeibo)
    LinearLayout mTvWeibo;
    @Bind(R.id.tvQq)
    LinearLayout mTvQq;
    @Bind(R.id.login_progress)
    ProgressBar mLoginProgress;
    @Bind(R.id.forget_psd)
    TextView mForgetPsd;
    @Bind(R.id.register)
    TextView mRegister;

    private LoginPresenter mLoginPresenter=new LoginPresenter(this,this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mTvQq.setOnClickListener(this);
        mTvWeibo.setOnClickListener(this);
        mForgetPsd.setOnClickListener(this);

//        User bmobUser= BmobUser.getCurrentUser(this,User.class);
//        if(bmobUser!=null){
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            LoginActivity.this.finish();
//            return;
//        }
        // 初始化BmobSDK
        Bmob.initialize(this, "7cdff4a819f558aad9f62a8ecc9ae33f");
    }

    @Override
    public String getUserName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getPassword() {
        return mUserPsd.getText().toString();
    }

    @Override
    public void showLoading() {
            mLoginProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
            mLoginProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toHomeActivity(User user) {
            mLoginPresenter.toHomeActivity();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(LoginActivity.this
                , "用户名或者密码错误", Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return LoginActivity.this;
    }

    @Override
    public void ErrorOfUsnAndPsd() {
        if (TextUtils.isEmpty(mUserName.getText().toString()) || TextUtils.isEmpty(mUserPsd.getText().toString())) {
            showFailedError();
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Login:
                mLoginPresenter.login();
                break;
            case R.id.register:
                mLoginPresenter.toRegisterActivity();
                break;
//            case R.id.forget_psd:
            case R.id.tvQq:
                Toast.makeText(LoginActivity.this,"Sorry，该功能还未开放！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvWeibo:
                Toast.makeText(getApplicationContext(),"Sorry，该功能还未开放！",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter=null;
    }
}
