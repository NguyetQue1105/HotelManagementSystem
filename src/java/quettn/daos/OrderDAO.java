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
import quettn.dtos.RoomDTO;

/**
 *
 * @author ACER
 */
public class OrderDAO {

    public int getOrderID() throws SQLException, NamingException, ClassNotFoundException {
        int orderID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select MAX( orderID) from tblOrder";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs != null) {
                    orderID = rs.getInt(1) + 1;
                }
            }
        }finally {
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
        return orderID;
    }

    public RoomDTO room(int RoomID) throws SQLException, NamingException, ClassNotFoundException {
        RoomDTO room = new RoomDTO();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                String sql = "SELECT roomID, status, price, description FROM tblRooms WHERE roomID = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, RoomID);
                rs = stm.executeQuery();
                if(rs!=null){
                    boolean status = rs.getBoolean("status");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    room = new RoomDTO(RoomID, status, price, description);
                }
            }
        }finally {
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
        return room;
    }
}
