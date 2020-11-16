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
public class UserDTO {
    private int userID;
    private String userName;
    private String userPassword;
    private int roleID;

    public UserDTO() {
    }

    public UserDTO(int userID, String userName, String userPassword, int roleID) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.roleID = roleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
