package beans;

import javax.swing.*;
import java.util.LinkedList;

public class Restaurant {
    private String name;
    private double Lat, Lng;
    private String description;
    private String image;
    private LinkedList<Product> products = new LinkedList<Product>();

    public Restaurant(String name, double lat, double lng, String description, String image, Product... products) {
        this.name = name;
        Lat = lat;
        Lng = lng;
        this.description = description;
        this.image = image;
        for(Product product : products) {
            this.products.add(product);
        }
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return Lat;
    }

    public double getLng() {
        return Lng;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public LinkedList<Product> getProducts() {
        return products;
    }
}
