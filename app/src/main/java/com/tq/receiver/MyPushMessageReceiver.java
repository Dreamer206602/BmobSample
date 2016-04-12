package com.tq.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import cn.bmob.push.PushConstants;

/**
 * Created by boobooL on 2016/4/12 0012
 * Created 邮箱 ：boobooMX@163.com
 */
public class MyPushMessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        if(intent.getAction().equals(PushConstants.ACTION_MESSAGE)){
            Log.d("bmob", "客户端收到推送内容："+intent.getStringExtra("msg"));
        }
    }
}
