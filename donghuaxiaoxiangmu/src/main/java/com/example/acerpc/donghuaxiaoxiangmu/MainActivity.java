package com.example.acerpc.donghuaxiaoxiangmu;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iamgeview1, iamgeview2,
            imageview_shenghuoxiuxian, imageview_suxingyuyangsheng,
            imageview_zhichangjingying, imageview_zhutihuodong,
            imageview_zaizhizhe, imageview_jingyingzhe, imageview_chuxuezhe;
    private ImageView image_c1, image_c2, image_c3, image_c4, image_c5,
            image_j1, image_j2, image_j3, image_j4, image_j5, image_j6,
            image_z1, image_z2, image_z3, image_z4, image_z5;
    private MyAnimator animator;

    private List<ImageView> list0 = new ArrayList<>();
    private List<ImageView> liatTupian = new ArrayList<>();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiview();
        tupian();
    }

    private void tupian() {
        liatTupian.add(image_c1);
        liatTupian.add(image_c2);
        liatTupian.add(image_c3);
        liatTupian.add(image_c4);
        liatTupian.add(image_c5);
        liatTupian.add(image_j1);
        liatTupian.add(image_j2);
        liatTupian.add(image_j3);
        liatTupian.add(image_j4);
        liatTupian.add(image_j5);
        liatTupian.add(image_j6);
        liatTupian.add(image_z1);
        liatTupian.add(image_z2);
        liatTupian.add(image_z3);
        liatTupian.add(image_z4);
        liatTupian.add(image_z5);
    }

    private void intiview() {
        xiaotupiandianji();
        iamgeview1 = (ImageView) findViewById(R.id.iamgeview1);
        iamgeview2 = (ImageView) findViewById(R.id.iamgeview2);
        button = (Button) findViewById(R.id.button);

        imageview_shenghuoxiuxian = (ImageView) findViewById(R.id.imageview_shenghuoxiuxian);
        imageview_suxingyuyangsheng = (ImageView) findViewById(R.id.imageview_suxingyuyangsheng);
        imageview_zhichangjingying = (ImageView) findViewById(R.id.imageview_zhichangjingying);
        imageview_zhutihuodong = (ImageView) findViewById(R.id.imageview_zhutihuodong);

        imageview_zaizhizhe = (ImageView) findViewById(R.id.imageview_zaizhizhe);
        imageview_jingyingzhe = (ImageView) findViewById(R.id.imageview_jingyingzhe);
        imageview_chuxuezhe = (ImageView) findViewById(R.id.imageview_chuxuezhe);

        animator = new MyAnimator();
        animator.kaishi(iamgeview1, iamgeview2);
        //把图片存入Listview当中并隐藏的方法
        listviewYinCang();

        button.setOnClickListener(this);
        iamgeview1.setOnClickListener(this);
        iamgeview2.setOnClickListener(this);

        imageview_zaizhizhe.setOnClickListener(this);
        imageview_jingyingzhe.setOnClickListener(this);
        imageview_chuxuezhe.setOnClickListener(this);
    }

    private void listviewYinCang() {
        list0.add(imageview_shenghuoxiuxian);
        list0.add(imageview_suxingyuyangsheng);
        list0.add(imageview_zhichangjingying);
        list0.add(imageview_zhutihuodong);
        list0.add(imageview_zaizhizhe);
        list0.add(imageview_jingyingzhe);
        list0.add(imageview_chuxuezhe);
        list0.add(image_c1);
        list0.add(image_c2);
        list0.add(image_c3);
        list0.add(image_c4);
        list0.add(image_c5);
        list0.add(image_j1);
        list0.add(image_j2);
        list0.add(image_j3);
        list0.add(image_j4);
        list0.add(image_j5);
        list0.add(image_j6);
        list0.add(image_z1);
        list0.add(image_z2);
        list0.add(image_z3);
        list0.add(image_z4);
        list0.add(image_z5);
        //开始时图片隐藏
        for (int i = 0; i < list0.size(); i++) {
            animator.yincang(list0.get(i));
            animator.huigui0dian(list0.get(i));
        }
    }

    private void xiaotupiandianji() {
        image_c1 = (ImageView) findViewById(R.id.image_c1);
        image_c2 = (ImageView) findViewById(R.id.image_c2);
        image_c3 = (ImageView) findViewById(R.id.image_c3);
        image_c4 = (ImageView) findViewById(R.id.image_c4);
        image_c5 = (ImageView) findViewById(R.id.image_c5);

        image_j1 = (ImageView) findViewById(R.id.image_j1);
        image_j2 = (ImageView) findViewById(R.id.image_j2);
        image_j3 = (ImageView) findViewById(R.id.image_j3);
        image_j4 = (ImageView) findViewById(R.id.image_j4);
        image_j5 = (ImageView) findViewById(R.id.image_j5);
        image_j6 = (ImageView) findViewById(R.id.image_j6);

        image_z1 = (ImageView) findViewById(R.id.image_z1);
        image_z2 = (ImageView) findViewById(R.id.image_z2);
        image_z3 = (ImageView) findViewById(R.id.image_z3);
        image_z4 = (ImageView) findViewById(R.id.image_z4);
        image_z5 = (ImageView) findViewById(R.id.image_z5);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                /*
                解除禁止点击
                 */
                iamgeview1.setEnabled(true);
                iamgeview2.setEnabled(true);
                chongxin();
                break;
            case R.id.iamgeview1://爱好者
                Log.i("tag", "===============aihaozhe");
                ObjectAnimator animator_aihaozhe = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        this, R.animator.aihaozhehe
                );
                animator_aihaozhe.setTarget(iamgeview1);
                animator_aihaozhe.start();

                ObjectAnimator animatorSet_aihaozhe = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        this, R.animator.meiyierenhe
                );
                animatorSet_aihaozhe.setTarget(iamgeview2);
                animatorSet_aihaozhe.start();

                /*ObjectAnimator animator_aihaozhe1 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        this, R.animator.yin
                );
                animator_aihaozhe1.setTarget(iamgeview2);
                animator_aihaozhe1.start();*/
                animatorSet_aihaozhe.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        //aihaoSan();
                    }
                });
                //iamgeview2.setEnabled(false);
                //iamgeview1.setEnabled(false);
                break;
            case R.id.iamgeview2://美业人
                Log.i("tag", "===============meiyeren");
                ObjectAnimator animatorSet_meiyeren = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        this, R.animator.meiyierenhe
                );
                animatorSet_meiyeren.setTarget(iamgeview2);
                animatorSet_meiyeren.start();
                animatorSet_meiyeren.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        Log.i("tag", "===============结束meiyeren");
                        meiyierenSan();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

                ObjectAnimator animator_meiyeren = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        this, R.animator.aihaozhehe
                );
                animator_meiyeren.setTarget(iamgeview1);
                animator_meiyeren.start();

                ObjectAnimator animator1_meiyeren = (ObjectAnimator) AnimatorInflater.loadAnimator(
                        this, R.animator.yin
                );
                animator1_meiyeren.setTarget(iamgeview1);
                animator1_meiyeren.start();
                iamgeview2.setEnabled(false);
                iamgeview1.setEnabled(false);
                break;
            case R.id.imageview_zaizhizhe:
                AnimatorSet animatorSet1 = (AnimatorSet) AnimatorInflater.loadAnimator(
                        this, R.animator.zaizhizhe
                );
                animatorSet1.setTarget(imageview_zaizhizhe);
                animatorSet1.start();
                zaizhizhe();
                break;
            case R.id.imageview_jingyingzhe:
                AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(
                        this, R.animator.jingyingzhe
                );
                animatorSet2.setTarget(imageview_jingyingzhe);
                animatorSet2.start();
                jingyingzhe();
                break;
            case R.id.imageview_chuxuezhe:
                AnimatorSet animatorSet3 = (AnimatorSet) AnimatorInflater.loadAnimator(
                        this, R.animator.chuxuezhe
                );
                animatorSet3.setTarget(imageview_chuxuezhe);
                animatorSet3.start();
                chuxuezhe();
                break;
        }
    }

    //经营者
    private void jingyingzhe() {
        for (int j = 0; j < liatTupian.size(); j++) {
            animator.huigui0dian(liatTupian.get(j));
        }
        List<ImageView> list2 = new ArrayList<>();
        list2.add(image_j1);
        list2.add(image_j2);
        list2.add(image_j3);
        list2.add(image_j4);
        list2.add(image_j5);
        list2.add(image_j6);
        for (int i = 0; i < list2.size(); i++) {
            animator.xianshiZhu(list2.get(i));
        }
        ObjectAnimator animator_j1 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.hao1
        );
        animator_j1.setTarget(image_j1);
        animator_j1.start();
        AnimatorSet animator_j2 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao2
        );
        animator_j2.setTarget(image_j2);
        animator_j2.start();
        AnimatorSet animator_j3 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao3
        );
        animator_j3.setTarget(image_j3);
        animator_j3.start();
        ObjectAnimator animator_j4 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.hao4
        );
        animator_j4.setTarget(image_j4);
        animator_j4.start();
        AnimatorSet animator_j5 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao5
        );
        animator_j5.setTarget(image_j5);
        animator_j5.start();
        AnimatorSet animator_j6 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao6
        );
        animator_j6.setTarget(image_j6);
        animator_j6.start();
    }

    //初学者
    private void chuxuezhe() {
        for (int j = 0; j < liatTupian.size(); j++) {
            animator.huigui0dian(liatTupian.get(j));
        }
        List<ImageView> list3 = new ArrayList<>();
        list3.add(image_c1);
        list3.add(image_c2);
        list3.add(image_c3);
        list3.add(image_c4);
        list3.add(image_c5);
        for (int i = 0; i < list3.size(); i++) {
            animator.xianshiZhu(list3.get(i));
        }
        ObjectAnimator animator_c1 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.hao1
        );
        animator_c1.setTarget(image_c1);
        animator_c1.start();
        AnimatorSet animator_c2 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao2
        );
        animator_c2.setTarget(image_c2);
        animator_c2.start();
        AnimatorSet animator_c3 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao3
        );
        animator_c3.setTarget(image_c3);
        animator_c3.start();
        ObjectAnimator animator_c4 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.hao4
        );
        animator_c4.setTarget(image_c4);
        animator_c4.start();
        AnimatorSet animator_c5 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao5
        );
        animator_c5.setTarget(image_c5);
        animator_c5.start();
    }

    //在职者图片
    private void zaizhizhe() {
        for (int j = 0; j < liatTupian.size(); j++) {
            animator.huigui0dian(liatTupian.get(j));
        }
        List<ImageView> list1 = new ArrayList<>();
        list1.add(image_z1);
        list1.add(image_z2);
        list1.add(image_z3);
        list1.add(image_z4);
        list1.add(image_z5);
        for (int i = 0; i < list1.size(); i++) {
            animator.xianshiZhu(list1.get(i));
        }

        ObjectAnimator animator_z1 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.hao1
        );
        animator_z1.setTarget(image_z1);
        animator_z1.start();
        AnimatorSet animator_z2 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao2
        );
        animator_z2.setTarget(image_z2);
        animator_z2.start();
        AnimatorSet animator_z3 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao3
        );
        animator_z3.setTarget(image_z3);
        animator_z3.start();
        ObjectAnimator animator_z4 = (ObjectAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.hao4
        );
        animator_z4.setTarget(image_z4);
        animator_z4.start();
        AnimatorSet animator_z5 = (AnimatorSet) AnimatorInflater.loadAnimator(
                this, R.animator.hao5
        );
        animator_z5.setTarget(image_z5);
        animator_z5.start();
    }

    /*
    重新开始的点击事件
     */
    public void chongxin() {
        animator.xianshiZhu(iamgeview1);
        animator.xianshiZhu(iamgeview2);
        animator.kaishi(iamgeview1, iamgeview2);
        //重新开始后的图片隐藏
        for (int i = 0; i < list0.size(); i++) {
            animator.yincang(list0.get(i));
            animator.huigui0dian(list0.get(i));
        }
    }

    /*
    爱好者点击后的弹出图片
     */
    public void aihaoSan() {
        animator.Fzhou(imageview_shenghuoxiuxian, 100, -210);
        animator.Fzhou(imageview_suxingyuyangsheng, -100, -210);
        animator.Fzhou(imageview_zhichangjingying, 200, -50);
        animator.Fzhou(imageview_zhutihuodong, -200, -50);

        animator.xianshiZi(imageview_shenghuoxiuxian);
        animator.xianshiZi(imageview_suxingyuyangsheng);
        animator.xianshiZi(imageview_zhichangjingying);
        animator.xianshiZi(imageview_zhutihuodong);
    }

    /*
    美业人点击后的弹出图片
     */
    public void meiyierenSan() {
        animator.Fzhou(imageview_zaizhizhe, 200, 280);
        animator.Fzhou(imageview_jingyingzhe, -200, 280);
        animator.Fzhou(imageview_chuxuezhe, 0, 280);

        animator.xianshiZi(imageview_zaizhizhe);
        animator.xianshiZi(imageview_jingyingzhe);
        animator.xianshiZi(imageview_chuxuezhe);
    }

}
