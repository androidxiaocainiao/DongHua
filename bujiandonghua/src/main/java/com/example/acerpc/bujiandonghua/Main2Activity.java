package com.example.acerpc.bujiandonghua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private ImageView bujiandonghua_xml_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bujiandonghua_xml_imageview = (ImageView) findViewById(R.id.bujiandonghua_xml_imageview);
    }

    public void pingyi_xml(View view) {
        TranslateAnimation translate = (TranslateAnimation) AnimationUtils.loadAnimation(
                this, R.anim.translate_img
        );
        //bujiandonghua_xml_imageview.setAnimation(translate);
        // translate.start();
        bujiandonghua_xml_imageview.startAnimation(translate);
    }

    public void xuanzhuan_xml(View view) {
        RotateAnimation rotate = (RotateAnimation) AnimationUtils.loadAnimation(
                this, R.anim.rotate_img
        );
        /*bujiandonghua_xml_imageview.setAnimation(rotate);
        rotate.start();*/
        bujiandonghua_xml_imageview.startAnimation(rotate);

    }

    public void suofang_xml(View view) {
        ScaleAnimation scale = (ScaleAnimation) AnimationUtils.loadAnimation(
                this, R.anim.scale_img
        );
        /*bujiandonghua_xml_imageview.setAnimation(scale);
        scale.start();*/
        bujiandonghua_xml_imageview.startAnimation(scale);
    }

    public void touming_xml(View view) {
        AlphaAnimation alpha = (AlphaAnimation) AnimationUtils.loadAnimation(
                this, R.anim.alpha_img
        );
        /*bujiandonghua_xml_imageview.setAnimation(alpha);
        alpha.start();*/
        bujiandonghua_xml_imageview.startAnimation(alpha);
    }

    public void zonghe_xml(View view) {
        AnimationSet set = (AnimationSet) AnimationUtils.loadAnimation(
                this, R.anim.set_img
        );
        /*bujiandonghua_xml_imageview.setAnimation(set);
        set.start();*/
        bujiandonghua_xml_imageview.startAnimation(set);
    }
}
