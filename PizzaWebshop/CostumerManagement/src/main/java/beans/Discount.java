package beans;

/**
 * Created by David on 23.04.2015.
 */
public class Discount {

    private Restaurant restaurant;
    private RestaurantOwner owner;
    private double discount;

    public Discount(Restaurant restaurant, RestaurantOwner owner, double discount) {
        this.restaurant = restaurant;
        this.owner = owner;
        this.discount = discount;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public RestaurantOwner getOwner() {
        return owner;
    }

    public void setOwner(RestaurantOwner owner) {
        this.owner = owner;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
