package bl;

import java.util.LinkedList;

/**
 * Created by Veronika on 07.05.2015.
 */
public class Product {
    private LinkedList<Ingredient> list;
    private float price;
    private String name;
    private String productId;

    public Product(LinkedList<Ingredient> list, float price, String name, String productId) {
        this.list = list;
        this.price = price;
        this.name=name;
        this.productId= productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void calcPrice()
    {
        float sum=0;
        for(Ingredient i: list)
        {
            sum+=i.getPrice();
        }
        price=sum;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LinkedList<Ingredient> getList() {
        return list;
    }

    public void setList(LinkedList<Ingredient> list) {
        this.list = list;
    }
}
