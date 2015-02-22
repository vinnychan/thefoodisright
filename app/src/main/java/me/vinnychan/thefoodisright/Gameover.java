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
    TextView scoreText;
    TextView highScoreText;
    RadioButton restartButton;
    RadioButton creditsButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        gameOverText = (TextView) findViewById(R.id.gameOverText);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/BradBunR.ttf");
        gameOverText.setTypeface(face);

        scoreText = (TextView) findViewById(R.id.scoreText);
        scoreText.setTypeface(face);

        highScoreText = (TextView) findViewById(R.id.highScoreText);
        highScoreText.setTypeface(face);

        restartButton = (RadioButton) findViewById(R.id.restartButton);
        creditsButton = (RadioButton) findViewById(R.id.creditsButton);

        scoreText.setText("Good Job, your score was " +MainActivity.score);
        highScoreText.setText("Your best was " +MainActivity.highScore);

        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.lives = 10;
                MainActivity.score = 0;
                Intent i = new Intent(Gameover.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        creditsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Gameover.this, Credits.class);
                startActivity(i);
                finish();

            }
        });
    }

}
