package beans;

/**
 * Created by Dominik on 16.04.2015.
 */
public class Member extends Person
{
    private String email;
    private String passwort;

    public Member(String vorname, String nachname, Adresse adresse, String email, String passwort) {
        super(vorname, nachname, adresse);
        this.email = email;
        this.passwort = passwort;
    }
}
