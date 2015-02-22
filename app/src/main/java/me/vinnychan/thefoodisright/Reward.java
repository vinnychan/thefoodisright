package me.vinnychan.thefoodisright;

/**
 * Created by yves on 21/02/15.
 */
public class Reward {

    public void upgrade(int count) {
        if (count == 3) {
            MainActivity.setStatusText("You Are an Orange.");
        }
    }

}
