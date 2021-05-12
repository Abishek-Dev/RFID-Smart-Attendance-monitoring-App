package com.example.myclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        ImageView img= findViewById(R.id.SplashScreenImage);
        TextView st=findViewById(R.id.SplashScreentxt);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide);
        img.startAnimation(slideAnimation);
        slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide);
        st.startAnimation(slideAnimation);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
