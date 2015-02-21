package me.vinnychan.thefoodisright;

import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;
    List<String[]> scoreList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listView = (ListView) findViewById(R.id.listView);
        //itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.item_layout);

        //Parcelable state = listView.onSaveInstanceState();
        //listView.setAdapter(itemArrayAdapter);
        //listView.onRestoreInstanceState(state);

        InputStream inputStream = getResources().openRawResource(R.raw.legumes);
        CSVFile csvFile = new CSVFile(inputStream);
        scoreList = csvFile.read();

        //for(String[] scoreData:scoreList ) {
        //    itemArrayAdapter.add(scoreData);
        //}
    }
    public void onButtonClick(View v){
        //2 result label - TextView
        TextView text1 = (TextView)findViewById(R.id.foodText1);
        TextView text2 = (TextView)findViewById(R.id.foodText2);

        String a = scoreList.get(0)[0];
        String b = scoreList.get(1)[0];

        int num1 = Integer.parseInt(scoreList.get(0)[1]);
        int num2 = Integer.parseInt(scoreList.get(1)[1]);

        if (v.getId() == R.id.foodButton1){
            text1.setText(a);

        }
        if (v.getId() == R.id.foodButton2){
            text2.setText(b);
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
