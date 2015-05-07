package servlet;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dominik on 23.04.2015.
 */
public class IngredientServlet extends javax.servlet.http.HttpServlet {

    public void init() {

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();

    }
}
