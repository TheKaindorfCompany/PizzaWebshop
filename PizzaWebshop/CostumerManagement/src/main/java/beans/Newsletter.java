package beans;

/**
 * Created by David on 23.04.2015.
 */
public class Newsletter {

    private String name;
    private String restaurantname;
    private String text;

    public Newsletter(String name, String restaurantname, String text) {
        this.name = name;
        this.restaurantname = restaurantname;
        this.text = text;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
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
