package me.vinnychan.thefoodisright;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by yves on 21/02/15.
 */
public class Reward extends MainActivity {

    static String[] statuses= {"grape","tomato", "blueberry", "papaya", "lychee","coconut",
            "longan", "jack fruit", "star fruit", "guava", "kumquat", "mango", "passion fruit",
            "pineapple", "papaya","durian", "mangosteen", "WATERMELON", "DRAGONFRUIT"};

    static String status = statuses[0];
    static ArrayList<String> awards;

    public void upgrade(int count) {
        if ((count % 5 == 0) && (count<=85)){
            int n = (count/5);
            status = statuses[n];
            MainActivity.setStatusText("You are a " + status);
            awards.add(status);
        } else

        if (count == 90) {
            status = statuses[18];
            MainActivity.setStatusText("YOU ARE THE LEGENDARY" + status);
            awards.add(status);
        }
    }

}
