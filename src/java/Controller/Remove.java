/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Student;
import Model.StudentTable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aomms
 */
public class Remove extends HttpServlet {

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
        
        try ( PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<String> idlog = new ArrayList<String>();
            String id = request.getParameter("id");
            
            if(!idlog.contains(id)){ 
                idlog.add(id);
                HttpSession session = request.getSession();
                synchronized(getServletContext()) {
                //synchronized(session) {
                getServletContext().setAttribute("idlog", idlog);
           
                //Random rand = new Random();
                //int num = rand.nextInt(10)+1;
                //Thread.sleep(10*1000);
                //idlog.remove(id);

                Student std = new Student();
                std.setId(request.getParameter("id"));
                std.setName(request.getParameter("name"));
                std.setGpa(Double.parseDouble(request.getParameter("gpa")));
        
                StudentTable.removeStudent(std);  
                
                idlog.remove(id);
                getServletContext().setAttribute("idlog", idlog);
                out.println("Remove Success");
                }
            }
            else{
                //out.println("This Student is not Available ! ");
                //getServletContext().setAttribute("idlog", idlog);
                request.getRequestDispatcher("notavailable.jsp").forward(request, response);
            }        
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
