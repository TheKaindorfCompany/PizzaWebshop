package beans;

import java.util.LinkedList;

/**
 * Created by Enis Lushtaku on 16.04.2015.
 */
public class RestaurantOwner extends Member
{
    private LinkedList<Restaurant> restaurants;

    public RestaurantOwner(String vorname, String nachname, Adresse adresse, String email, String passwort)
    {
        super(vorname, nachname, adresse, email, passwort);
        restaurants = new LinkedList<Restaurant>();
    }
}
