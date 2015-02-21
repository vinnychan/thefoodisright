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
    Random ran1, ran2;
    TextView text1, text2, score;
    int x, y, num1, num2;
    String a,b;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.legumes);
        CSVFile csvFile = new CSVFile(inputStream);
        scoreList = csvFile.read();
        initializeValue();
    }
    public void onButtonClick(View v){
        //2 result label - TextView
        if (v.getId() == R.id.foodButton1){
            if(x <= y){s += 100;}
            else{s-= 100;}}
        if (v.getId() == R.id.foodButton2){
            if(y <= x){s+=100;}
            else{s-=100;}}
        score.setText(s+"");
        x = ran1.nextInt(scoreList.size()-1);
        y = ran2.nextInt(scoreList.size()-1);
        a = scoreList.get(x).getName();
        b = scoreList.get(y).getName();
        num1 = Integer.parseInt(scoreList.get(x).getCalories());
        num2 = Integer.parseInt(scoreList.get(y).getCalories());
        text1.setText(a);
        text2.setText(b);
    }
    public void initializeValue(){
        ran1 = new Random();
        ran2 = new Random();
        text1 = (TextView)findViewById(R.id.foodText1);
        text2 = (TextView)findViewById(R.id.foodText2);
        score = (TextView)findViewById(R.id.scoreText);
        x = ran1.nextInt(scoreList.size()-1);
        y = ran2.nextInt(scoreList.size()-1);
        a = scoreList.get(x).getName();
        b = scoreList.get(y).getName();
        num1 = Integer.parseInt(scoreList.get(x).getCalories());
        num2 = Integer.parseInt(scoreList.get(y).getCalories());
        text1.setText(a);
        text2.setText(b);
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
            return true; }
        return super.onOptionsItemSelected(item);
    }}