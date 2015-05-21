package servlet;

import bl.Ingredient;

import bl.ProductList;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by dominik on 21.05.2015.
 */
public class ProductServlet extends javax.servlet.http.HttpServlet {
    private ProductList m_ProductList;
    public void init() {
        this.m_ProductList = new ProductList();
        LinkedList<Ingredient> testData = {
                new Ingredient()
        };
        this.addProduct("Test", new LinkedList<Ingredient>() {new Ingredient()});
    }

    public void addProduct(String name,  LinkedList<Ingredient> ingredients, String prodId) {
        this.m_ProductList.addProduct(ingredients, name, prodId);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        int art = Integer.parseInt(request.getParameter("art"));

        if (art == 1) {
            //auslesen aller Produkte

        }
    }

}

