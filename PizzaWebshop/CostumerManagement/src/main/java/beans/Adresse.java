package beans;

/**
 * Created by Enis Lushtaku on 16.04.2015.
 */
public class Adresse
{
    private String straße;
    private String plz;
    private String ort;

    public Adresse(String straße, String plz, String ort)
    {
        this.straße = straße;
        this.plz = plz;
        this.ort = ort;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }
}
