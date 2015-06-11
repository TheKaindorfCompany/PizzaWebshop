package bl;
import java.util.LinkedList;
/**
 * Created by Julian on 23.04.2015.
 */
public class ProductList {

    private LinkedList<Product> productList = new LinkedList<Product>();

    public ProductList(){

    }

    public Product getCurrentProduct(int index) throws IllegalArgumentException,IndexOutOfBoundsException
    {
        if (index < 0) throw new IllegalArgumentException("Index can not be less than zero!");
        if (this.productList.size() <= index) throw new IndexOutOfBoundsException("Index is fewer than max size of list!");
        return productList.get(index);
    }


    public void addProduct(LinkedList<Ingredient> ingredientList, String name, String productId, String restName)
    {
        Product product = new Product(ingredientList, name, productId, restName);

        if(!productList.contains(product))
        {
            productList.add(product);
        }

    }

    public void addProductObject(Product p) throws IllegalArgumentException {
        if (p == null) {
            throw new IllegalArgumentException("Product is null!");
        }
        this.productList.add(p);
    }

    public int countElements() {
        return this.productList.size();
    }

    public void deleteProduct(Product product) throws IllegalArgumentException{
        if (product == null) throw new IllegalArgumentException("Error! Product to delete is null");
        productList.remove(product);
    }

    public LinkedList<Product> getProductsFromRestaurant(String restaurantName)
    {
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
