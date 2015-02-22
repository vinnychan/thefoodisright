package me.vinnychan.thefoodisright;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

/**
 * Created by yves on 21/02/15.
 */
public class Reward extends MainActivity {

    private static Context mContext;


    public static Context getContext() {
        return mContext;
    }

    public void upgrade(int count) {
        if (count == 3) {
            MainActivity.setStatusText("You Are an Orange.");
        }
    }



}
