/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Cart;
import Model.Item;
import Model.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBCart extends DBContext {

    public void addOrder(Users u, Cart cart) {
        LocalDate currDate = java.time.LocalDate.now();
        String date = currDate.toString();
        try {
            String sql = "insert into orders values(?, ? ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, u.getUserId());
            statement.setDouble(2, cart.getTotalMoney());
            statement.setString(3, date);
            statement.executeUpdate();

            String sql1 = "select top 1 orderId from orders order by orderId desc";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            ResultSet rs = statement1.executeQuery();
            int orderId = 0;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            if (orderId != 0) {
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into orderDetail (orderId, productId, quantity, price) values (?, ?, ?, ?)";
                    PreparedStatement statement2 = connection.prepareStatement(sql2);
                    statement2.setInt(1, orderId);
                    statement2.setInt(2, i.getProduct().getProductId());
                    statement2.setInt(3, i.getQuantity());
                    statement2.setDouble(4, i.getPrice());
                    statement2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
