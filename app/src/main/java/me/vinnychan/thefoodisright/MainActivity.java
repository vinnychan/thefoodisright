package me.vinnychan.thefoodisright;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class MainActivity extends ActionBarActivity {

    public List<Legume> legumeList;
    ImageButton foodButton1, foodButton2;

    int food1, food2;
    int score = 0;

    Random randomNumber1 = new Random();
    Random randomNumber2 = new Random();
    TextView foodText1, foodText2, scoreText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodButton1 = (ImageButton) findViewById(R.id.foodButton1);
        foodButton2 = (ImageButton) findViewById(R.id.foodButton2);
        foodText1 = (TextView) findViewById(R.id.foodText1);
        foodText2  = (TextView) findViewById(R.id.foodText2);
        scoreText = (TextView) findViewById(R.id.scoreText);

        InputStream inputStream = getResources().openRawResource(R.raw.legumes);
        CSVFile csvFile = new CSVFile(inputStream);
        legumeList = csvFile.read();

        updateFood();

        foodButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               if (legumeList.get(food1).getCalorie() < legumeList.get(food2).getCalorie()) {
                    score += 100;
                } else {
                    score -= 100;
               }
                updateFood();
            }
        });

        foodButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (legumeList.get(food2).getCalorie() < legumeList.get(food1).getCalorie()) {
                    score += 100;
                } else {
                    score -= 100;
                }
                updateFood();
            }
        });
    }

    public void updateFood() {
        food1 = randomNumber1.nextInt(legumeList.size() - 1);
        food2 = randomNumber2.nextInt(legumeList.size() - 1);

        while (food1 == food2) {
            food2 = randomNumber2.nextInt(legumeList.size() - 1);
        }

        foodText1.setText(legumeList.get(food1).getName());
        foodText2.setText(legumeList.get(food2).getName());
        scoreText.setText("" + score);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
