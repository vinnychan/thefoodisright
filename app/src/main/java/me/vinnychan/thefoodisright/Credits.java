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
public class Credits extends ActionBarActivity {
    TextView creditsText;
    RadioButton restartButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        creditsText = (TextView) findViewById(R.id.creditsText);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/BradBunR.ttf");
        creditsText.setTypeface(face);

        restartButton = (RadioButton) findViewById(R.id.restartButton);

        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.lives = 10;
                MainActivity.score = 0;
                MainActivity.count = 0;
                Reward.awards = new ArrayList<String>();
                Intent i = new Intent(Credits.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }

}