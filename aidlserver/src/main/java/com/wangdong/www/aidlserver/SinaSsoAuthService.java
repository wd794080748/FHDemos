package com.wangdong.www.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.wangdong.www.aidlservice.SsoAuth;

public class SinaSsoAuthService extends Service {
    SinaSsoImpl mBinder=new SinaSsoImpl();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("wangdong","####### sso auth created");
    }

    public SinaSsoAuthService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
    class SinaSsoImpl extends SsoAuth.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void ssoAuth(String userName, String pwd) throws RemoteException {
            Log.i("wangdong", "ssoAuth: 这里是新浪客户端，执行SSO登录啦，用户名："+userName+",密码："+pwd);
        }
    }
}
