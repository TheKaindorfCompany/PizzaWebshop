package bl;

import database.DB_Access;

import java.util.LinkedList;

/**
 * Created by Julian on 07.05.2015.
 */
public class IngredientModel {
    private DB_Access dba;
    private LinkedList<Ingredient> ingredientList;

    public IngredientModel() {
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

    public Ingredient getCurrentIngridient(int index) {
        return ingredientList.get(index);
    }


    public void addIngredient(String picture, String name, int stk, float price) {
        Ingredient ingredient = new Ingredient(picture, name, price, stk);

        if (!ingredientList.contains(ingredient)) {
            ingredientList.add(ingredient);
        }

    }

    public int countElements() {
        return this.ingredientList.size();
    }

    public LinkedList<Ingredient> searchIngredient(String searchString) {
        LinkedList<Ingredient> newList = new LinkedList<Ingredient>();
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().contains(searchString)) {
                newList.add(ingredient);
            }
        }
        return newList;
    }

    public LinkedList<Ingredient> searchRestaurant(String restaurantName) throws Exception {
        LinkedList<Ingredient> newList = new LinkedList<Ingredient>();

        newList = dba.getIngredients(restaurantName);
        return newList;
    }
}


