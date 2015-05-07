package bl;

import database.DB_Access;

import java.util.LinkedList;

/**
 * Created by Julian on 07.05.2015.
 */
public class IngredientModel {

    private String restName="";
    private DB_Access dba;
    private LinkedList<Ingredient> ingredientList;
    public IngredientModel(String restName)
    {
        this.restName=restName;
        try {
             dba = DB_Access.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void getIngredientList() throws Exception {

        ingredientList = dba.getIngredients(restName);





    }


}
