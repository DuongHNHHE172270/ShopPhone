package Controller;

import DAL.DBCart;
import DAL.DBContext;
import DAL.DBProduct;
import Model.Cart;
import Model.Category;
import Model.Color;
import Model.Item;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HomeServlet extends HttpServlet {

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
            out.println("<title>Servlet HomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
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
        ArrayList<Category> categorys = dbp.getCategory();
        ArrayList<Color> colors = dbp.getColor();
        int numberPage = dbp.getNumberPage();
        String searchProductName = request.getParameter("searchProductName");
        String index = request.getParameter("index");
        String cate = request.getParameter("cate");
        String color = request.getParameter("color");

        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);

        ArrayList<Product> products;

        products = dbp.getPage(indexPage);

        if (cate != null && !cate.isEmpty()) {
            int cateId = Integer.parseInt(cate);
            products = dbp.searchByCategory(cateId, indexPage);
            request.setAttribute("cateId", cateId);
        }
        if (color != null && !color.isEmpty()) {
            int colorId = Integer.parseInt(color);
            products = dbp.searchByColor(colorId, indexPage);
            request.setAttribute("colorId", colorId);
        }
        if (searchProductName != null && !searchProductName.isEmpty()) {
            products = dbp.searchByName(searchProductName, indexPage);
            request.setAttribute("searchProductName", searchProductName);
        }

        request.setAttribute("numberPage", numberPage);
        request.setAttribute("searchProductName", searchProductName);
        request.setAttribute("indexPage", indexPage);
        request.setAttribute("categorys", categorys);
        request.setAttribute("products", products);
        request.setAttribute("colors", colors);

        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        DBProduct dbp = new DBProduct();
        ArrayList<Category> categorys = dbp.getCategory();
        ArrayList<Color> colors = dbp.getColor();
        

        String index = request.getParameter("index");
        String cate = request.getParameter("cate");
        String color = request.getParameter("color");
        String searchProductName = request.getParameter("searchProductName");
        String uId = request.getParameter("uId");
        int numberPage = dbp.getNumberPage();
        HttpSession session = request.getSession(true);
        Cart cart = null;
   
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);

        ArrayList<Product> products;

        products = dbp.getPage(indexPage);

        if (cate != null && !cate.isEmpty()) {
            int cateId = Integer.parseInt(cate);
            products = dbp.searchByCategory(cateId, indexPage);
            request.setAttribute("cateId", cateId);
        }
        if (color != null && !color.isEmpty()) {
            int colorId = Integer.parseInt(color);
            products = dbp.searchByColor(colorId, indexPage);
            request.setAttribute("colorId", colorId);
        }
        if (searchProductName != null && !searchProductName.isEmpty()) {
            products = dbp.searchByName(searchProductName, indexPage);
            numberPage = dbp.getNumberPageSearch(searchProductName);
            request.setAttribute("searchProductName", searchProductName);
            request.setAttribute("numberPage", numberPage);
        }

        Object o = session.getAttribute("cart_" + uId);
        if (o != null) {
            cart = (Cart) o;
        } else {
            cart = new Cart();
        }
        String pId = request.getParameter("pId");
        int id;
        int num = 1;
        try {
            id = Integer.parseInt(pId);
            Product p = dbp.getProductId(id);
            double price = p.getPrice();
            Item t = new Item(p, num, price);
            cart.addItem(t);

        } catch (NumberFormatException e) {
            num = 1;
        }
        List<Item> list = cart.getItems();

        session.setAttribute("cart", cart);
        session.setAttribute("list", list.size());

        request.setAttribute("numberPage", numberPage);
        request.setAttribute("indexPage", indexPage);
        request.setAttribute("categorys", categorys);
        request.setAttribute("products", products);
        request.setAttribute("colors", colors);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
