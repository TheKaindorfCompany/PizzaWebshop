package servlet;

import bl.IngredientModel;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Product Managment
 * Servlet als Schnittstelle für Products
 * @author Dominik Sammer
 */
public class IngredientServlet extends javax.servlet.http.HttpServlet {

    private IngredientModel m_IngredientList;

    public void init() {
        this.m_IngredientList = new IngredientModel();

        this.m_IngredientList.addIngredient("", "Salami", 12, 1.4f);
        this.m_IngredientList.addIngredient("", "Mozarella", 12, 5);
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
            this.onGetIngredients(out);
        }
        else if (aufgabe == 2) {
            // Add ingredient
            String name = request.getParameter("name");
            float price = Float.parseFloat(request.getParameter("price"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            this.m_IngredientList.addIngredient("", name, amount, price);
            this.onGetIngredients(out);
        }
        else if (aufgabe == 3) {
            // Edit ingredient
            String newName = request.getParameter("name");
            int index = Integer.parseInt(request.getParameter("index").split(" ")[1]);
            float price = Float.parseFloat(request.getParameter("price"));
            boolean isCorrect = this.m_IngredientList.changeElement(index, price,newName);
            this.onGetIngredients(out);
        }
        else if (aufgabe == 4) {
            //create select for product creator
            String output = "<option value=''></option>";
            for(int i=0; i < this.m_IngredientList.countElements(); i++) {
                output += "<option value='" + this.m_IngredientList.getCurrentIngredient(i).getName() +"'>" +
                        this.m_IngredientList.getCurrentIngredient(i).getName() + "</option>";
            }
            response.getWriter().write(output);
        }

    }

    private void onGetIngredients(PrintWriter out) {
        String output = "<tr><th>Name</th><th>Price</th><th>Amount</th></tr>";
        for (int i = 0; i < this.m_IngredientList.countElements(); i++) {
            try {
                if (this.m_IngredientList.getCurrentIngredient(i).getName() != "")
                    output += "<tr><td><input type='text' name='"+this.m_IngredientList.getCurrentIngredient(i).getName() + "' " +
                            "readonly value='"+this.m_IngredientList.getCurrentIngredient(i).getName()+"'" +
                            "id='inp "+i+" Name'></td>";
                    output += "<td><input type='text' readonly value='"+this.m_IngredientList.getCurrentIngredient(i).getPrice()+"'" +
                            " name='"+this.m_IngredientList.getCurrentIngredient(i).getName() + "'" +
                            "id='inp "+i+" Price'></td>";
                    output += "<td>"+this.m_IngredientList.getCurrentIngredient(i).getStk()+"</td>" +
                            "<td><button class='btn btn-default' onclick='editIngredient(\"" + this.m_IngredientList.getCurrentIngredient(i).getName() + "\")" +
                            "' id='btn"+this.m_IngredientList.getCurrentIngredient(i).getName()+"'" +
                            "name='btn "+i+"'>Edit Ingredient</button></td>" +

                            "<td><button class='btn btn-default' onclick='erhoeheMenge(\"" + i + "\")'>Change Amount</button></td>" +
                            "</tr>";
            } catch(Exception e) {

            }
        }
        out.write(output);
    }
}
