/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.DBProduct;
import DAL.DBUsers;
import Model.Category;
import Model.Product;
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
public class Edit_ProductServlet extends HttpServlet {

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
            out.println("<title>Servlet Edit_ProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Edit_ProductServlet at " + request.getContextPath() + "</h1>");
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
        String pid = request.getParameter("pid");

        DBProduct dbp = new DBProduct();
        ArrayList<Category> categorys = dbp.getCategory();
        if (pid != null && !pid.isEmpty()) {
            int productId = Integer.parseInt(pid);
            Product p = dbp.getProductId(productId);
            request.setAttribute("p", p);
        }
        for (Category category : categorys) {
            System.out.println(category.getCategoryId());
        }
        request.setAttribute("categorys", categorys);
        request.getRequestDispatcher("edit_product.jsp").forward(request, response);
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
        String pId = request.getParameter("pId");
        String pName = request.getParameter("pName");
        String pCategory = request.getParameter("pCategory");
        String pImg = request.getParameter("pImg");
        String pPrice = request.getParameter("pPrice");
        String pOPrice = request.getParameter("pOPrice");
        String pdescrip = request.getParameter("pdescrip");
        String action = request.getParameter("action");
        String comfirm = request.getParameter("comfirm");
        DBProduct dbp = new DBProduct();

        if (action != null && action.equals("update")) {
            if (comfirm != null && comfirm.equals("true")) {
                if (pId != null && !pId.isEmpty() && pName != null && !pName.isEmpty() 
                        && pCategory != null && !pCategory.isEmpty() && pImg != null && !pImg.isEmpty() 
                        && pPrice != null && !pPrice.isEmpty() && pOPrice != null && !pOPrice.isEmpty() 
                        && pdescrip != null && !pdescrip.isEmpty()) {
                    int productId = Integer.parseInt(pId);
                    int productCaId = Integer.parseInt(pCategory);
                    int productPrice = Integer.parseInt(pPrice);
                    int productOPrice = Integer.parseInt(pOPrice);

                    // Update product in the database
                    dbp.updateProduct(pName, productCaId,pImg, productPrice, productOPrice, pdescrip, productId);
                }
            }
        }

        response.sendRedirect("manager_product");
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
