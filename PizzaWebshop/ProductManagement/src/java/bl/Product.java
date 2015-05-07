package bl;

import java.util.LinkedList;

/**
 * Created by Veronika on 07.05.2015.
 */
public class Product {
    private LinkedList<Ingredient> list;
    private float price;

    public Product(LinkedList<Ingredient> list, float price) {
        this.list = list;
        this.price = price;
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
