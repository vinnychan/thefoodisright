package me.vinnychan.thefoodisright;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by yves on 21/02/15.
 */
public class Gameover extends ActionBarActivity{
    TextView gameOverText;
    RadioButton restartButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        gameOverText = (TextView) findViewById(R.id.gameOverText);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/BradBunR.ttf");
        gameOverText.setTypeface(face);

        restartButton = (RadioButton) findViewById(R.id.restartButton);

        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.lives = 10;
                Intent i = new Intent(Gameover.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }

}
