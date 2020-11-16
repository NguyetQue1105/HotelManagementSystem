/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quettn.dtos;

/**
 *
 * @author ACER
 */
public class RoomDTO {
    private int roomID;
    private boolean status;
    private float price;
    private String description;

    public RoomDTO() {
    }

    public RoomDTO(int roomID, boolean status, float price, String description) {
        this.roomID = roomID;
        this.status = status;
        this.price = price;
        this.description = description;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
