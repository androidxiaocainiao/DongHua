package com.example.acerpc.shuxingdonghua;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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

    public void pingyi(View view) {
        /**
         * 单项执行第一种方式
         */
//        ObjectAnimator animatorX=ObjectAnimator.ofFloat(
//                imageview,"translationX",0.1f,500f,400f,300f,200f,100f);
//        animatorX.start();


        /**
         * 单项执行第二种方式
         */
//        ObjectAnimator animator = new ObjectAnimator();
//        animator.setTarget(imageview);
//        animator.setFloatValues(0.1f,600f,300f,600,450,600,525);
//
//        animator.setDuration(4000);
//        animator.setRepeatCount(5);
//
//        animator.setRepeatMode(ValueAnimator.RESTART);
//        animator.start();


        /**
         * 组合式
         */
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(
                imageview, "translationY", 0.1f, 500f, 300f, 500, 450, 500, 450);
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(
                imageview, "translationX", 0.1f, 400f, 200f, 300, 350, 300);

        AnimatorSet set = new AnimatorSet();
        /*
        play
         */
        set.play(animatorX).with(animatorY);//同时执行
        set.play(animatorY).before(animatorX);//
        set.setDuration(4000);
        set.start();


    }

    public void xuanzhuan(View view) {
        /**
         * 单项执行方式
         */
//        ObjectAnimator animator=ObjectAnimator.ofFloat(
//                imageview,"rotation",0,360,360);
//        animator.start();

        /**
         * 组合式
         */
        // rotation：一中心点为圆心
        // rotationX：以X轴为圆心
        // rotationY：以Y轴为圆心
        PropertyValuesHolder holderXY = PropertyValuesHolder.ofFloat(
                "rotation", 0, 360, 180);
        PropertyValuesHolder holderX = PropertyValuesHolder.ofFloat(
                "rotationX", 0, 360, 180);
        PropertyValuesHolder holderY = PropertyValuesHolder.ofFloat(
                "rotationY", 0, 360, 180);

        ObjectAnimator animator = ObjectAnimator.
                ofPropertyValuesHolder(imageview, holderXY, holderX, holderY);

        animator.setDuration(3000);
        animator.setRepeatCount(10);
        animator.start();
    }

    public void jiantou(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageview, "alpha", 1f, 0f, 0.5f);
        animator.setDuration(20000);
        animator.start();
    }

    public void shensuo(View view) {
//        ObjectAnimator holderX = ObjectAnimator.ofFloat(
//                imageview,"scaleX",0f,10f,2f,1f);
//        holderX.setDuration(2000);
//        holderX.start();
//        ObjectAnimator holderY = ObjectAnimator.ofFloat(
//                imageview,"scaleY",0f,10f,2f,1f);
//        holderY.setDuration(2000);
//        holderY.start();
        /*
        第一种组合方式
         */
//        ObjectAnimator holderX = ObjectAnimator.ofFloat(
//                imageview,"scaleX",0f,10f,2f,1f);
//        ObjectAnimator holderY = ObjectAnimator.ofFloat(
//                imageview,"scaleY",0f,10f,2f,1f);
//        AnimatorSet set=new AnimatorSet();
//        set.play(holderX).with(holderY);
//        set.setDuration(2000);
//        set.start();
        /*
        第二种组合方式
         */
        PropertyValuesHolder hodleX = PropertyValuesHolder.ofFloat(
                "scaleX", 0f, 2f, 3f, 1f);
        PropertyValuesHolder hodleY = PropertyValuesHolder.ofFloat(
                "scaleY", 0f, 2f, 3f, 1f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(
                imageview, hodleX, hodleY);
        animator.setDuration(3000);
        animator.setRepeatCount(5);
        animator.start();
    }

    public void zonghe(View view) {
        /*
        第三种组合
         */
        //第一步通过控件获取View的属性动画对象
        ViewPropertyAnimator animator = imageview.animate();
//        animator.translationXBy(0).rotationX(200);
//        animator.translationYBy(0).rotationY(200);
////        animator.rotation(360*3);
//        animator.rotationXBy(360*3).rotationX(360*3);
//        animator.rotationYBy(360*3).rotationY(360*3);
        animator.scaleXBy(30).scaleX(2);
        animator.setDuration(2000);
        animator.start();
    }
}
