package beans;

import java.util.LinkedList;

/**
 * Created by Enis Lushtaku on 16.04.2015.
 */
public class RestaurantOwner extends Member
{
    private LinkedList<Restaurant> restaurants;

    String vorname;
    String nachname;
    Adresse adresse;
    String email;
    String passwort;

    public RestaurantOwner(String vorname, String nachname, Adresse adresse, String email, String passwort)
    {
        super(vorname, nachname, adresse, email, passwort);
        restaurants = new LinkedList<Restaurant>();
    }

    public Newsletter createNewsletter(String text, String newsletterName)
    {
        Newsletter news;
        news = new Newsletter(newsletterName, restaurants.element(),text);
        return news;
    }

    public Discount createDiscount(Double discount)
    {
        Discount discountObj;
        discountObj = new Discount(restaurants.element(), this,discount);
        return discountObj;
    }
}
