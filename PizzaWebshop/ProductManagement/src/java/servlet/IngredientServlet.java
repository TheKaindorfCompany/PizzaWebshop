package servlet;

import bl.IngredientModel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dominik on 23.04.2015.
 */
public class IngredientServlet extends javax.servlet.http.HttpServlet {

    private IngredientModel m_IngredientList;

    public void init() {
        this.m_IngredientList = new IngredientModel();

        this.m_IngredientList.addIngredient("", "Test", 12, 12);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int aufgabe = Integer.parseInt(request.getParameter("art"));
        String search = "";
        if (request.getParameter("serachFor") != null) {
            search = request.getParameter("searchFor");
        }

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (aufgabe == 1) {
            // Get Ingredient
            this.onGetIngredients(out, search);
        }
        else if (aufgabe == 2) {
            // Add ingredient
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            this.m_IngredientList.addIngredient("", name, amount, price);
            this.onGetIngredients(out, search);
        }
    }

    private void onGetIngredients(PrintWriter out, String restaurant) {
        String output = "<tr><th>Name</th><th>Price</th><th>Amount</th></tr>";
        for (int i = 0; i < this.m_IngredientList.countElements(); i++) {
            try {
                output += this.m_IngredientList.searchRestaurant(restaurant);
            } catch(Exception e) {

            }
        }
        out.write(output);
    }
}
