package database;

import bl.Ingredient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * Product Management
 * Führt alle Datenbankzugriffe durch
 */
public class DB_Access {

    private DB_ConnectionPool connPool;

    private static DB_Access theInstance = null;
    // Es darf nur eine Instanz geben.
    public static DB_Access getInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DB_Access();
        }
        return theInstance;
    }

    private DB_Access() throws ClassNotFoundException {
        //connPool = DB_ConnectionPool.getInstance();
    }

    public LinkedList<Ingredient> getIngredients(String restaurantName) throws Exception {
        // Holt anhand des Restaurantnamen alle Ingredients aus der Datenbank
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "";
        if(restaurantName.isEmpty())
        {
            sqlString =""+
                    "SELECT i.name, i.price, i.amount, i.picture " +
                    "FROM ingredients i INNER JOIN restaurant r ON (i.restaurant_id = r.restaurant_id) " +
                    "WHERE UPPER(r.name) = '"+restaurantName.toUpperCase()+"';";
        }

        ResultSet rs = stat.executeQuery(sqlString);
        LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
        while (rs.next()) {
            String picture = rs.getString("picture");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            int stk = rs.getInt("amount");
            ingredients.add(new Ingredient(picture, name, price, stk));
        }
        connPool.releaseConnection(conn);
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) throws Exception {
        // Fügt ein neues Ingredient der Datenbank hinzu
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "INSERT INTO ingredient VALUES ("+"'"+ingredient.getPicture()+"', '"+ingredient.getName()+", "+ingredient.getPrice()+", "+ingredient.getStk()+");";

        int success = stat.executeUpdate(sqlString);

        connPool.releaseConnection(conn);
    }










}