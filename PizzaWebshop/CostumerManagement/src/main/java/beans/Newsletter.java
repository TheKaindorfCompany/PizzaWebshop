package beans;

/**
 * Created by David on 23.04.2015.
 */
public class Newsletter {

    private String name;
    private Restaurant restaurant;
    private String text;

    public Newsletter(String name, Restaurant restaurant, String text) {
        this.name = name;
        this.restaurant = restaurant;
        this.text = text;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurant = restaurant;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
