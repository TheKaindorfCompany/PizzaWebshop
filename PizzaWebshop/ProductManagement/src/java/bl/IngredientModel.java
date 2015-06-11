package bl;

import database.DB_Access;

import java.util.LinkedList;

/**
 * Product Management
 * Zuständig für die Verwaltung der Ingredient Liste
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

    public int getIndexOfIngredientByName(String name) {
        // Gibt den Index des Ingredients mit anhand des Namens
        int index = -1;
        for(Ingredient ing : this.ingredientList) {
            index++;
            if (ing.getName() == name) return index;
        }
        return -1;
    }

    public boolean changeElement(int index, float price, String name) {
        // Updated ein Ingredient anhand des Index, dem Preis und dem Namen
        try {
            Ingredient element = this.ingredientList.get(index);
            element.setName(name);
            element.setPrice(price);
            this.ingredientList.set(index, element);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public LinkedList<Ingredient> getIngredientList(String restName) throws Exception {

        return dba.getIngredients(restName);

    }

    public Ingredient getCurrentIngredient(int index) throws IllegalArgumentException {

        // gibt das Ingredient anhand des Indexes zurück
        if (index < 0) throw new IllegalArgumentException("Cannot a listelement for index less than 0!");
        return ingredientList.get(index);
    }


    public void addIngredient(String picture, String name, int stk, float price) {
        //Fügt ein neues Ingredient mit Bild und Stückzahl hinzu.
        Ingredient ingredient = new Ingredient(picture, name, price, stk);

        if (!ingredientList.contains(ingredient)) {
            ingredientList.add(ingredient);
        }
    }

    public void addIngredientObject(Ingredient ing) throws IllegalArgumentException {
        // Fügt ein IngredientsObjekt zur Liste hinzu.
        if (ing == null) throw new IllegalArgumentException("Ingredient is null!");

        this.ingredientList.add(ing);
    }

    public int countElements() {
        return this.ingredientList.size();
    }

    public LinkedList<Ingredient> searchIngredient(String searchString) {
        // Gibt alle Ingredients zurück die im Namen den String enthalten
        LinkedList<Ingredient> newList = new LinkedList<Ingredient>();
        for (Ingredient ingredient : ingredientList) {
            if (ingredient.getName().contains(searchString)) {
                newList.add(ingredient);
            }
        }
        return newList;
    }

    public LinkedList<Ingredient> searchRestaurant(String restaurantName) throws Exception {
        // Gibt für ein Restaurant alle Ingredients zurück
        LinkedList<Ingredient> newList = new LinkedList<Ingredient>();

        newList = dba.getIngredients(restaurantName);
        return newList;
    }
}


