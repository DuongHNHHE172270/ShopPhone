/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DBUsers;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ManagerServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException {
        DBUsers dbu = new DBUsers();
        int numberPage = dbu.getNumberPage();
        int numberUser = dbu.getTotalUser();
        String index = request.getParameter("index");

        if (index == null) {
            index = "1";
        }

        int indexPage = Integer.parseInt(index);
        ArrayList<Users> users;

        users = dbu.getPage(indexPage);

        request.setAttribute("users", users);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("indexPage", indexPage);
        request.setAttribute("numberUser", numberUser);
        request.getRequestDispatcher("manager.jsp").forward(request, response);
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
            throws ServletException, IOException {
        DBUsers dbu = new DBUsers();
        String action = request.getParameter("action");
        String confirm = request.getParameter("confirm");
        String uName = request.getParameter("uName");
        int numberPage = dbu.getNumberPageSearch(uName);
        String index = request.getParameter("indexPage");
        int numberUser = dbu.getTotalUser();
         
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);
        ArrayList<Users> users;
        users = dbu.getPage(indexPage);
        if (action != null && action.equals("delete")) {
            if (confirm != null && confirm.equals("true")) {
                String deleteId = request.getParameter("deleID");
                int uId = Integer.parseInt(deleteId);
                dbu.deleteUser(uId);
                
                users = dbu.getPage(indexPage);
                numberUser = dbu.getTotalUser();
            }
        }

        if (uName != null) {
            users = dbu.getSearchUserName(uName, indexPage);
            numberUser = dbu.getTotalUserSearch(uName);
            request.setAttribute("users", users);
            request.setAttribute("numberUser", numberUser);
        }

        // Cập nhật lại các thuộc tính cần thiết
        request.setAttribute("users", users);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("indexPage", indexPage);
        request.setAttribute("numberUser", numberUser);
        
        request.getRequestDispatcher("manager.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
