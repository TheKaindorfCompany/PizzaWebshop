package bl;
import java.util.LinkedList;

/**
 * Product Management
 * Beans Klasse f�r Produkte
 *Product Management
 *Beansklasse f�s Produkt
 */
public class Product {
    private LinkedList<Ingredient> list;
    private float price;
    private String name;
    private String productId;
    private String restaurantName;

    public Product(LinkedList<Ingredient> list, String name, String productId) {
        this.list = list;
        this.calcPrice();
        this.name=name;
        this.productId= productId;
    }
    public Product(LinkedList<Ingredient> list, String name, String productId, String restName) {
        this(list, name, productId);
        this.restaurantName = restName;
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

    public void setRestaurantName(String name) {
        this.restaurantName = name;
    }
    public String getRestaurantName() {
        return this.restaurantName;
    }

    @Override
    public String toString() {
        String out = "<td>" + this.restaurantName + "</td>";

        out += "<td>";
        out += "  <div class=\"panel-group\" id=\"accordion\" role=\"tablist\" aria-multiselectable=\"true\">\n" +
                "    <div class=\"panel panel-default\">\n" +
                "      <div class=\"panel-heading\" role=\"tab\" id=\"headingOne\">\n" +
                "        <h4 class=\"panel-title\">\n" +
                "          <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapse"+this.getName().trim()+"\" aria-expanded=\"true\" aria-controls=\"collapseOne\">\n" +
                this.getName()+
                "          </a>\n" +
                "        </h4>\n" +
                "      </div>\n" +
                "      <div id=\"collapse"+this.getName().trim()+"\"\" class=\"panel-collapse collapse in\" role=\"tabpanel\" aria-labelledby=\"headingOne\">\n" +
                "        <div class=\"panel-body\"><ul>";

        for (Ingredient ing:this.list) {
            out += "<li>"+ing.getName()+"</li>";
        }
        out += "</ul> </div>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    </div>";

        return out;
    }
}
