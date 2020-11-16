<%-- 
    Document   : new
    Created on : Nov 9, 2020, 7:20:54 AM
    Author     : ACER
--%>

<%@page import="quettn.daos.RoomDAO"%>
<%@page import="quettn.dtos.RoomErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Page</title>
    </head>
    <body>
        <%
            RoomDAO dao = new RoomDAO();
            int roomID = dao.getRoomID();
            RoomErrorDTO error = (RoomErrorDTO) request.getAttribute("ERROR");
            if(error==null){
                error = new RoomErrorDTO("", "", "", "");
            }
        %>
        <form action="MainController" method="POST">
            Room ID:    <input type="text" name="txtRoomID" value="<%= dao.getRoomID() %>" readonly="true" />
            <%= error.getRoomIDError() %></br>
            Status:    <input type="text" name="txtStatus" value="true" readonly="true"/>
            <%= error.isStatusError() %></br>
            Price:    <input type="text" name="txtPrice" value="0"/>
            <%= error.getPriceError() %></br>
            Description:    <input type="text" name="txtDescription" value="" />
            <%= error.getDescriptionError() %></br>
            <input type="submit" value="New Room" name="btnAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
