package me.vinnychan.thefoodisright;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class MainActivity extends ActionBarActivity {


    public List<Food> foodList;
    ImageButton foodButton1, foodButton2;
    ImageView checkImage, crossImage;

    SoundPool soundPool;
    int correct = -1;
    int wrong = -1;

    int food1, food2;
    int score = 0;
    static int lives = 10;
    Reward reward;
    static int count;
    int lifeRewardCount;


    Random randomNumber1 = new Random();
    Random randomNumber2 = new Random();
    TextView foodText1, foodText2, scoreText, calorieText1, calorieText2, livesText;
    static TextView statusText;

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
        foodText2 = (TextView) findViewById(R.id.foodText2);
        scoreText = (TextView) findViewById(R.id.scoreText);
        livesText = (TextView) findViewById(R.id.livesText);
        calorieText1 = (TextView) findViewById(R.id.calorieText1);
        calorieText2 = (TextView) findViewById(R.id.calorieText2);
        checkImage = (ImageView) findViewById(R.id.checkImage);
        crossImage = (ImageView) findViewById(R.id.crossImage);
        statusText = (TextView) findViewById(R.id.statusText);
        reward = new Reward();

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        correct = soundPool.load(this, R.raw.correct, 1);
        wrong = soundPool.load(this, R.raw.wrong, 1);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/BradBunR.ttf");
        calorieText1.setTypeface(face);
        calorieText2.setTypeface(face);
        scoreText.setTypeface(face);

        checkImage.setAlpha(0);
        crossImage.setAlpha(0);


        inputStream = getResources().openRawResource(R.raw.legumes);
        csvFile = new CSVFile(inputStream);
        foodList = csvFile.read();

        updateFood();
        setStatusText("You are a grape");

        foodButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (foodList.get(food1).getCalorie() < foodList.get(food2).getCalorie()) {
                    score += 100;
                    count++;
                    soundPool.play(correct, 1, 1, 0, 0, 1);
                    checkImage.setAlpha(255);
                    checkImage.setVisibility(View.VISIBLE);
                    checkImage.postDelayed(hide3, 2000);

                    lifeRewardCount++;
                    rewardLife(lifeRewardCount);


                } else {
                    score -= 100;
                    lives -= 1;
                    soundPool.play(wrong, 1, 1, 0, 0, 1);
                    crossImage.setAlpha(255);
                    crossImage.setVisibility(View.VISIBLE);
                    crossImage.postDelayed(hide4, 2000);
                }

                checkGameOver();
                setCalorie();
                updateFood();
                reward.upgrade(count);
            }
        });

        foodButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (foodList.get(food2).getCalorie() < foodList.get(food1).getCalorie()) {
                    score += 100;
                    count++;
                    soundPool.play(correct, 1, 1, 0, 0, 1);
                    checkImage.setAlpha(255);
                    checkImage.setVisibility(View.VISIBLE);
                    checkImage.postDelayed(hide3, 2000);

                    lifeRewardCount++;
                    rewardLife(lifeRewardCount);
                } else {
                    score -= 100;
                    lives -= 1;
                    soundPool.play(wrong, 1, 1, 0, 0, 1);
                    crossImage.setAlpha(255);
                    crossImage.setVisibility(View.VISIBLE);
                    crossImage.postDelayed(hide4, 2000);
                }
                checkGameOver();
                setCalorie();
                updateFood();
                reward.upgrade(count);

            }
        });
    }

    public void checkGameOver(){
        if (lives==0){
            Intent i = new Intent(MainActivity.this, Gameover.class);
            startActivity(i);
            finish();
        }
    }

    public void rewardLife(int lifeRewardCount) {

            if (lifeRewardCount == 5) {
                lives++;
                this.lifeRewardCount = 0;

                Toast.makeText(getBaseContext(), "Yay! You gained a life!", Toast.LENGTH_SHORT).show();
            }

    }

    Runnable hide1 = new Runnable() {
        @Override
        public void run() {
            calorieText1.setVisibility(View.GONE);
        }
    };

    Runnable hide2 = new Runnable() {
        @Override
        public void run() {
            calorieText2.setVisibility(View.GONE);
        }
    };

    Runnable hide3 = new Runnable() {
        @Override
        public void run() {
            checkImage.setVisibility(View.GONE);
        }
    };

    Runnable hide4 = new Runnable() {
        @Override
        public void run() {
            crossImage.setVisibility(View.GONE);
        }
    };

    public static void setStatusText(String s) {
        statusText.setText(s);
    }

    public void setCalorie(){
        calorieText1.setText(foodList.get(food1).getCalorie()+"");
        calorieText2.setText(foodList.get(food2).getCalorie()+"");
        calorieText1.setVisibility(View.VISIBLE);
        calorieText2.setVisibility(View.VISIBLE);
        calorieText1.postDelayed(hide1, 2000);
        calorieText2.postDelayed(hide2, 2000);

    }


    public void updateFood() {
        food1 = randomNumber1.nextInt(foodList.size() - 1);
        food2 = randomNumber2.nextInt(foodList.size() - 1);

        while (food1 == food2) {
            food2 = randomNumber2.nextInt(foodList.size() - 1);
        }

        foodText1.setText(foodList.get(food1).getName());
        foodText2.setText(foodList.get(food2).getName());
        scoreText.setText("" + score);
        livesText.setText("Lives: "+lives);
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
            foodList = csvFile.read();

            updateFood();
        }
        if (id == R.id.snacks_select) {
            Toast.makeText(getBaseContext(), "You have selected: Snacks", Toast.LENGTH_SHORT).show();
            inputStream = getResources().openRawResource(R.raw.snack);
            csvFile = new CSVFile(inputStream);
            foodList = csvFile.read();

            updateFood();
        }

        if (id == R.id.beverage_select) {
            Toast.makeText(getBaseContext(), "You have selected: Beverages", Toast.LENGTH_SHORT).show();
            inputStream = getResources().openRawResource(R.raw.beverages);
            csvFile = new CSVFile(inputStream);
            foodList = csvFile.read();

            updateFood();
        }

        if (id == R.id.fastfood_select) {
            Toast.makeText(getBaseContext(), "You have selected: Fast Foods", Toast.LENGTH_SHORT).show();
            inputStream = getResources().openRawResource(R.raw.fastfoods);
            csvFile = new CSVFile(inputStream);
            foodList = csvFile.read();

            updateFood();
        }

        if (id == R.id.baked_select) {
            Toast.makeText(getBaseContext(), "You have selected: Baked Foods", Toast.LENGTH_SHORT).show();
            inputStream = getResources().openRawResource(R.raw.baked);
            csvFile = new CSVFile(inputStream);
            foodList = csvFile.read();

            updateFood();
        }


        return super.onOptionsItemSelected(item);
    }
}
