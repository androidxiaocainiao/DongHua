package com.example.acerpc.donghua;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView zhendonghua_imageview;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zhenDongHua();
    }

    /**
     * 帧动画：
     * 此动画正能用于图片的变换
     */
    public void zhenDongHua() {
        zhendonghua_imageview = (ImageView) findViewById(R.id.zhendonghua_imageview);
        drawable = (AnimationDrawable) zhendonghua_imageview.getDrawable();
        drawable.start();
        /**
         * drawable.start();开始
         * drawable.stop();停止
         */
    }


}
