package servlet;

import bl.ProductList;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dominik on 23.04.2015.
 */
public class IngredientServlet extends javax.servlet.http.HttpServlet {

    private ProductList m_ProdList;

    public void init() {
        this.m_ProdList = new ProductList();
        this.m_ProdList.addIngredient("", "Test", 12, 12);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int aufgabe = Integer.parseInt(request.getParameter("art"));
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (aufgabe == 1) {
            // Get Ingredient
            this.onGetIngredients(out);
        }
        else if (aufgabe == 2) {
            // Add ingredient
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            this.m_ProdList.addIngredient("", name, amount,price);
            this.onGetIngredients(out);
        }
    }

    private void onGetIngredients(PrintWriter out) {
        String output = "<tr><th>Name</th><th>Price</th><th>Amount</th></tr>";
        for (int i = 0; i < this.m_ProdList.countElements(); i++) {
            output += this.m_ProdList.getCurrentIngreident(i);
        }
        out.write(output);
    }
}
