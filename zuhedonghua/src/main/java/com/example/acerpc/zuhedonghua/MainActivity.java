package com.example.acerpc.zuhedonghua;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview = (ImageView) findViewById(R.id.imageview);
    }

    public void donghua01(View view) {
//设置动画平移
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imageview, "translationX", 0, 300);
        animatorX.setDuration(2000);
        animatorX.setRepeatCount(4);
        animatorX.setRepeatMode(ValueAnimator.RESTART);
        //animatorX.start();
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imageview, "translationY", 0, 400);
        animatorY.setDuration(2000);
        animatorY.setRepeatCount(4);
        animatorY.setRepeatMode(ValueAnimator.RESTART);
        //animatorY.start();

        ObjectAnimator rotatorX = ObjectAnimator.ofFloat(imageview, "rotation", 0, 360);
        rotatorX.setDuration(2000);
        rotatorX.setRepeatCount(4);//执行时执行五次
        rotatorX.setRepeatMode(ValueAnimator.RESTART);
        AnimatorSet set = new AnimatorSet();
        /**
         * play(Animator pl)开始执行的动画
         * with(Animator wi)  pl和wi一起执行
         * before(Animator  be) pl在be之前执行
         * after(Animator af)pl在af之后执行
         * setStartDelay(long l)设置动画在多长世间之后执行
         * 动画如果被使用，再不能被重复利用
         */
        //定义中组合动画的方式
        /**
         * 可以优先执行某一个动画
         */
        //先执行旋转在执行X轴平移最后Y轴
        set.play(animatorX).before(animatorY).after(rotatorX);
        set.setStartDelay(2000);//执行时几秒之后开始执行
        set.start();
    }

    public void donghua03(View view) {
/**
 * 这种方式执行的组合动画 不能单个执行
 */
        PropertyValuesHolder holder01 =
                PropertyValuesHolder.ofFloat("translationX", 0, 300);
        PropertyValuesHolder holder02 =
                PropertyValuesHolder.ofFloat("translationY", 0, 400);
        PropertyValuesHolder holder03 =
                PropertyValuesHolder.ofFloat("rotationX", 0, 360);
        PropertyValuesHolder holder04 = PropertyValuesHolder.ofFloat("rotationY", 0, 360);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageview, holder01, holder02, holder03, holder04);
        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(5);
        animator.setStartDelay(1000);
        /*
        因为版本太低所以无法执行
        最低要18的版本
         */
        //animator.setAutoCancel(true);
        animator.start();
    }

    public void donghua02(View view) {
/**
 * 通过这种执行的动画只能执行一次
 */
        ViewPropertyAnimator animate = imageview.animate();
        animate.translationX(300).translationXBy(0)
                .translationYBy(0).translationY(400)
                .rotationX(360).rotationXBy(0)
                .rotationYBy(0).rotationY(360)
                .rotation(360).setDuration(2000)
                .setStartDelay(1000)
                .start();
    }


    public void donghuaXML01(View view) {
        ObjectAnimator animator1 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.translationy
        );
        animator1.setTarget(imageview);
        animator1.start();
        ObjectAnimator animator2 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.translation
        );
        animator2.setTarget(imageview);
        animator2.start();
        ObjectAnimator animator3 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.rotation
        );
        animator3.setTarget(imageview);
        animator3.start();
    }

    public void donghuaXML02(View view) {
        AnimatorSet animator4 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.animationset
        );
        animator4.setTarget(imageview);
        animator4.start();
    }
}
