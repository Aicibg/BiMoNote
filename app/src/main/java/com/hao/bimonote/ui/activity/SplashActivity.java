package com.hao.bimonote.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.hao.bimonote.R;
import com.hao.bimonote.base.BaseActivity;
import com.hao.bimonote.base.BasePresenterMpl;
import com.hao.bimonote.base.BaseView;
import com.hao.bimonote.widget.WindmillView;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<BasePresenterMpl> implements BaseView {

    @BindView(R.id.bt_start_open)
    Button mBtStartOpen;
    @BindView(R.id.windmill_one)
    WindmillView mWindmillOne;
    @BindView(R.id.windmill_two)
    WindmillView mWindmillTwo;
    @BindView(R.id.tv_title_top)
    TextView mTvTitleTop;
    @BindView(R.id.tv_title_bottom)
    TextView mTvTitleBottom;
    @BindView(R.id.tv_text_bottom)
    TextView mTvTextBottom;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splish;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mWindmillOne.startAnimation();
        mWindmillTwo.startAnimation();
        int height = mTvTitleTop.getMeasuredHeight();
        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, -150f);
        translateAnimation.setDuration(1000);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setFillAfter(true);
        mTvTitleTop.setAnimation(translateAnimation);

        final AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(1500);
        mTvTitleBottom.setAnimation(alphaAnimation);
        mTvTextBottom.setAnimation(alphaAnimation);

        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                alphaAnimation.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        translateAnimation.start();


        mBtStartOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
        });
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.SCALE;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWindmillOne.stopAnimation();
        mWindmillTwo.stopAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mWindmillOne.startAnimation();
        mWindmillTwo.startAnimation();
    }

    @Override
    public void close() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showErrorMessage(String msg) {

    }

}
