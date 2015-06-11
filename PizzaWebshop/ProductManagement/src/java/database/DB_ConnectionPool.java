package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

/**
 * Produkt Management
 * Stellt die Verbindung zur Datenbank her und beendet diese auch wieder.
 */
public class DB_ConnectionPool implements DB_Config {

    private LinkedList<Connection> connections = new LinkedList<Connection>();
    private static final int MAX_CONN = 100;
    private static int num_conn = 0;

    private static DB_ConnectionPool theInstance = null;

    public static DB_ConnectionPool getInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DB_ConnectionPool();
        }
        return theInstance;
    }

    private DB_ConnectionPool() throws ClassNotFoundException {
        Class.forName(DB_DRIVER);
    }

    public synchronized Connection getConnection() throws Exception {
        if (connections.isEmpty()) {
            if (num_conn == MAX_CONN) {
                throw new Exception("Maximum number of connections reached");
            }
            Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWD);
            num_conn++;
            return conn;
        } else {
            return connections.poll();
        }
    }

    public synchronized void releaseConnection(Connection conn) {
        connections.offer(conn);
    }


}
