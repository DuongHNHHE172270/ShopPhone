/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Category;
import Model.Color;
import Model.OrderDetail;
import Model.Orders;
import Model.Product;
import Model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBProduct extends DBContext {

    public int getNumberPage() {
        String sql = "select COUNT(*) from product ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 9;
                if (total % 9 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getNumberPageSearch(String pName) {
        String sql = "select COUNT(*) from product where productName like ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + pName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 9;
                if (total % 9 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getTotalSearch(String pName) {
        String sql = "select COUNT(*) from product where productName like ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + pName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);

                return total;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getTotalSearchCate(String cName) {
        String sql = "select COUNT(*) from category where categoryName like ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + cName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);

                return total;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getNumberPageSearchCate(String cName) {
        String sql = "select COUNT(*) from category where categoryName like ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + cName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 9;
                if (total % 9 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getTotalProduct() {
        String sql = "select COUNT(*) from product";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);

                return total;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getTotalCategory() {
        String sql = "select COUNT(*) from category";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);

                return total;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getNumberPageCategory() {
        String sql = "select COUNT(*) from category ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 9;
                if (total % 9 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public ArrayList<Category> getPageCate(int index) {
        String sql = "SELECT c.categoryId, c.categoryName, c.status "
                + "FROM category c "
                + "ORDER BY categoryId OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
        ArrayList<Category> categorys = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));

                categorys.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return categorys;
    }

    public ArrayList<Product> getPage(int index) {
        String sql = "SELECT p.productId, p.productName, p.imagePath, p.price, p.originalPrice, p.viewCount, p.description, "
                + "p.status, c.categoryId, c.categoryName, c.status "
                + "FROM product p JOIN category c ON p.categoryId = c.categoryId "
                + "ORDER BY productId OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setImagePath(rs.getString("imagePath"));
                p.setPrice(rs.getInt("price"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setViewCount(rs.getInt("viewCount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));

                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                p.setCategoryId(c);

                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    public ArrayList<Product> searchByCategory(int cateId, int index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.productId, p.productName, p.imagePath, p.price, p.originalPrice, p.viewCount, p.description, \n"
                    + "p.status, c.categoryId, c.categoryName, c.status\n"
                    + "FROM product p JOIN category c ON p.categoryId = c.categoryId  where c.categoryId = ? order by p.productId\n"
                    + "offset ? rows fetch first 9 rows ONLY";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cateId);
            statement.setInt(2, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setImagePath(rs.getString("imagePath"));
                p.setPrice(rs.getInt("price"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setViewCount(rs.getInt("viewCount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));

                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                p.setCategoryId(c);

                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    public ArrayList<Category> getCategory() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT c.categoryId, c.categoryName, c.status, COUNT(p.productId) as totalProducts "
                    + "FROM category c LEFT JOIN product p ON p.categoryId = c.categoryId "
                    + "GROUP BY c.categoryId, c.categoryName, c.status";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                c.setTotalProduct(rs.getInt("totalProducts"));

                categories.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return categories;
    }

    public ArrayList<Color> getColor() {
        ArrayList<Color> colors = new ArrayList<>();
        try {
            String sql = "select c.colorId, c.name, COUNT(c.colorId) as totalColor \n"
                    + "from color c left join product_color p on c.colorId = p.colorId \n"
                    + "group by c.colorId, c.name";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Color c = new Color();
                c.setColorId(rs.getInt("colorId"));
                c.setName(rs.getString("name"));
                c.setTotalColor(rs.getInt("totalColor"));

                colors.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return colors;
    }

    public ArrayList<Product> searchByColor(int colorId, int index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.productId, p.productName, p.imagePath, p.price, p.originalPrice, p.viewCount, p.description, \n"
                    + "p.status, c.categoryId, c.categoryName, c.status\n"
                    + "FROM product p JOIN category c ON p.categoryId = c.categoryId "
                    + "JOIN product_color pc ON p.productId = pc.productId "
                    + "WHERE pc.colorId = ? ORDER BY p.productId OFFSET ? ROWS FETCH FIRST 9 ROWS ONLY";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, colorId);
            statement.setInt(2, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setImagePath(rs.getString("imagePath"));
                p.setPrice(rs.getInt("price"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setViewCount(rs.getInt("viewCount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));

                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                p.setCategoryId(c);

                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    public ArrayList<Product> searchByName(String productName, int index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.productId, p.productName, p.imagePath, p.price, p.originalPrice, p.viewCount, p.description, "
                    + "p.status, c.categoryId, c.categoryName, c.status "
                    + "FROM product p JOIN category c ON p.categoryId = c.categoryId "
                    + "WHERE p.productName LIKE ? "
                    + "ORDER BY productId OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + productName + "%");
            statement.setInt(2, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setImagePath(rs.getString("imagePath"));
                p.setPrice(rs.getInt("price"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setViewCount(rs.getInt("viewCount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));

                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                p.setCategoryId(c);

                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    public ArrayList<Category> searchByNameCate(String cateName, int index) {
        ArrayList<Category> categorys = new ArrayList<>();
        try {
            String sql = "SELECT c.categoryId, c.categoryName, c.status "
                    + "FROM category c "
                    + "WHERE c.categoryName LIKE ? "
                    + "ORDER BY categoryId OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + cateName + "%");
            statement.setInt(2, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));

                categorys.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return categorys;
    }

    public Product getProductId(int productId) {
        try {
            String sql = "SELECT p.productId, p.productName, p.imagePath, p.price, p.originalPrice, p.viewCount, p.description, \n"
                    + "p.status, c.categoryId, c.categoryName, c.status \n"
                    + "FROM product p JOIN category c ON p.categoryId = c.categoryId  where p.productId = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setImagePath(rs.getString("imagePath"));
                p.setPrice(rs.getInt("price"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setViewCount(rs.getInt("viewCount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));

                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                p.setCategoryId(c);

                return p;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.productId, p.productName, p.imagePath, p.price, p.originalPrice, p.viewCount, p.description, \n"
                    + "p.status, c.categoryId, c.categoryName, c.status \n"
                    + "FROM product p JOIN category c ON p.categoryId = c.categoryId";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setImagePath(rs.getString("imagePath"));
                p.setPrice(rs.getInt("price"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setViewCount(rs.getInt("viewCount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));

                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                p.setCategoryId(c);

                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }

        return products;
    }

    public void updateProduct(String productName, int categoryId, String imagePath, int price, int originalPrice, String description, int productId) {
        try {
            String sql = "UPDATE product SET productName = ?,categoryId = ?, imagePath = ?,  price = ?, originalPrice= ?, description = ? Where productId = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setInt(2, categoryId);
            statement.setString(3, imagePath);
            statement.setInt(4, price);
            statement.setInt(5, originalPrice);
            statement.setString(6, description);
            statement.setInt(7, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteProductById(String pId) {
        try {
            String sql = "DELETE FROM product WHERE productId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pId);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void insertProduct(String pName, String pImg, int pPrice, int pOPrice, String pDrescrip, int PCa) {
        try {
            String sql = "insert into product (productName, imagePath, price, originalPrice, viewCount, description, status , categoryId) values (?, ?, ?, ?, 0, ?, 1, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pName);
            statement.setString(2, pImg);
            statement.setInt(3, pPrice);
            statement.setInt(4, pOPrice);
            statement.setString(5, pDrescrip);
            statement.setInt(6, PCa);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Product> getPageViews(int index) {
        String sql = "SELECT p.productId, p.productName, p.imagePath, p.price, p.originalPrice, p.viewCount, p.description, \n"
                + "p.status, c.categoryId, c.categoryName, c.status \n"
                + "FROM product p JOIN category c ON p.categoryId = c.categoryId \n"
                + "ORDER BY viewCount DESC OFFSET 0 ROWS FETCH NEXT 9 ROWS ONLY";
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setProductName(rs.getString("productName"));
                p.setImagePath(rs.getString("imagePath"));
                p.setPrice(rs.getInt("price"));
                p.setOriginalPrice(rs.getInt("originalPrice"));
                p.setViewCount(rs.getInt("viewCount"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));

                Category c = new Category();

                c.setCategoryId(rs.getInt("categoryId"));
                c.setCategoryName(rs.getString("categoryName"));
                c.setStatus(rs.getInt("status"));
                p.setCategoryId(c);

                products.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return products;
    }

    public ArrayList<OrderDetail> getAllOrder() {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        try {
            String sql = "SELECT od.orderDetailId, o.orderId, o.userId, o.bookingDate,u.userName, p.productId, \n"
                    + "                     p.productName, p.imagePath, p.price, p.originalPrice, \n"
                    + "                     p.viewCount, p.description, p.status, c.categoryId, \n"
                    + "                     c.categoryName, c.status, od.quantity, od.price \n"
                    + "                     FROM orderDetail od\n"
                    + "                     INNER JOIN orders o ON od.orderId = o.orderId \n"
                    + "                     INNER JOIN users u ON o.userId = u.userId \n"
                    + "                     INNER JOIN product p ON od.productId = p.productId \n"
                    + "                     INNER JOIN category c ON p.categoryId = c.categoryId";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OrderDetail o = new OrderDetail();
                o.setOrderDetailId(rs.getInt("orderDetailId"));

                Orders order = new Orders();
                order.setOrderId(rs.getInt("orderId"));
                order.setBookingDate(rs.getDate("bookingDate"));

                Users user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));

                order.setUserId(user);

                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setImagePath(rs.getString("imagePath"));
                product.setPrice(rs.getInt("price"));
                product.setOriginalPrice(rs.getInt("originalPrice"));
                product.setViewCount(rs.getInt("viewCount"));
                product.setDescription(rs.getString("description"));
                product.setStatus(rs.getInt("status"));

                Category category = new Category();
                category.setCategoryId(rs.getInt("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setStatus(rs.getInt("status"));

                product.setCategoryId(category);

                o.setOrderId(order);
                o.setProductId(product);
                o.setQuantity(rs.getInt("quantity"));
                o.setPrice(rs.getFloat("price"));

                orderDetails.add(o);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return orderDetails;
    }

    public ArrayList<OrderDetail> getAllOrderSearch(String userName) {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        try {
            String sql = "SELECT od.orderDetailId, o.orderId, o.userId, o.bookingDate, o.totalMoney,u.userName, p.productId, \n"
                    + "                     p.productName, p.imagePath, p.price, p.originalPrice, \n"
                    + "                     p.viewCount, p.description, p.status, c.categoryId, \n"
                    + "                     c.categoryName, c.status, od.quantity, od.price \n"
                    + "                     FROM orderDetail od\n"
                    + "                     INNER JOIN orders o ON od.orderId = o.orderId \n"
                    + "                     INNER JOIN users u ON o.userId = u.userId \n"
                    + "                     INNER JOIN product p ON od.productId = p.productId \n"
                    + "                     INNER JOIN category c ON p.categoryId = c.categoryId\n"
                    + "				     where u.userName like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, '%' + userName + '%');
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OrderDetail o = new OrderDetail();
                o.setOrderDetailId(rs.getInt("orderDetailId"));

                Orders order = new Orders();
                order.setOrderId(rs.getInt("orderId"));
                order.setBookingDate(rs.getDate("bookingDate"));

                Users user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));

                order.setUserId(user);

                Product product = new Product();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setImagePath(rs.getString("imagePath"));
                product.setPrice(rs.getInt("price"));
                product.setOriginalPrice(rs.getInt("originalPrice"));
                product.setViewCount(rs.getInt("viewCount"));
                product.setDescription(rs.getString("description"));
                product.setStatus(rs.getInt("status"));

                Category category = new Category();
                category.setCategoryId(rs.getInt("categoryId"));
                category.setCategoryName(rs.getString("categoryName"));
                category.setStatus(rs.getInt("status"));

                product.setCategoryId(category);

                o.setOrderId(order);
                o.setProductId(product);
                o.setQuantity(rs.getInt("quantity"));
                o.setPrice(rs.getFloat("price"));

                orderDetails.add(o);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return orderDetails;
    }
}
