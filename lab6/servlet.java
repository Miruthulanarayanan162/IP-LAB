/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

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
        Connection con;
        Statement st;

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try (PrintWriter out = response.getWriter()) {
           
        int mark=0;
           String n=request.getParameter("t1");
           String q1=request.getParameter("q1");
           String q2=request.getParameter("q2");
           String q3=request.getParameter("q3");
           String q4=request.getParameter("q4");
           String q5=request.getParameter("q5");
           String q6=request.getParameter("q6");
           if(q1.equals("True"))
               mark+=1;
           if(q2.equals("True"))
               mark+=1;
           if(q3.equals("interface"))
               mark+=1;
           if(q4.equals("False"))
               mark+=1;
           if(q5.equals("True"))
               mark+=1;
           if(q6.equals("False"))
               mark+=1;
           out.println("Name:"+n+" "+"Mark:"+mark);
           con=DriverManager.getConnection("jdbc:derby://localhost:1527/abc");
           st=con.createStatement();//to connect DB and statement
           String insert="insert into details values('"+n+"',"+mark+")";//double quote for strings
           st.executeUpdate(insert);//no change in query--executeQuery //for updating already created query executeUpdate
           out.println("Row Inserted");
           con.close();
                         
        }
        catch(Exception e)
        {
            
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
