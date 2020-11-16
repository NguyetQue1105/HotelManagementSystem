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
public class RoomErrorDTO {
    private String roomIDError;
    private String statusError;
    private String priceError;
    private String descriptionError;

    public RoomErrorDTO() {
    }

    public RoomErrorDTO(String roomIDError, String statusError, String priceError, String descriptionError) {
        this.roomIDError = roomIDError;
        this.statusError = statusError;
        this.priceError = priceError;
        this.descriptionError = descriptionError;
    }

    public String getRoomIDError() {
        return roomIDError;
    }

    public void setRoomIDError(String roomIDError) {
        this.roomIDError = roomIDError;
    }

    public String isStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }
    
}
