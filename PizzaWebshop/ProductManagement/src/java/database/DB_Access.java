package database;

import bl.Ingredient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import bl.Product;

/**
 * Created by Juergen on 23.04.2015.
 */
public class DB_Access {

    private DB_ConnectionPool connPool;

    private static DB_Access theInstance = null;

    public static DB_Access getInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DB_Access();
        }
        return theInstance;
    }

    private DB_Access() throws ClassNotFoundException {
        connPool = DB_ConnectionPool.getInstance();
    }

    public LinkedList<Ingredient> getIngredients(String restaurantName) throws Exception {
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "";
        if(restaurantName.isEmpty())
        {
            sqlString = "SELECT picture, name, price, stk FROM Ingredients;";
        }

        else{

        }


        ResultSet rs = stat.executeQuery(sqlString);
        LinkedList<Ingredient> ingredients = new LinkedList<Ingredient>();
        while (rs.next()) {
            String picture = rs.getString("picture");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            int stk = rs.getInt("stk");
            ingredients.add(new Ingredient(picture, name, price, stk));
        }
        connPool.releaseConnection(conn);
        return ingredients;
    }

    public void insertIngredient(Ingredient ingredient) throws Exception {
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "INSERT INTO ingredient VALUES ("+"'"+ingredient.getPicture()+"', '"+ingredient.getName()+", "+ingredient.getPrice()+", "+ingredient.getStk()+");";

        int success = stat.executeUpdate(sqlString);

        connPool.releaseConnection(conn);
    }





}