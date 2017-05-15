<br><com.softsnow.countdowntimerbutton.view.CountDownTimerButton
        <br>android:layout_width="200dp"
        <br>android:layout_height="60dp"\<br> 
        <br>android:layout_gravity="center"\<br> 
        <br>android:id="@+id/button"\<br> 
        <br>app:interval="1000"//倒计时时间间隔\<br> 
       <br> app:duration="6000"//总倒计时时间\<br> 
        <br>/>\<br> 
        <br>\<br> 
        <br>\<br> 
 <br>final CountDownTimerButton button= (CountDownTimerButton) findViewById(R.id.button);\<br> 
       <br> button.setOnTimering(new CountDownTimerButton.ITimeringListener() {\<br> 
           <br> @Override\<br> 
           <br> public void onTimering(int presentTimer) {\<br> 
               <br> button.setText(presentTimer/1000+"正在倒计时");\<br> 
                <br>//倒计时过程中执行的方法\<br> 
           <br> }\<br> 
	    <br>\<br> 
            <br>@Override\<br> 
            <br>public void afterTimer() {\<br> 
                <br>button.setText("倒计时结束");\<br> 
                 <br>//倒计时结束执行的方法\<br> 
            <br>}\<br> 
       <br> });\<br> 
