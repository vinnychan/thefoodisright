package me.vinnychan.thefoodisright;

/**
 * Created by yves on 21/02/15.
 */
public class Legume {

    String name;
    double calorie;

    public Legume(String name, double calorie) {
        this.name = name;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

}
