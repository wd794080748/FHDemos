package com.wangdong.www.aidlservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SsoAuth mSsoAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.ssoh_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSsoAuth==null){
                    bindSsoAuthService();
                }else {
                    doSsoAuth();
                }
            }
        });
    }



    private void doSsoAuth() {
        try {
            mSsoAuth.ssoAuth("Mr.Mai","123456");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    private void bindSsoAuthService() {
        Intent intent=new Intent();
        intent.setAction("com.wangdong.www.aidlserver.SinaSsoAuthService");
        intent.setPackage("com.wangdong.www.aidlserver");
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mSsoAuth=SsoAuth.Stub.asInterface(service);
            doSsoAuth();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mSsoAuth=null;
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}
