<com.softsnow.countdowntimerbutton.view.CountDownTimerButton
        android:layout_width="200dp"
        android:layout_height="60dp"
        android:layout_gravity="center"
        android:id="@+id/button"
        app:interval="1000"//倒计时时间间隔
        app:duration="6000"//总倒计时时间
        />
        
        
 final CountDownTimerButton button= (CountDownTimerButton) findViewById(R.id.button);
        button.setOnTimering(new CountDownTimerButton.ITimeringListener() {
            @Override
            public void onTimering(int presentTimer) {
                button.setText(presentTimer/1000+"正在倒计时");
                //倒计时过程中执行的方法
            }

            @Override
            public void afterTimer() {
                button.setText("倒计时结束");
                 //倒计时结束执行的方法
            }
        });
