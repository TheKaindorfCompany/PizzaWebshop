package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author
 */
public final class DataBase
{

    private String URL;
    private String USER;
    private String PASSWORD;
    private String DRIVER;
    private String propertyFile = System.getProperty("user.dir") + File.separator + "src" + File.separator + "data" + File.separator + "db_props.properties";
    private Connection con;
    private CachedConnection cc;
    private static DataBase INSTANCE = null;

    private DataBase() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
    {
        loadPorperties();
        Class.forName(DRIVER);
        connect();
    }

    public static DataBase getInstance() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
    {
        if (INSTANCE == null)
        {
            INSTANCE = new DataBase();
        }

        return INSTANCE;
    }

    private void loadPorperties() throws FileNotFoundException, IOException
    {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(new File(propertyFile));
        props.load(fis);
        URL = props.getProperty("URL");
        USER = props.getProperty("USER");
        PASSWORD = props.getProperty("PASSWORD");
        DRIVER = props.getProperty("DRIVER");
    }

    public Statement getStatement() throws Exception
    {
        if (cc != null && con != null)
        {
            return cc.getStatement();
        }
        throw new Exception("not connected to DB prisondb");
    }

    public void releaseStatement(Statement stat) throws Exception
    {
        if (cc != null && con != null)
        {
            cc.releaseStatement(stat);
        } else
        {
            throw new Exception("not connected to DB prisondb");
        }
    }

    public Connection getCon()
    {
        return con;
    }

    public void setCon(Connection con)
    {
        this.con = con;
    }

    public void connect() throws SQLException
    {
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        cc = new CachedConnection(con);
    }
}
