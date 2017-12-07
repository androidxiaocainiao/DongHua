package com.example.acerpc.donghuaxiaoxiangmu;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.ImageView;

/**
 * Created by acer pc on 2017/11/21.
 */
public class MyAnimator {

    /*
        开始时的分开动画
         */
    public void kaishi(ImageView imageView1, ImageView imageView2) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                imageView1, "translationX", 0f, -200
        );
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                imageView2, "translationX", 0f, 200
        );
        animator1.start();
        animator2.start();
    }

    /*
    显示动画
     */
    public void xianshiZi(ImageView imageView1) {
        ObjectAnimator animator_xianshi = ObjectAnimator.ofFloat(
                imageView1, "alpha", 0, 1
        );
        animator_xianshi.setDuration(4000);
        animator_xianshi.start();
    }

    public void xianshiZhu(ImageView imageView1) {
        ObjectAnimator animator_xianshi = ObjectAnimator.ofFloat(
                imageView1, "alpha", 0, 1
        );
        animator_xianshi.start();
    }

    /*
    隐藏动画
     */
    public void yincang(ImageView imageView1) {
        ObjectAnimator animator_yincang = ObjectAnimator.ofFloat(
                imageView1, "alpha", 0, 0
        );
        animator_yincang.start();
    }

    /*
    回归00点
     */
    public void huigui0dian(ImageView imageView1) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                imageView1, "translationX", 0f, 0f
        );
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                imageView1, "translationY", 0f, 0f
        );
        animator1.start();
        animator2.start();
    }

    /*
    点击分散
     */
    public void Fzhou(ImageView imageView, int X, int Y) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(
                imageView, "translationX", 0, X
        );
        animatorX.setDuration(4000);
        animatorX.setRepeatMode(ValueAnimator.RESTART);
        animatorX.start();

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(
                imageView, "translationY", 0, Y
        );
        animatorY.setDuration(4000);
        animatorY.setRepeatMode(ValueAnimator.RESTART);
        animatorY.start();
    }

    /*
    图片隐藏
     */
}
