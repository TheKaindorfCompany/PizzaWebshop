package beans;

import java.util.LinkedList;

/**
 * Created by Enis Lushtaku on 16.04.2015.
 */
public class RestaurantOwner extends Person
{
    private String email;
    private String passwort;
    private LinkedList<Restaurant> restaurants;

    public RestaurantOwner(String vorname, String nachname, Adresse adresse, String email, String passwort, LinkedList<Restaurant> restaurants)
    {
        super(vorname, nachname, adresse);
        this.email = email;
        this.passwort = passwort;
        this.restaurants = restaurants;
    }
}
