package me.vinnychan.thefoodisright;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yves on 21/02/15.
 */
public class Gameover extends ActionBarActivity{
    TextView gameOverText;
    TextView scoreText;
    TextView highScoreText;
    TextView rewardsText;
    RadioButton restartButton;
    RadioButton creditsButton;

   // RadioButton rewardsButton;

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

        rewardsText = (TextView) findViewById(R.id.rewardsText);
        rewardsText.setTypeface(face);

        restartButton = (RadioButton) findViewById(R.id.restartButton);
        creditsButton = (RadioButton) findViewById(R.id.creditsButton);
       // rewardsButton = (RadioButton) findViewById(R.id.rewardsButton);


        scoreText.setText("Good Job, your score was " +MainActivity.score);
        highScoreText.setText("Your best was " +MainActivity.highScore+" and you obtained " + Reward.status + " Status!!!");
        rewardsText.setText("You collected "+ Reward.awards.size() +" out of"+ Reward.statuses.length +" fruits");

        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.lives = 10;
                MainActivity.score = 0;
                MainActivity.count = 0;
                Reward.awards = new ArrayList<String>();
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
