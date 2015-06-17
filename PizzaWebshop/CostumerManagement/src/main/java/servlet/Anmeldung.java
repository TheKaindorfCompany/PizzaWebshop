/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Adresse;
import beans.Member;
import database.DBAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Enis Lushtaku
 */
@WebServlet(name = "AnmeldungServlet", urlPatterns =
{
    "/AnmeldungServlet"
})
public class Anmeldung extends HttpServlet
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
            if (request.getParameter("anmeldung") != null)
            {
                DBAccess access = new DBAccess();
                LinkedList<Member> members = access.getMember();
                String email;
                String password;
                if (!(request.getParameter("email") == null && request.getParameter("password") == null))
                {
                    email = request.getParameter("inputEmail");
                    password = request.getParameter("inputPassword");
                }
                for (Member m : members)
                {
                    if (m.getEmail().equals(email))
                    {
                        if (m.getPasswort().equals(password))
                        {
                            response.sendRedirect(response.encodeRedirectURL("Costumer.java"));
                        } else
                        {
                            out.print("alert(\"Password ist falsch! Bitte erneut eingeben\");");
                        }
                    } else
                    {
                        out.print("alert(\"User nicht vorhanden, bitte registrieren\");");
                    }
                }
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
                    + "<div class=\"container\">\n"
                    + "    <form class=\"form-signin\" ACTION=\"GET\">\n"
                    + "        <h2 class=\"form-signin-heading\">Bitte einloggen</h2>\n"
                    + "        <label for=\"inputEmail\" class=\"sr-only\">Email-Adresse</label>\n"
                    + "        <input type=\"email\" name=\"email\" id=\"inputEmail\" class=\"form-control\" placeholder=\"Email address\" required autofocus>\n"
                    + "        <label for=\"inputPassword\" class=\"sr-only\">Passwort</label>\n"
                    + "        <input type=\"password\" name=\"password\" id=\"inputPassword\" class=\"form-control\" placeholder=\"Password\" required>\n"
                    + "        <div class=\"checkbox\">\n"
                    + "            <label>\n"
                    + "                <input type=\"checkbox\" value=\"remember-me\"> Remember me\n"
                    + "            </label>\n"
                    + "        </div>\n"
                    + "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"anmeldung\">Anmeldung</button>\n"
                    + "        <button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"registrierung\">Registrierung</button>\n"
                    + "    </form>\n"
                    + "</div>\n"
                    + "</body>\n"
                    + "</html>");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
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
