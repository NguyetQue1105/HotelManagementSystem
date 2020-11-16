/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quettn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class MainController extends HttpServlet {
    private final String LOGIN = "LoginController";
    private final String SEARCH = "SearchController";
    private final String ADD = "AddController";
    private final String LOGINGMAIL = "LoginGmailController";
    private final String LOGOUT = "LogoutController";
    private final String UPDATEROOM = "UpdateController";
    private final String DELETEROOM = "DeleteController";
    private final String NEW = "new.jsp";
    private final String NEWROOM = "NewController";
    private final String CREATE = "create.jsp";
    private final String CREATEACCOUNT = "CreateController";

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN;
        try {
            String action = request.getParameter("btnAction");
            if(action.equals("Login")){
                url = LOGIN;
            }else if(action.equals("Search")){
                url = SEARCH;
            }else if(action.equals("Add")){
                url = ADD;
            }else if(action.equals("LoginGmail")){
                url = LOGINGMAIL;
            }else if(action.equals("Logout")){
                url = LOGOUT;
            }else if(action.equals("Delete")){
                url = DELETEROOM;
            }else if(action.equals("Update")){
                url = UPDATEROOM;
            }else if(action.equals("New")){
                url = NEW;
            }else if(action.equals("New Room")){
                url = NEWROOM;
            }else if(action.equals("Create")){
                url = CREATE;
            }else if(action.equals("Create Account")){
                url = CREATEACCOUNT;
            }
        } catch (Exception e) {
            log("Error at Main Controler: " + e.toString());
        }finally{
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
        processRequest(request, response);
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
        processRequest(request, response);
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
