package beans;

/**
 * Created by Enis Lushtaku on 16.04.2015.
 */
public class Adresse
{

    private String strasse;
    private String plz;
    private String ort;

    public Adresse(String strasse, String plz, String ort)
    {
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    public String getOrt()
    {
        return ort;
    }

    public void setOrt(String ort)
    {
        this.ort = ort;
    }

    public String getPlz()
    {
        return plz;
    }

    public void setPlz(String plz)
    {
        this.plz = plz;
    }

    public String getStrasse()
    {
        return strasse;
    }

    public void setStrasse(String strasse)
    {
        this.strasse = strasse;
    }

}
