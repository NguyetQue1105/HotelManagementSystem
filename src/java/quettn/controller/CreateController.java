/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quettn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quettn.daos.UserDAO;
import quettn.dtos.UserDTO;
import quettn.dtos.UserErrorDTO;

/**
 *
 * @author ACER
 */
public class CreateController extends HttpServlet {

    private final static String ERROR = "create.jsp";
    private final static String SUCCESS = "login.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserErrorDTO error = new UserErrorDTO("", "", "", "", "");
        try {
            int userID = Integer.parseInt(request.getParameter("txtUserID"));
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtUserPassword");
            String confirm = request.getParameter("txtConfirmPassword");
            int roleID = Integer.parseInt(request.getParameter("txtRoleID"));
            UserDAO dao = new UserDAO();
            boolean check = true;
            if (userName.isEmpty()) {
                check = false;
                error.setUserNameError("Username is empty");
            }
            if (password.isEmpty()) {
                check = false;
                error.setUserNameError("Password is empty");
            }
            if (!password.equals(confirm)) {
                check = false;
                error.setConfirmError("Password confirm was wrong");
            }
            if (check) {
                UserDTO user = new UserDTO(userID, userName, password, roleID);
                boolean result = dao.creatUser(user);
                if (result) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR", error);
            }
        } catch (Exception ex) {
            log("Error at Create Controller: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
