package com.wangdong.www.demos;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView btn;
    private ObjectAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (ImageView) findViewById(R.id.aaaa);
        DoMeasure();
        Log.i("wangdong", "onCreate:endaaa "+btn.getMeasuredWidth()+btn.getMeasuredHeight());
        btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mAnimator = ObjectAnimator.ofFloat(btn, "scaleY", 0f,4f);			//2.为目标对象的属性变化设置监听器
                        LinearInterpolator linearInterpolator=new LinearInterpolator();
                        mAnimator.setInterpolator(linearInterpolator);
                        mAnimator.setDuration(400);
                        mAnimator.start();
                        Log.i("wangdong", "onCreate:end "+btn.getWidth()+btn.getHeight());

                    }
                });
    }
public void DoMeasure(){
    ViewTreeObserver vto2 = btn.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {
            btn.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            Log.i("wangdong", "onCreate: "+btn.getWidth()+btn.getHeight());
        }
    });
}

}
