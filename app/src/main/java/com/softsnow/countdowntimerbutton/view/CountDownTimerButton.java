package com.softsnow.countdowntimerbutton.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.softsnow.countdowntimerbutton.R;

/**
 * 创建日期：2017/5/15 on 21:02
 * 描述:具有倒计时功能的button
 * 作者:softSnow
 */

public class CountDownTimerButton extends AppCompatButton implements View.OnClickListener {

    private int mDuration ;//倒计时时长,默认59s
    private int mInterval;//倒计时时间间隔，默认1s
    private int mTempDuration;
    private Runnable mCountDownTimerRunnable;
    private ITimeringListener mITimeringListener;

    public CountDownTimerButton(Context context) {
        super(context);
        init(context,null,0);
    }

    public CountDownTimerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs,0);
    }

    public CountDownTimerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr);
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public int getInterval() {
        return mInterval;
    }

    public void setInterval(int interval) {
        mInterval = interval;
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mDuration=5000;
        mInterval=1000;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CountDownTimerButton, defStyleAttr, 0);
        mDuration = a.getInt(R.styleable.CountDownTimerButton_duration,mDuration);
        mInterval = a.getInt(R.styleable.CountDownTimerButton_interval,mInterval);
        a.recycle();
        mTempDuration=mDuration;
        setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mTempDuration<mDuration)
            return;
        startTimer();
    }
    //计时开始
    private void startTimer(){
        if(mCountDownTimerRunnable==null)
            mCountDownTimerRunnable=new Runnable() {
                @Override
                public void run() {
                    if(mITimeringListener!=null)
                        mITimeringListener.onTimering(mTempDuration);
                    mTempDuration -= 1000;
                    if (mTempDuration < 0) {//倒计时结束
                        if(mITimeringListener!=null)
                            mITimeringListener.afterTimer();
                        stopTimer();
                        return;
                    }
                    postDelayed(this,mInterval);
                }
            };
        post(mCountDownTimerRunnable);
    }

    //计时结束
    private void stopTimer(){
        mTempDuration=mDuration;
        removeCallbacks(mCountDownTimerRunnable);
        mCountDownTimerRunnable=null;
    }

    public void setOnTimering(ITimeringListener listener){
        mITimeringListener=listener;
    }

    public interface ITimeringListener{
        void onTimering(int presentTimer);
        void afterTimer();
    }
}
