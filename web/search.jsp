<%-- 
    Document   : search
    Created on : Nov 4, 2020, 7:26:01 AM
    Author     : ACER
--%>

<%@page import="quettn.dtos.RoomDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.LOGIN_USER} to my hotel</h1>
        <form action="MainController">
            Checkin Date: <input type="text" name="txtcheckin" value="" />
            Checkout Date: <input type="text" name="txtcheckout" value="" /> <br/>
            <%
                if(request.getAttribute("EMPTYDATE")!=null){%>
                <%=
                    request.getAttribute("EMPTYDATE")%>
                    <%
                }
            %>
            <input type="submit" value="Search" name="btnAction" />
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
                    <th>Price</th>
                    <th>Description</th>
                    <th>Add</th>
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
                    <td><%= room.getPrice()%></td>
                    <td><%= room.getDescription()%></td>
                    <td>
                        <input type="submit" value="Add" name="btnAction" />
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
</body>
</html>
