package beans;

/**
 * Created by Enis Lushtaku on 16.04.2015.
 */
public class Restaurant extends Adresse
{
    private String name;
    private double laengengrad;
    private double breitengrad;

    public Restaurant(String straße, String plz, String ort, String name, double laengengrad, double breitengrad)
    {
        super(straße, plz, ort);
        this.name = name;
        this.laengengrad = laengengrad;
        this.breitengrad = breitengrad;
    }
}
