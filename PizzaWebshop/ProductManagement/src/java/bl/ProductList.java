package bl;
import java.util.LinkedList;
/**
 * Created by Julian on 23.04.2015.
 */
public class ProductList {

    private LinkedList<Ingredient> ingredientsList = new LinkedList<Ingredient>();

    public ProductList(){

    }

    public Ingredient getCurrentIngreident(int index)
    {
        return ingredientsList.get(index);
    }


    public void addIngredient(String picture,String name, int stk, float price)
    {
        Ingredient ingredient=new Ingredient(picture,name,price,stk);

        if(!ingredientsList.contains(ingredient))
        {
            ingredientsList.add(ingredient);
        }

    }

    public int countElements() {
        return this.ingredientsList.size();
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
