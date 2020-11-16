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
import quettn.daos.RoomDAO;
import quettn.dtos.RoomDTO;
import quettn.dtos.RoomErrorDTO;

/**
 *
 * @author ACER
 */
public class NewController extends HttpServlet {
    private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "SearchController";

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
        String url = ERROR;
        RoomErrorDTO error = new RoomErrorDTO("", "", "", "");
        try {
            boolean check = true;
            int roomID = Integer.parseInt(request.getParameter("txtRoomID"));
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            String description = request.getParameter("txtDescription");
            boolean status = Boolean.parseBoolean(request.getParameter("txtStatus"));
            if(price==0){
                check = false;
                error.setPriceError("Room price is invalid");
            }
            RoomDAO dao = new RoomDAO();
            RoomDTO room = new RoomDTO(roomID, status, price, description);
            if(check){
                dao.NewRoom(room);
                url = SUCCESS;
            }else{
                request.setAttribute("ERROR", error);
            }
            
        } catch (Exception e) {
            log("Error at New Controller: " + e.getMessage());
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
