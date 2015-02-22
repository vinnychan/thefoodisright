package me.vinnychan.thefoodisright;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by yves on 21/02/15.
 */
public class SplashScreen extends ActionBarActivity{

    TextView splashTitle;
    SoundPool soundPool;
    int open = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        splashTitle = (TextView) findViewById(R.id.splashTitle);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/BradBunR.ttf");
        splashTitle.setTypeface(face);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        open = soundPool.load(this, R.raw.open, 1);

        soundPool.play(open, 1, 1, 0, 0, 1);

        Thread startTimer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    MainActivity.lives = 10;
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
