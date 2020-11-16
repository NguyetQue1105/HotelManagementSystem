/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quettn.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import quettn.dbutils.DBUtils;
import quettn.dtos.UserDTO;

/**
 *
 * @author ACER
 */
public class UserDAO {
    public UserDTO checkLogin (int userID, String userPassword) throws SQLException, NamingException, ClassNotFoundException{
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null){
                String SQL = "SELECT userID, userName, userPassword, roleID FROM tblUsers WHERE userID = ? "
                        + "and userPassword = ?";
                stm = conn.prepareStatement(SQL);
                stm.setInt(1, userID);
                stm.setString(2, userPassword);
                rs = stm.executeQuery();
                if(rs.next()){
                    String userName = rs.getString("userName");
                    int roleID = Integer.parseInt(rs.getString("roleID"));
                    result = new UserDTO(userID, userName, userPassword, roleID);
                }
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return result;
    }
    
    public boolean creatUser(UserDTO user) throws SQLException, NamingException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                String sql = "INSERT into tblUsers values(?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, user.getUserID());
                stm.setString(2, user.getUserName());
                stm.setString(3, user.getUserPassword());
                stm.setInt(4, user.getRoleID());
                result = stm.executeUpdate() > 0;
            }
        }finally{
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return result;
    }
    
    public int getUserID() throws SQLException, NamingException, ClassNotFoundException{
       int userID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                String sql = "SELECT MAX(userID) FROM tblUsers";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if(rs.next()){
                    userID = rs.getInt(1) + 1;
                }
            }
        }finally{
            if(rs!=null){
                rs.close();
            }if(stm!=null){
                stm.close();
            }if(conn!=null){
                conn.close();
            }
        }
        return userID; 
    }
}
