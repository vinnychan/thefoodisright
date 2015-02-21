package me.vinnychan.thefoodisright;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yves on 21/02/15.
 */
public class CalorieList {


    private List<Legume> calorieList;

    public CalorieList() {
        calorieList = new ArrayList<Legume>();
    }

    // getting the item object (someBean, 150calories)
    public Legume getIndex(int i){
        return calorieList.get(i);
    }




}
