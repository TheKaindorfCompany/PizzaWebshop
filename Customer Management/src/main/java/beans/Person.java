package beans;

/**
 * Created by Dominik on 16.04.2015.
 */
public class Person
{
    String vorname;
    String nachname;
    Adresse adresse;

    public Person(String vorname, String nachname, Adresse adresse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }
}
