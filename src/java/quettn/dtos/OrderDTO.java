/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quettn.dtos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class OrderDTO {

    private int orderID;
    private int userID;
    private LocalDate date;
    private Date checkinDate;
    private Date checkoutDate;
    private int noRoom;
    private float totalPrice;
    private List<RoomDTO> order;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, int userID, LocalDate date, Date checkinDate, Date checkoutDate, List<RoomDTO> order) {
        this.orderID = orderID;
        this.userID = userID;
        this.date = date;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.order = order;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getNoRoom() {
        return noRoom;
    }

    public void setNoRoom(int noRoom) {
        this.noRoom = noRoom;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<RoomDTO> getOrder() {
        return order;
    }

    public void setOrder(List<RoomDTO> order) {
        this.order = order;
    }
    public void add(RoomDTO room){
        if(this.order == null){
            this.order = new ArrayList<>();
        }
        order.add(room);
    }
    public void delete(String id){
        if(this.order==null){
            return;
        }
        if(this.order.contains(id)){
            order.remove(id);
        }
    }
}
