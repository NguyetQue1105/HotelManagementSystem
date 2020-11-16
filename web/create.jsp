<%-- 
    Document   : create
    Created on : Nov 9, 2020, 9:29:43 AM
    Author     : ACER
--%>

<%@page import="quettn.daos.UserDAO"%>
<%@page import="quettn.dtos.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <%
            UserDAO dao = new UserDAO();
            UserErrorDTO error = (UserErrorDTO) request.getAttribute("ERROR");
            if (error == null) {
                error = new UserErrorDTO("", "", "", "", "");
            }
        %>
        <form action="MainController">
            User ID:    <input type="text" name="txtUserID" value="<%= dao.getUserID() %>" readonly="true" /> </br>
            <%= error.getUserIDError()%></br>
            User Name:    <input type="text" name="txtUserName" value="" /></br>
            <%= error.getUserNameError()%></br>
            User Password:    <input type="password" name="txtUserPassword" value="" /></br>
            <%= error.getPasswordError()%></br>
            Confirm Password:    <input type="password" name="txtConfirmPassword" value="" /></br>
            <%= error.getConfirmError()%></br>
            Role ID:    <input type="text" name="txtRoleID" value="2" /></br>
            <%= error.getRoleIDError()%></br>
            <input type="submit" value="Create Account" name="btnAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
