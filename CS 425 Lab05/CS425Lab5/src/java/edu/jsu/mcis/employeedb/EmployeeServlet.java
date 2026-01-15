package edu.jsu.mcis.employeedb;

import edu.jsu.mcis.employeedb.dao.DAOException;
import edu.jsu.mcis.employeedb.dao.DAOFactory;
import edu.jsu.mcis.employeedb.dao.EmployeeDAO;
import java.io.PrintWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.github.cliftonlabs.json_simple.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;

public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        // Acquire DAOFactory
        
        DAOFactory daoFactory;

        ServletContext context = request.getServletContext();

        if (context.getAttribute("daoFactory") == null) {
            System.err.println("*** Creating new DAOFactory ...");
            daoFactory = new DAOFactory();
            context.setAttribute("daoFactory", daoFactory);
        }
        else {
            daoFactory = (DAOFactory)context.getAttribute("daoFactory");
        }
        
        response.setContentType("application/json; charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            
            EmployeeDAO dao = daoFactory.getEmployeeDAO();
            
            /* INSERT YOUR CODE HERE */
            String parameter = request.getParameter("id");
            
            if (parameter != null ) {
                Integer id = Integer.valueOf(parameter);
                String employeeRecord = dao.find(id);
                if (employeeRecord != null) {
                    out.println(employeeRecord);
                }
            }
            else {
                String employeeRecords = dao.list();
                out.println(employeeRecords);
            }
            
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        /* INSERT YOUR CODE HERE */
        
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        /* INSERT YOUR CODE HERE */
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

        /* INSERT YOUR CODE HERE */
        
    }

    @Override
    public String getServletInfo() {
        return "Employee Servlet";
    }

}