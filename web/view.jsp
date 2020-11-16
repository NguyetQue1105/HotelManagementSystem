<%-- 
    Document   : view
    Created on : Nov 8, 2020, 10:03:48 PM
    Author     : ACER
--%>

<%@page import="quettn.dtos.RoomDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <body>
        <h1>Welcome ${sessionScope.LOGIN_USER} to my hotel</h1>
        <form action="MainController">
            <a href="MainController?btnAction=Search">View</a>
        </form>
        <%
            List<RoomDTO> list = (List<RoomDTO>) request.getAttribute("LIST");
            int count = 1;
            if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>Room ID</th>
                    <th>Status</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (RoomDTO room : list) {
                %>
            <form action="MainController">
                <tr>
                    <td><%= count++%></td>
                    <td>
                        <%= room.getRoomID()%>
                    </td>
                    <td>
                        <input type="text" name="txtStatus" value="<%= room.isStatus() %>" />
                    </td>
                    <td>
                        <input type="text" name="txtPrice" value="<%= room.getPrice()%>" />
                    </td>
                    <td>
                    <input type="text" name="txtDescription" value="<%= room.getDescription()%>" />
                    </td>
                    <td>
                        <a href="MainController?btnAction=Delete&txtRoomID=<%= room.getRoomID() %>">Delete</a>
                    </td>
                    <td>
                        <input type="hidden" name="txtRoomID" value="<%= room.getRoomID()%>" />
                        <input type="submit" name="btnAction" value="Update" />
                    </td>
                </tr>
            </form>
            <%
                }
            %>
<%
                }
            %>
        </tbody>
    </table>
        <a href="MainController?btnAction=Logout">Logout</a>
        <a href="MainController?btnAction=New">Add New Room</a>
</body>
    </body>
</html>
