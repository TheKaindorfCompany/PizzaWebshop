package beans;

/**
 * Created by Dominik on 16.04.2015.
 */
public class Member extends Person {
    String EMail;
    String password;

    public Member(String vorname, String nachname, Adresse adresse, String EMail, String password) {
        super(vorname, nachname, adresse);
        this.EMail = EMail;
        this.password = password;
    }
}
