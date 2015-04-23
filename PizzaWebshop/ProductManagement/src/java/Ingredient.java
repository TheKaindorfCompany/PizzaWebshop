package java;

/**
 * Created by Veronika on 16.04.2015.
 */


public class Ingredient {
   // Name, Wieviel Stück, Link zum Bild, Preis pro Stück
    private String name;
    private int stk;
    private String picture;
    private float price;

    public Ingredient(String picture, String name, float price, int stk) {
        this.picture = picture;
        this.name = name;
        this.price = price;
        this.stk = stk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStk() {
        return stk;
    }

    public void setStk(int stk) {
        this.stk = stk;
    }

    @Override
    public String toString() {
        return "<tr><td>" + this.name + "</td><td>" + this.price + "</td><td>"
                + this.stk + "</td></tr>";
    }
}
