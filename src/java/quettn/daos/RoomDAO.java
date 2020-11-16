/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quettn.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import quettn.dbutils.DBUtils;
import quettn.dtos.RoomDTO;

/**
 *
 * @author ACER
 */
public class RoomDAO {

    public List<RoomDTO> getListRoom(String checkin, String checkout) throws SQLException, NamingException, ClassNotFoundException, ParseException {
        List<RoomDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {

            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT roomID, status, price, description FROM tblRooms where status='True' and roomID not in "
                        + "(select roomID from tblOrderDetail where orderID in "
                        + "( select orderID from tblOrder where checkin >= ? and checkout <= ? ))";
                stm = conn.prepareStatement(sql);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date parse;
                parse = formatter.parse(checkin);
                Date checkinDate = new Date(parse.getTime());
                parse = formatter.parse(checkout);
                Date checkoutDate = new Date(parse.getTime());
                stm.setDate(1, checkinDate);
                stm.setDate(2, checkoutDate);
                rs = stm.executeQuery();
                while(rs.next()){
                    int roomID = Integer.parseInt(rs.getString("roomID"));
                    boolean status = Boolean.parseBoolean(rs.getString("status"));
                    float price = Float.parseFloat(rs.getString("price"));
                    String description = rs.getString("description");
                    if(list==null){
                        list = new ArrayList<>();
                    }
                    list.add(new RoomDTO(roomID, status, price, description));
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
        return list;
    }
    public List<RoomDTO> getRoom() throws SQLException, NamingException, ClassNotFoundException {
        List<RoomDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT roomID, status, price, description FROM tblRooms";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    int roomID = Integer.parseInt(rs.getString("roomID"));
                    boolean status = rs.getBoolean("status");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    if(list==null){
                        list = new ArrayList<>();
                    }
                    list.add(new RoomDTO(roomID, status, price, description));
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
        return list;
    }
    
    public boolean DeleteRoom(int RoomID) throws SQLException, NamingException, ClassNotFoundException{
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                String sql = "DELETE from tblRooms WHERE roomID=?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, RoomID);
                result = stm.executeUpdate() > 0;
            }
        }finally {
            if (stm != null){
                stm.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return result;
    }
    public boolean UpdateRoom(RoomDTO room) throws SQLException, NamingException, ClassNotFoundException{
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                String sql = "UPDATE tblRooms set status=?, price=?, description=? WHERE roomID=?";
                stm = conn.prepareStatement(sql);
                stm.setBoolean(1, room.isStatus());
                stm.setFloat(2, room.getPrice());
                stm.setString(3, room.getDescription());
                stm.setInt(4, room.getRoomID());
                result = stm.executeUpdate() > 0;
            }
        }finally {
            if (stm != null){
                stm.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return result;
    }
    public boolean NewRoom(RoomDTO room) throws SQLException, NamingException,ClassNotFoundException{
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                String sql = "INSERT INTO tblRooms values(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, room.getRoomID());
                stm.setBoolean(2, room.isStatus());
                stm.setFloat(3, room.getPrice());
                stm.setString(4, room.getDescription());
                result = stm.executeUpdate() > 0;
            }
        }finally {
            if (stm != null){
                stm.close();
            }
            if (conn != null){
                conn.close();
            }
        }
        return result;
    }
    public int getRoomID() throws SQLException, NamingException, ClassNotFoundException{
        int roomID = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                String sql = "SELECT MAX(roomID) FROM tblRooms";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if(rs.next()){
                    roomID = rs.getInt(1) + 1;
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
        return roomID;
    }
}
