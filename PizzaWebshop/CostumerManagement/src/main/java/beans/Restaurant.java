package beans;

import java.util.LinkedList;

/**
 * Created by Enis Lushtaku on 16.04.2015.
 */
public class Restaurant extends Adresse
{
    private String name;
    private LinkedList<Newsletter> newsletters;
    private LinkedList<Discount> discounts;
    private double laengengrad;
    private double breitengrad;

    public Restaurant(String straße, String plz, String ort, String name, double laengengrad, double breitengrad)
    {
        super(straße, plz, ort);
        this.name = name;
        this.laengengrad = laengengrad;
        this.breitengrad = breitengrad;
        this.newsletters = new LinkedList<Newsletter>();
        this.discounts = new LinkedList<Discount>();
    }

    public void addNewsletter(String name, String text)
    {
        this.newsletters.add(new Newsletter(name,text));
    }

    public void addDiscount(double discount)
    {
        this.discounts.add(new Discount(discount));
    }
}
