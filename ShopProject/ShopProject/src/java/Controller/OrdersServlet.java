/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DBProduct;
import Model.OrderDetail;
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
public class OrdersServlet extends HttpServlet {

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
            out.println("<title>Servlet OrdersServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrdersServlet at " + request.getContextPath() + "</h1>");
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
        DBProduct dbp = new DBProduct();
        ArrayList<OrderDetail> orderDetails = dbp.getAllOrder();
        request.setAttribute("orderDetails", orderDetails);
        int totalOrderMoney = 0;
        for (OrderDetail orderDetail : orderDetails) {
            totalOrderMoney += orderDetail.getPrice();
        }
        int totalOrder = 0;
        for (OrderDetail orderDetail : orderDetails) {
            totalOrder++;
        }
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("totalOrderMoney", totalOrderMoney);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
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
        String oName = request.getParameter("oName");
        DBProduct dbp = new DBProduct();
        ArrayList<OrderDetail> orderDetails = dbp.getAllOrderSearch(oName);
        request.setAttribute("orderDetails", orderDetails);
        int totalOrderMoney = 0;
        for (OrderDetail orderDetail : orderDetails) {
            totalOrderMoney += orderDetail.getPrice();
        }
        int totalOrder = 0;
        for (OrderDetail orderDetail : orderDetails) {
            totalOrder++;
        }
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("totalOrderMoney", totalOrderMoney);
        request.getRequestDispatcher("orders.jsp").forward(request, response);
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
