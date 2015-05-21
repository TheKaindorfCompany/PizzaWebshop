package bl;
import java.util.LinkedList;
/**
 * Created by Julian on 23.04.2015.
 */
public class ProductList {

    private LinkedList<Product> productList = new LinkedList<Product>();

    public ProductList(){

    }

    public Product getCurrentProduct(int index)
    {
        return productList.get(index);
    }


    public void addProduct(LinkedList<Ingredient> ingredientList, String name, float price, String productId)
    {
        Product product = new Product(ingredientList, price, name, productId);


        if(!productList.contains(product))
        {
            productList.add(product);
        }

    }

    public int countElements() {
        return this.productList.size();
    }

    public void deleteProduct(Product product) {
        productList.remove(product);
    }

    public LinkedList<Product> search(String searchString)
    {
        LinkedList<Product> searchList = new LinkedList<Product>();
        for(Product product : productList)
        {
            String productString = product.getName();

            if(productString.contains(searchString))
            {
                searchList.add(product);
            }
        }
        return searchList;
    }
}
