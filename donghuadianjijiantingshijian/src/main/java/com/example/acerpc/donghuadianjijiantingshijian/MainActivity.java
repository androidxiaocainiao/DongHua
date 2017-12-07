package com.example.acerpc.donghuadianjijiantingshijian;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageview);
    }

    public void start(View view) {
        final ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "rotation", 0, 360
        );
        animator.setDuration(2000);
        animator.setRepeatCount(10);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (flag){
//                    /*
//                    在使用此暂停或者开始时要19版本
//                     */
//                    //让动画暂停
//                    animator.pause();
//                    flag = false;
//                }else{
//                    //让动画开始（从暂停的地方开始运动）
//                    flag = true;
//                    animator.resume();
//                }
//            }
//        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });

        /*animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.i("tag","======结束=============");
                btn.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.i("tag","======重复=============");
            }
        });*/

        /*animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                imageView.getLayoutParams().width = (int) value;
                imageView.getLayoutParams().height = (int) value;
                //通知imageView重绘
                imageView.requestLayout();
            }
        });*/
    }
}
