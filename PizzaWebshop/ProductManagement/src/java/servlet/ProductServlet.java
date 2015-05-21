package servlet;

import bl.Ingredient;

import bl.Product;
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
        this.addTestDatensatz();
    }

    private void addTestDatensatz() {
        Ingredient testIng = new Ingredient("Cola",1);
        Ingredient testIng1 = new Ingredient("Eiswürfel",0.2f);
        LinkedList<Ingredient> testData = new LinkedList<Ingredient>();
        testData.add(testIng);
        testData.add(testIng1);
        this.addProduct("ColaMitEis", testData, "ColaMitEis");
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
            response.getWriter().write(this.getProductsAsTable());
        }
    }

    public String getProductsAsTable() {
        String prodOut = "<tr><th>Name</th></tr>";
        for(int i =0; i < this.m_ProductList.countElements(); i++) {
            Product aktProdukt = this.m_ProductList.getCurrentProduct(i);
            prodOut+=aktProdukt.toString();
        }
        return prodOut;
    }

}

