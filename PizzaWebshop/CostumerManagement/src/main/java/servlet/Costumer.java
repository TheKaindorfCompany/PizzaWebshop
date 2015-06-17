/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Enis Lushtaku
 */
@WebServlet(name = "Costumer", urlPatterns =
{
    "/Costumer"
})
public class Costumer extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            if (request.getParameter("bBestellen") != null)
            {
                response.sendRedirect(response.encodeRedirectURL("index.jsp")); //Seite von Ordermanagement wird ge�ffnet.
            }
            if (request.getParameter("bMeineBestellungen") != null)
            {
            }
            if (request.getParameter("bLogout") != null)
            {
                response.sendRedirect(response.encodeRedirectURL("anmeldung.java")); //Anmeldeseite wird wieder geöffnet
            }
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head lang=\"en\">\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <title></title>\n"
                    + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n"
                    + "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n"
                    + "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<div class=\"container\">\n"
                    + "\n"
                    + "    <form class=\"form-signin\" action=\"get\">\n"
                    + "        <h2 class=\"form-signin-heading\">Willkommen auf der Userpage</h2>\n"
                    + "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"bBestellen\">Bestellen</button>\n"
                    + "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"bMeineBestellungen\">Meine Bestellungen</button>\n"
                    + "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"bLogout\">Logout und zurück</button>\n"
                    + "    </form>\n"
                    + "\n"
                    + "</div>\n"
                    + "</body>\n"
                    + "</html>");
        } finally
        {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
