package bl;

import beans.Product;
import beans.Restaurant;
import beans.User;

import java.util.LinkedList;

public class DataCollection {
    private static LinkedList<User> users = new LinkedList<User>();
    private static LinkedList<Restaurant> restaurants = new LinkedList<Restaurant>();

    static {
        users.add(new User(1, "795 Folsom Ave, Suite 600<br>San Francisco, CA 94107<br>"));
        users.add(new User(2, "2 15th St NW<br>Washington, DC 20007<br>United States<br>"));

        restaurants.add(new Restaurant("Bread Zeppelin", 33.026994, -96.839671,
                "Bread Zeppelin is a place where you can feel good about eating something great. " +
                        "We know you’re taking a closer look into what you’re eating, " +
                        "so we’re taking a fresh approach to get you the nutrition you crave. " +
                        "Because your experience means everything.",
                "http://breadzeppelinsalads.com/wp-content/uploads/2012/12/cropped-BZ_Horizontal2.png",
                new Product("Chinese Chicken Salad", "Sliced Chicken Breast, Rice Noodles, Lettuce, " +
                        "Green Onions, Almonds, Crisp Wontons, Bean Sprouts, Orange and Sesame Seeds. " +
                        "Tossed in Our Special Chinese Plum Dressing.",
                        8.79,
                        "http://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChineseChickenSalad.jpg"),
                new Product("Luau Salad", "Sliced Chicken Breast, Rice Noodles, Lettuce, " +
                        "Grilled Chicken Breast Layered with Mixed Greens, Cucumbers, Red and Green Onions, " +
                        "Red and Yellow Peppers, Green Beans, Carrots, Mango and Crisp Wontons with Macadamia" +
                        " Nuts and Sesame Seeds. Tossed in Our Vinaigrette.",
                        9.79,
                        "http://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LuauSalad.jpg"),
                new Product("Barbeque Ranch Chicken Salad", "Avocado, Tomato, Grilled Corn, Black Beans, " +
                        "Cucumber and Romaine All Tossed with Our Barbeque Ranch Dressing. Topped with " +
                        "Lots of Crispy Fried Onion Strings for Crunch.",
                        10.79,
                        "http://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_BarbequeRanchChickenSalad.jpg")));
        restaurants.add(new Restaurant("Frying Nemo", 37.806619, -122.406102,
                "Frying Nemo is on the waterfront of the Marina at Tipperary Waters, just minutes " +
                        "from Darwin’s city centre. With parking at the Frances Bay Village " +
                        "Shopping Centre off Tiger Brennan Drive in Stuart Park.",
                "http://www.fryingnemo.com.au/wp-content/uploads/2014/03/nemologofinal-e1395105639269-150x150.png",
                new Product("Chargrilled monkfish kebabs", "A really nice way to eat fish.",
                        7.49,
                        "http://s3-eu-west-1.amazonaws.com/jamieoliverprod/_int/rdb2/upload/1549_1_1432031382_lrg.jpg"
                )));
        restaurants.add(new Restaurant("Thai Tanic", 38.908155, -77.032382,
                "We are a small establishment who want to be part of community. " +
                        "Thai tanic is the place that you can come to get a very good " +
                        "food at very affordable price in the unique of its own image " +
                        "and charm. Thai tanic is the place that you can be very " +
                        "comtable even you are by yourself, " +
                        "or be in the company with your friend and love one. ",
                "http://www.an-mag.com/wp-content/uploads/2014/02/tumblr_mhj96rfFgb1qmpqfmo1_1280.jpg",
                new Product("Yam Wunsen Kung", "Balance, detail and variety are of paramount significance to Thai chefs.",
                        10,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Yam_wun_sen.JPG/261px-Yam_wun_sen.JPG"
                )));
        restaurants.add(new Restaurant("Lord of the Wings", -27.504370, 153.099889,
                "+14 signature chicken wings sauces and +300,000 " +
                        "ways to build your own burger... " +
                        "only at... Lord of the Wings!!",
                "https://scontent-vie1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/11535863_10153117890843801_8816977617320602181_n.png?oh=f5a3be3dcda0b8f92749827d8fa11079&oe=55F30547",
                new Product("Chargrilled monkfish kebabs", "A really nice way to eat fish.",
                        7.49,
                        "http://s3-eu-west-1.amazonaws.com/jamieoliverprod/_int/rdb2/upload/1549_1_1432031382_lrg.jpg"
                )));
        restaurants.add(new Restaurant("Wok this Way", 34.139366, -117.575128,
                "We are a family run catering business based in Littleport, " +
                        "with over 50 years’ experience in the food industry. " +
                        "Wok This Way is here to bring you traditional unique " +
                        "recipes passed down from generations, prepared for " +
                        "you with the upmost care and fresh local ingredients. " +
                        "We aim to bring all of our customers the best value " +
                        "for money quality food with impeccable services.",
                "http://www.fryingnemo.com.au/wp-content/uploads/2014/03/nemologofinal-e1395105639269-150x150.png",
                new Product("Lemon Infused", "A classic! Battered and deep fried then accompanied by our homemade\n" +
                        "lemon sauce made with lemons and ginger.",
                        7.49,
                        "http://wok-this-way.com/wp-content/uploads/2014/03/Lemon-Infused-Chicken-300x160.png"
                )));
    }


    public static User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public static LinkedList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static String linkToUserPage(int userId) {
        return "";
    }
}
