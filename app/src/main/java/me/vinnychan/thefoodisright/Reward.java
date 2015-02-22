package me.vinnychan.thefoodisright;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by yves on 21/02/15.
 */
public class Reward extends MainActivity {

    static String[] statuses= {"broccoli", "cucumber", "onion", "tomato",
            "pepper", "avocado", "apple", "orange", "lemon", "pear", "kiwi", "watermelon","coconut",
            "peach", "strawberry","banana","pomegranate", "passion fruit", "guava", "STARFRUIT"};

    static String status = statuses[0];
    static ArrayList<String> awards = new ArrayList<String>();


    public void upgrade(int count) {
        if ((count%5 == 0) && (count<=85)){
            int n = (count/5);
            status = statuses[n];
            MainActivity.setStatusText("You are the " + status);
            awards.add(0, status);
        } else

        if (count == 95) {
            status = statuses[19];
            MainActivity.setStatusText("YOU ARE THE LEGENDARY" + status);
            awards.add(0, status);
        }
    }

}
