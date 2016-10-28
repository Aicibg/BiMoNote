package com.hao.bimonote.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.hao.bimonote.R;

/**
 * Created by DongHao on 2016/10/28
 * Description:风车View
 */

public class WindmillView extends View {
    private Paint mPaint;
    private Paint mArcPaint;
    private int mHeight, mWidth;
    private RotateAnimation mRotateAnimation;
    private int mWinVelocity = 1;
    private int mWindmillColor = -1;


    public WindmillView(Context context) {
        this(context, null);
    }

    public WindmillView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WindmillView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.WindmillView);
        mWindmillColor = typeArray.getColor(R.styleable.WindmillView_windmillColor, Color.BLUE);
        mWinVelocity = typeArray.getInteger(R.styleable.WindmillView_windVelocity, 1);
        typeArray.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);

        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStyle(Paint.Style.FILL);
        mArcPaint.setColor(mWindmillColor);

        mRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setFillAfter(true);
        mRotateAnimation.setRepeatCount(-1);
        mRotateAnimation.setInterpolator(new LinearInterpolator());
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.scale(1, -1);

//        canvas.drawLine(-mWidth / 2, 0, mWidth / 2, 0, mPaint);
//        canvas.drawLine(0, -mHeight / 2, 0, mHeight / 2, mPaint);

        Path path = new Path();
        path.moveTo(0, 0);
        path.quadTo(mWidth / 4, mHeight / 2, mWidth / 2, 0);
        canvas.drawPath(path, mArcPaint);

        canvas.save();
        for (int i = 0; i < 3; i++) {
            canvas.rotate(90, 0, 0);
            canvas.drawPath(path, mArcPaint);
        }
        canvas.restore();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int height = 0;
        int width = 0;
        switch (widthSpecMode) {
            case MeasureSpec.AT_MOST:
                width = 100;
                break;
            case MeasureSpec.EXACTLY:
                width = widthSpecSize;
                break;
            default:
                break;
        }

        switch (heightSpecMode) {
            case MeasureSpec.AT_MOST:
                height = 100;
                break;
            case MeasureSpec.EXACTLY:
                height = heightSpecSize;
                break;
            default:
                break;
        }

        if (width > height) {
            width = height;
        } else {
            height = width;
        }

        setMeasuredDimension(width, height);
    }

    public void startAnimation() {
        stopAnimation();
        mRotateAnimation.setDuration(1800 - mWinVelocity * 100);
        startAnimation(mRotateAnimation);
    }

    public void stopAnimation() {
        clearAnimation();
    }
}
