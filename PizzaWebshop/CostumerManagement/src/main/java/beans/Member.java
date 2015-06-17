package beans;

/**
 * Created by Dominik on 16.04.2015.
 */
public class Member extends Person
{

    private String email;
    private String passwort;

    public Member(String vorname, String nachname, Adresse adresse, String email, String passwort)
    {
        super(vorname, nachname, adresse);
        this.email = email;
        this.passwort = passwort;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPasswort()
    {
        return passwort;
    }

    public void setPasswort(String passwort)
    {
        this.passwort = passwort;
    }
}
