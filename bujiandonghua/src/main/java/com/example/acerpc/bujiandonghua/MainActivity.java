package com.example.acerpc.bujiandonghua;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView bujiandonghua_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buJianDongHua();
    }

    /**
     * 补间动画：
     * 用于平移，旋转，缩放，渐变不改变其属性
     */
    public void buJianDongHua() {
        bujiandonghua_imageview = (ImageView) findViewById(R.id.bujiandonghua_imageview);
    }

    public void pingyi(View view) {
        /*
        平移
         */
        // TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) 来定义动画
        //参数说明：
        //float fromXDelta 动画开始的点离当前View X坐标上的差值
        //float toXDelta 动画结束的点离当前View X坐标上的差值
        //float fromYDelta 动画开始的点离当前View Y坐标上的差值
        //float toYDelta 动画开始的点离当前View Y坐标上的差值

        //animation.setDuration(long durationMillis);//设置动画持续时间
        //animation.setRepeatCount(int i);//设置重复次数
        //animation.setRepeatMode(Animation.REVERSE);//设置反方向执行

        //Xml属性：
        //android:duration：运行动画的时间
        //android:repeatCount：定义动画重复的时间

        TranslateAnimation translate = new TranslateAnimation(
                0, 100, 0, 100);
        //设置动画的时间
        translate.setDuration(2000);
        //设置重复的次数
        translate.setRepeatCount(5);
        //设置是否停止到最后的位置
        translate.setFillAfter(true);
        //设置重复方式
        //REVERSE:重复开始
        translate.setRepeatMode(Animation.REVERSE);
        //设置加速方式
        translate.setInterpolator(this, android.R.anim.accelerate_decelerate_interpolator);
        bujiandonghua_imageview.startAnimation(translate);
    }

    public void xuanzhuan(View view) {
        /*
        旋转
         */

        /*
        RotateAnimation (float fromDegrees,
        float toDegrees, int pivotXType, float pivotXValue,
        int pivotYType, float pivotYValue)
        参数说明：
            float fromDegrees：旋转的开始角度。
            float toDegrees：旋转的结束角度。
            int pivotXType：X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
            float pivotXValue：X坐标的伸缩值。
            int pivotYType：Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
            float pivotYValue：Y坐标的伸缩值。
        */
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                //getPivotX() x枢轴点的位置。x枢轴点的位置。
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setRepeatMode(Animation.REVERSE);
        rotate.setDuration(3000);
        rotate.setRepeatCount(4);
        bujiandonghua_imageview.startAnimation(rotate);
    }

    public void suofang(View view) {
        //创建缩放动画
        //fromX起始大小
        //toX 最终大小
        //参数为图片的倍数
        ScaleAnimation scale = new ScaleAnimation(2.0f, 0.5f, 2.0f, 0.5f);
        scale.setDuration(4000);
        scale.setRepeatCount(2);
        scale.setRepeatMode(Animation.REVERSE);
        scale.setFillBefore(true);
        /*imageView.setAnimation(animation);
        animation.start();*/
        //animation.setFillAfter(true);
        bujiandonghua_imageview.startAnimation(scale);
    }

    public void touming(View view) {
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setRepeatMode(Animation.REVERSE);
        /*
        reverse反复运行A--B又从B--A
        restart重复运行A--B重复运行
        */
        alpha.setRepeatCount(20);
        alpha.setDuration(2000);
        bujiandonghua_imageview.startAnimation(alpha);
    }

    public void zonghe(View view) {
        //shareInterpolator是否共享
        AnimationSet set = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,//x相对于自己
                0.5f,//起始位置
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0f,
                Animation.RELATIVE_TO_SELF,
                0f
        );
        set.addAnimation(translateAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(
                0f,
                1000000f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
        );
        set.addAnimation(rotateAnimation);
//        bujiandonghua_imageview.setAnimation(set);
//        set.start();
        set.setDuration(50000);
        set.setRepeatCount(10);
        set.setRepeatMode(Animation.REVERSE);
        bujiandonghua_imageview.startAnimation(set);
        set.start();
    }
}
