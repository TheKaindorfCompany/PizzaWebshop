package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by David on 09.04.2015.
 */
public class Database {

    private String DB_Driver = "";
    private String DB_Username = "";
    private String DB_Password = "";
    private String DB_Url = "";
    private Connection con;

    public Connection getCon() {
        return con;
    }

    private final String fileName = System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "data"
            + File.separator + "dbproperties.properties";

    private static Database theInstance = null;

    public static Database getInstance() throws IOException, ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new Database();
        }
        return theInstance;
    }

    public Database() throws IOException, ClassNotFoundException {
        loadProperties();
        Class.forName(this.DB_Driver);
    }

    public void connect(String dbname) throws SQLException {
        con = DriverManager.getConnection(DB_Url + dbname, DB_Username, DB_Password);
        System.out.println("is connected to database '" + dbname + "'");
    }

    public void disconnect() throws SQLException {
        con.close();
        System.out.println("disconnected to database");
    }

    private void loadProperties() throws FileNotFoundException, IOException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream(fileName);
        props.load(in);
        DB_Driver = props.getProperty("driver");
        System.out.println(DB_Driver);
        DB_Username = props.getProperty("username");
        DB_Password = props.getProperty("password");
        DB_Url = props.getProperty("url");
    }
}
