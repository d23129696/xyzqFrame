package com.xyzq.frame.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xyzq.frame.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dailu on 2017/3/20.
 */

public class SplashActivity extends AppCompatActivity {

    @InjectView(R.id.iv_splash)
    ImageView ivSplash;
    @InjectView(R.id.activity_splash)
    RelativeLayout activitySplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_splash);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //当当前动画执行结束 跳转到MainActivity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
//             设置转场动画 用到android自带的动画效果 fadein fade_out alpha透明度动画 淡入淡出
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        ivSplash.setAnimation(animation);
    }
}
