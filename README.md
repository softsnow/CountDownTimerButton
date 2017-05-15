<br><com.softsnow.countdowntimerbutton.view.CountDownTimerButton
        <br>android:layout_width="200dp"
        <br>android:layout_height="60dp" 
        <br>android:layout_gravity="center"
        <br>android:id="@+id/button" 
        <br>app:interval="1000"//倒计时时间间隔
        <br> app:duration="6000"//总倒计时时间 
        <br>/>
        <br>
 <br>final CountDownTimerButton button= (CountDownTimerButton) findViewById(R.id.button); 
       <br> button.setOnTimering(new CountDownTimerButton.ITimeringListener() {
           <br> @Override\<br> 
           <br> public void onTimering(int presentTimer) {
               <br> button.setText(presentTimer/1000+"正在倒计时");
                <br>//倒计时过程中执行的方法
           <br> }
	    <br>
            <br>@Override\<br> 
            <br>public void afterTimer() { 
                <br>button.setText("倒计时结束");
                 <br>//倒计时结束执行的方法
            <br>}
       <br> });
