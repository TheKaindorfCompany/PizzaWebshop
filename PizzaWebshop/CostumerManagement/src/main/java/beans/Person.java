package beans;

/**
 * Created by Dominik on 16.04.2015.
 */
public class Person
{

    private String vorname;
    private String nachname;
    private Adresse adresse;

    public Person(String vorname, String nachname, Adresse adresse)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public String getNachname()
    {
        return nachname;
    }

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public Adresse getAdresse()
    {
        return adresse;
    }

    public void setAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }
}
