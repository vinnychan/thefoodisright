package me.vinnychan.thefoodisright;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by yves on 21/02/15.
 */
public class SplashScreen extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread startTimer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        startTimer.start();
    }

}
