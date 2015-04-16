public class Ingredient {
    Name, Wieviel Stück, Link zum Bild, Preis pro Stück
    private String name;
    private String stk;
    private String picture;
    private float price;

    public Ingredient(String picture, String name, float price, String stk) {
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

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }
}
