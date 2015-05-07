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
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        String output = "";
        for (int i=0; i < this.m_ProdList.countElements(); i++) {
            output+= this.m_ProdList.getCurrentIngreident(i);
        }
        out.write(output);

    }
}
