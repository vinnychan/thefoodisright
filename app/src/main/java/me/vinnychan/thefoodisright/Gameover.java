package me.vinnychan.thefoodisright;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    ImageView broccoliImage, cucumberImage, onionImage, tomatoImage, pepperImage, avacadoImage,
    appleImage, orangeImage, lemonImage, pearImage, kiwiImage, watermelonImage, coconutImage, peachImage,
    strawberryImage, bananaImage, pomegranateImage, passionfruitImage, papayaImage, starfruitImage;

    //List<ImageView> fruits = new ArrayList<ImageView>();

//    ArrayList<ImageView> fruits = new ArrayList<ImageView>(Arrays.asList(broccoliImage, cucumberImage, onionImage, tomatoImage, pepperImage, avacadoImage,
//            appleImage, orangeImage, lemonImage, pearImage, kiwiImage, watermelonImage, coconutImage, peachImage,
//            strawberryImage, bananaImage, pomegranateImage, passionfruitImage, papayaImage, starfruitImage));

    ImageView[] fruits = { broccoliImage, cucumberImage, onionImage, tomatoImage, pepperImage, avacadoImage,
            appleImage, orangeImage, lemonImage, pearImage, kiwiImage, watermelonImage, coconutImage, peachImage,
            strawberryImage, bananaImage, pomegranateImage, passionfruitImage, papayaImage, starfruitImage};




   // RadioButton rewardsButton;


//    public void initialFruits() {
//        for (ImageView v : fruits) {
//            v.setVisibility(View.INVISIBLE);
//
//        }
//    }
//
//    public void showFruits() {
//        for (int i = 0; i < Reward.awards.size(); i++) {
//            fruits[i].setVisibility(View.VISIBLE);
//        }
//    }

    public void showFruits(int n) {
        switch(n) {
            case 1: broccoliImage.setVisibility(View.VISIBLE);

            case 2: cucumberImage.setVisibility(View.VISIBLE);

            case 3: onionImage.setVisibility(View.VISIBLE);

            case 4: tomatoImage.setVisibility(View.VISIBLE);
                break;


        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        broccoliImage = (ImageView) findViewById(R.id.broccoliImage);
        cucumberImage = (ImageView) findViewById(R.id.cucumberImage);
        onionImage = (ImageView) findViewById(R.id.onionImage);
        tomatoImage = (ImageView) findViewById(R.id.tomatoImage);
        pepperImage = (ImageView) findViewById(R.id.pepperImage);
        avacadoImage = (ImageView) findViewById(R.id.avacadoImage);
        appleImage = (ImageView) findViewById(R.id.appleImage);
        orangeImage = (ImageView) findViewById(R.id.orangeImage);
        lemonImage = (ImageView) findViewById(R.id.lemonImage);
        pearImage = (ImageView) findViewById(R.id.pearImage);

        kiwiImage = (ImageView) findViewById(R.id.kiwiImage);
        watermelonImage = (ImageView) findViewById(R.id.watermelonImage);
        coconutImage = (ImageView) findViewById(R.id.coconutImage);
        peachImage = (ImageView) findViewById(R.id.peachImage);
        strawberryImage = (ImageView) findViewById(R.id.strawberryImage);
        bananaImage = (ImageView) findViewById(R.id.bananaImage);
        pomegranateImage = (ImageView) findViewById(R.id.pomegranateImage);
        passionfruitImage = (ImageView) findViewById(R.id.passionfruitImage);
        papayaImage = (ImageView) findViewById(R.id.papayaImage);
        starfruitImage = (ImageView) findViewById(R.id.starfruitImage);

//        initialFruits();

        broccoliImage.setVisibility(View.INVISIBLE);
        cucumberImage.setVisibility(View.INVISIBLE);
        onionImage.setVisibility(View.INVISIBLE);
        tomatoImage.setVisibility(View.INVISIBLE);
        pepperImage.setVisibility(View.INVISIBLE);
        avacadoImage.setVisibility(View.INVISIBLE);
        appleImage.setVisibility(View.INVISIBLE);
        orangeImage.setVisibility(View.INVISIBLE);
        lemonImage.setVisibility(View.INVISIBLE);
        pearImage.setVisibility(View.INVISIBLE);

        kiwiImage.setVisibility(View.INVISIBLE);
        watermelonImage.setVisibility(View.INVISIBLE);
        coconutImage.setVisibility(View.INVISIBLE);
        peachImage.setVisibility(View.INVISIBLE);
        strawberryImage.setVisibility(View.INVISIBLE);
        bananaImage.setVisibility(View.INVISIBLE);
        pomegranateImage.setVisibility(View.INVISIBLE);
        passionfruitImage.setVisibility(View.INVISIBLE);
        papayaImage.setVisibility(View.INVISIBLE);
        starfruitImage.setVisibility(View.INVISIBLE);



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

        showFruits(Reward.awards.size());

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
