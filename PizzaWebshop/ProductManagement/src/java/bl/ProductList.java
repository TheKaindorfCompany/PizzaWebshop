package bl;
import java.util.LinkedList;
/**
 * Product Management
 * Verwaltungsklasse für die Produktliste
 */
public class ProductList {

    private LinkedList<Product> productList = new LinkedList<Product>();

    public ProductList(){

    }

    public Product getCurrentProduct(int index) throws IllegalArgumentException,IndexOutOfBoundsException
    {
        // Gibt das Aktuelle Produkt zurück anhand des Indexes
        if (index < 0) throw new IllegalArgumentException("Index can not be less than zero!");
        if (this.productList.size() <= index) throw new IndexOutOfBoundsException("Index is fewer than max size of list!");
        return productList.get(index);
    }


    public void addProduct(LinkedList<Ingredient> ingredientList, String name, String productId, String restName)
    {
        // Fügt ein neues Produkt hinzu
        Product product = new Product(ingredientList, name, productId, restName);

        if(!productList.contains(product))
        {
            productList.add(product);
        }

    }

    public void addProductObject(Product p) throws IllegalArgumentException {
        // Fügt ein neues ProduktObjekt in die Liste
        if (p == null) {
            throw new IllegalArgumentException("Product is null!");
        }
        this.productList.add(p);
    }

    public int countElements() {
        return this.productList.size();
    }

    public void deleteProduct(Product product) throws IllegalArgumentException{
        // Löscht ein Produkt aus der Liste
        if (product == null) throw new IllegalArgumentException("Error! Product to delete is null");
        productList.remove(product);
    }

    public LinkedList<Product> getProductsFromRestaurant(String restaurantName) throws IllegalArgumentException
    {
        // Vom Restaurant alle Produkte zurückgeben
        if (restaurantName == "") throw new IllegalArgumentException("No restaurant name!");

        LinkedList<Product> searchList = new LinkedList<Product>();
        for(Product product : productList)
        {
            String productString = product.getRestaurantName();

            if(productString.toUpperCase().equals(restaurantName.toUpperCase()))
            {
                searchList.add(product);
            }
        }
        return searchList;
    }
}
