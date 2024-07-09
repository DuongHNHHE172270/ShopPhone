/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Category;
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
public class DBUsers extends DBContext {

    public Users checkAccount(String userName, String pass) {
        try {
            String sql = "select * from users where userName = ? and password = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setAvatar(rs.getString("avatar"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));

                return user;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public int getNumberPage() {
        String sql = "select COUNT(*) from users ";
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

    public int getTotalUser() {
        String sql = "select COUNT(*) from users ";
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

    public ArrayList<Users> getPage(int index) {
        String sql = "SELECT * FROM users ORDER BY userId OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
        ArrayList<Users> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setAvatar(rs.getString("avatar"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));

                users.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    public void deleteUser(int userId) {
        try {
            String sql = "DELETE FROM users WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Users getUserId(int uid) {
        try {
            String sql = "select * from users where userId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, uid);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setAvatar(rs.getString("avatar"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));

                return user;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void updateUserRole(int role, int uId) {
        try {
            String sql = "UPDATE users SET role = ? WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, role);
            statement.setInt(2, uId);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void updateProfileUser(String fullName, String phone, String address, String uId) {
        try {
            String sql = "UPDATE users SET fullName = ?, phone = ?, address = ? WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fullName);
            statement.setString(2, phone);
            statement.setString(3, address);
            statement.setString(4, uId);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int getNumberPageSearch(String userName) {
        String sql = "select COUNT(*) from users where userName like ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + userName + "%");
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

    public ArrayList<Users> getSearchUserName(String uName, int index) {
        String sql = "SELECT * FROM users where userName like ? ORDER BY userId OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY";
        ArrayList<Users> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + uName + "%");
            statement.setInt(2, (index - 1) * 9);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setAvatar(rs.getString("avatar"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));

                users.add(user);
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return users;
    }

    public int getTotalUserSearch(String uName) {
        String sql = "SELECT COUNT(*) FROM users WHERE userName LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + uName + "%");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int total = rs.getInt(1);
                return total;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public void register(String userName, String pass) {
        try {
            String sql = "insert into users (userName, password,fullName,avatar,phone,address,role) values (?, ?, null, null, null, null, 1)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, pass);
            statement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean exisUser(String userName) {
        try {
            String sql = "select * from users where userName = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
