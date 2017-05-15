package com.softsnow.countdowntimerbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.softsnow.countdowntimerbutton.view.CountDownTimerButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CountDownTimerButton button= (CountDownTimerButton) findViewById(R.id.button);
        button.setOnTimering(new CountDownTimerButton.ITimeringListener() {
            @Override
            public void onTimering(int presentTimer) {
                button.setText(presentTimer/1000+"正在倒计时");
            }

            @Override
            public void afterTimer() {
                button.setText("倒计时结束");
            }
        });
    }
}
