package bl;

import database.DB_Access;

import java.util.LinkedList;

/**
 * Created by Julian on 07.05.2015.
 */
public class IngredientModel {
    private DB_Access dba;
    private LinkedList<Ingredient> ingredientList;
    public IngredientModel()
    {
        try {
            dba = DB_Access.getInstance();
            this.ingredientList = new LinkedList<Ingredient>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public LinkedList<Ingredient> getIngredientList(String restName) throws Exception {

        return dba.getIngredients(restName);

    }


    public Ingredient getCurrentIngridient(int index)
    {
        return ingredientList.get(index);
    }


    public void addIngredient(String picture,String name, int stk, float price)
    {
        Ingredient ingredient=new Ingredient(picture,name,price,stk);

        if(!ingredientList.contains(ingredient))
        {
            ingredientList.add(ingredient);
        }

    }

    public int countElements() {
        return this.ingredientList.size();
    }


}
