package database;

/**
 * Created by Dominik on 21.05.2015.
 */
import beans.Adresse;
import beans.Member;
import beans.Restaurant;
import beans.RestaurantOwner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class DBAccess
{

    private DataBase db;
    private Connection con;
    private PreparedStatement PreStmt = null;

    public DBAccess() throws Exception
    {
        db = DataBase.getInstance();
        con = db.getCon();
    }

    public LinkedList<Restaurant> getRestaurants() throws Exception
    {
        LinkedList<Restaurant> resList = new LinkedList<Restaurant>();
        Statement stat = db.getStatement();
        String sqlString = "SELECT strasse, plz, ort, laengengrad, breitengrad, name "
                + "FROM restaurants";
        ResultSet rs = stat.executeQuery(sqlString);
        rs.next();
        do
        {
            resList.add(new Restaurant(rs.getString("strasse"), rs.getString("plz"), rs.getString("ort"), rs.getString("name"), rs.getDouble("laengengrad"), rs.getDouble("breitengrad")));
        } while (!rs.last());
        return resList;
    }

    public LinkedList<Member> getMembers() throws Exception
    {
        LinkedList<Member> memList = new LinkedList<Member>();
        Statement stat = db.getStatement();
        String sqlString = "SELECT p.vorname, p.nachname, m.strasse, m.plz, m.ort, m.email, m.password "
                + "FROM member m INNER JOIN person p USING(pID)";

        ResultSet rs = stat.executeQuery(sqlString);
        rs.next();
        do
        {
            memList.add(new Member(rs.getString("p.vorname"), rs.getString("p.nachname"), new Adresse(rs.getString("m.strasse"), rs.getString("m.plz"), rs.getString("m.ort")), rs.getString("m.email"), rs.getString("m.email")));
        } while (!rs.last());
        return memList;
    }

    public LinkedList<Restaurant> getRestaurantsByOwner(String vorname, String nachname) throws Exception
    {
        LinkedList<Restaurant> resList = new LinkedList<Restaurant>();
        Statement stat = db.getStatement();
        String sqlString = "SELECT r.strasse, r.plz, r.ort, r.laengengrad, r.breitengrad, r.name "
                + "FROM restaurants r INNER JOIN owner o USING(oID) "
                + "WHERE o.vorname =" + vorname + " AND o.nachname =" + nachname;

        ResultSet rs = stat.executeQuery(sqlString);
        rs.next();
        do
        {
            resList.add(new Restaurant(rs.getString("r.strasse"), rs.getString("r.plz"), rs.getString("r.ort"), rs.getString("r.name"), rs.getDouble("r.laengengrad"), rs.getDouble("r.breitengrad")));
        } while (!rs.last());
        return resList;
    }

    public void addMember(Member nM) throws Exception
    {
        Statement stat = db.getStatement();
        String sqlString = "INSERT INTO mitarbeiter(vorname, nachname, strasse, plz, ort, email, password) "
                + "VALUES('" + nM.getVorname() + "', '" + nM.getNachname() + "', '" + nM.getAdresse().getStraﬂe() + "', " + nM.getAdresse().getPlz() + ", '" + nM.getAdresse().getOrt() + ", '" + nM.getEmail() + "', '" + nM.getPasswort() + "')";
        stat.execute(sqlString);
    }

    public LinkedList<RestaurantOwner> getOwner() throws Exception
    {
        LinkedList<RestaurantOwner> ownList = new LinkedList<RestaurantOwner>();
        Statement stat = db.getStatement();
        String sqlString = "SELECT p.vorname, p.nachname, o.strasse, o.plz, o.ort, o.email, o.password "
                + "FROM owner o INNER JOIN person p USING(pID)";
        ResultSet rs = stat.executeQuery(sqlString);
        rs.next();
        do
        {
            ownList.add(new RestaurantOwner(rs.getString("p.vorname"), rs.getString("p.nachname"), new Adresse(rs.getString("o.strasse"), rs.getString("o.plz"), rs.getString("o.ort")), rs.getString("o.email"), rs.getString("o.password"), this.getRestaurantsByOwner(rs.getString("p.vorname"), rs.getString("p.nachname"))));
        } while (!rs.last());
        return ownList;
    }

}
