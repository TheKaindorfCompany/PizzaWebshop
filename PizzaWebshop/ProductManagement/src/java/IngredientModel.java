package java;
import java.util.LinkedList;
/**
 * Created by Julian on 23.04.2015.
 */
public class IngredientModel {

    private LinkedList<Ingredient> ingredientsList = new LinkedList<Ingredient>();

    public IngredientModel(){

    }


    public void addIngredient(String picture,String name, int stk, float price)
    {
        Ingredient ingredient=new Ingredient(picture,name,price,stk);

        if(!ingredientsList.contains(ingredient))
        {
            ingredientsList.add(ingredient);
        }

    }

    public void deleteIngredient(Ingredient ingredient) {
        ingredientsList.remove(ingredient);
    }

    public LinkedList<Ingredient> search(String searchString)
    {
        LinkedList<Ingredient> searchList = new LinkedList<Ingredient>();
        for(Ingredient ingredient : ingredientsList)
        {
            String ingredientString = ingredient.getName();

            if(ingredientString.contains(searchString))
            {
                searchList.add(ingredient);
            }
        }
        return searchList;
    }
}
