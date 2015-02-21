package me.vinnychan.thefoodisright;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends ActionBarActivity {


    ArrayList<Foods> scoreList;
    int s = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.legumes);
        CSVFile csvFile = new CSVFile(inputStream);
        scoreList = csvFile.read();

    }
    public void onButtonClick(View v){
        //2 result label - TextView
        Random ran1 = new Random();
        Random ran2 = new Random();
        TextView text1 = (TextView)findViewById(R.id.foodText1);
        TextView text2 = (TextView)findViewById(R.id.foodText2);
        TextView score = (TextView)findViewById(R.id.scoreText);
        int x = ran1.nextInt(50);
        int y = ran2.nextInt(50);
        String a = scoreList.get(x).getName();
        String b = scoreList.get(y).getName();
        int num1 = Integer.parseInt(scoreList.get(x).getCalories());
        int num2 = Integer.parseInt(scoreList.get(y).getCalories());

        if (v.getId() == R.id.foodButton1){
            text1.setText(a);
            text2.setText(b);
            if(x <= y){
                s++;
            }
            else{
                s--;
            }
            score.setText(s+"");
        }
        if (v.getId() == R.id.foodButton2){
            text1.setText(a);
            text2.setText(b);
            if(y <= x){
                s++;
            }
            else{
                s--;
            }
            score.setText(s+"");
        }
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
