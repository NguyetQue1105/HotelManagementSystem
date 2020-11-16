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
public class UserErrorDTO {
    private String userIDError;
    private String userNameError;
    private String passwordError;
    private String confirmError;
    private String roleIDError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String userNameError, String passwordError, String confirmError, String roleIDError) {
        this.userIDError = userIDError;
        this.userNameError = userNameError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.roleIDError = roleIDError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    
}
