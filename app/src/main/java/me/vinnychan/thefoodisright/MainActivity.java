package me.vinnychan.thefoodisright;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerDropDown;
    String[] categories = {
            "legumes",
            "snack"
    };

    public List<Legume> legumeList;
    ImageButton foodButton1, foodButton2;

    int food1, food2;
    int score = 0;

    Random randomNumber1 = new Random();
    Random randomNumber2 = new Random();
    TextView foodText1, foodText2, scoreText, calorieText1, calorieText2;

    InputStream inputStream;
    CSVFile csvFile;
    //List<Legume> legumeList = csvFile.read();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodButton1 = (ImageButton) findViewById(R.id.foodButton1);
        foodButton2 = (ImageButton) findViewById(R.id.foodButton2);
        foodText1 = (TextView) findViewById(R.id.foodText1);
        foodText2  = (TextView) findViewById(R.id.foodText2);
        scoreText = (TextView) findViewById(R.id.scoreText);
        calorieText1 = (TextView) findViewById(R.id.calorieText1);
        calorieText2 = (TextView) findViewById(R.id.calorieText2);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/BradBunR.ttf");
        calorieText1.setTypeface(face);
        calorieText2.setTypeface(face);
        scoreText.setTypeface(face);



        inputStream = getResources().openRawResource(R.raw.legumes);
        csvFile = new CSVFile(inputStream);
        legumeList = csvFile.read();

        updateFood();

        foodButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               if (legumeList.get(food1).getCalorie() < legumeList.get(food2).getCalorie()) {
                    score += 100;
                } else {
                    score -= 100;
               }

                calorieText1.setText(legumeList.get(food1).getCalorie()+"");
                calorieText2.setText(legumeList.get(food2).getCalorie()+"");
//
//                try {
//                    wait(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
               // resetCalorie();
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
                calorieText1.setText(legumeList.get(food1).getCalorie()+"");
                calorieText2.setText(legumeList.get(food2).getCalorie()+"");
//
//                try {
//                    wait(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                // resetCalorie();
                updateFood();
            }
        });
    }
//
//    public void setCalorie(){
//        calorieText1.setText(legumeList.get(food1).getCalorie()+"");
//        calorieText2.setText(legumeList.get(food2).getCalorie()+"");
//    }

    public void resetCalorie() {
        calorieText1.setText("");
        calorieText2.setText("");
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

    public void spinnerSelect() {
        //spinnerDropDown = (Spinner) findViewById(R.id.spinner);

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

        if (id == R.id.legume_select) {
            Toast.makeText(getBaseContext(), "You have selected: Legumes", Toast.LENGTH_SHORT).show();
            inputStream = getResources().openRawResource(R.raw.legumes);
            csvFile = new CSVFile(inputStream);
            legumeList = csvFile.read();

            updateFood();
        }
        if (id == R.id.snacks_select) {
            Toast.makeText(getBaseContext(), "You have selected: Snacks", Toast.LENGTH_SHORT).show();
            inputStream = getResources().openRawResource(R.raw.snack);
            csvFile = new CSVFile(inputStream);
            legumeList = csvFile.read();

            updateFood();
        }


        return super.onOptionsItemSelected(item);
    }
}
