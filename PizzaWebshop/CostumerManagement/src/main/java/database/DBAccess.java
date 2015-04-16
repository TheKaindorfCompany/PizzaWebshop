package database;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by David on 09.04.2015.
 */
public class DBAccess {

    private Database db;

    public DBAccess(String databaseName) throws IOException, ClassNotFoundException, SQLException {
        db = new Database();
        db.connect(databaseName);
    }

    public void disconnect() throws SQLException {
        db.disconnect();
    }
}
