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
            
            if (parameter != null) {
                int id = Integer.parseInt(parameter);
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
            
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            String salary = request.getParameter("salary");
            
            JsonObject parameters = new JsonObject();
            
            if (name != null) {
                parameters.put("name", name);
            }
            if (age != null) {
                parameters.put("age", age);
            }
            if (salary != null) {
                parameters.put("salary", salary);
            }
            
            JsonObject newRecord = dao.create(parameters);
            out.println( Jsoner.serialize(newRecord) );
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

        /* INSERT YOUR CODE HERE */
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
        
        BufferedReader br = null;
        
        response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            EmployeeDAO dao = daoFactory.getEmployeeDAO();
            
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String p = URLDecoder.decode(br.readLine().trim(), Charset.defaultCharset());
            
            HashMap<String, String> parameters = new HashMap<>();
            String[] pairs = p.trim().split("&");
            for (int i = 0; i < pairs.length; ++i) {
                String[] pair = pairs[i].split("=");
                parameters.put(pair[0], pair[1]);
            }
            
            String name = parameters.get("name");
            int id = Integer.parseInt(parameters.get("id"));
            int age = Integer.parseInt(parameters.get("age"));
            int salary = Integer.parseInt(parameters.get("salary"));
            
            JsonObject params = new JsonObject();
            params.put("id", id);
            params.put("age", age);
            params.put("salary", salary);
            if (name != null) {
                params.put("name", name);
            }
            
            JsonObject updateEmployee = dao.update(params);
            out.println( Jsoner.serialize(updateEmployee) );
        }
        catch (Exception e) { 
            e.printStackTrace(); }
        finally {
            if (br != null) {
                try { br.close(); } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {

        /* INSERT YOUR CODE HERE */
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
        
        BufferedReader br = null;
        
        response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            EmployeeDAO dao = daoFactory.getEmployeeDAO();
            
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String p = URLDecoder.decode(br.readLine().trim(), Charset.defaultCharset());
            
            HashMap<String, String> parameters = new HashMap<>();
            String[] pairs = p.trim().split("&");
            for (int i = 0; i < pairs.length; ++i) {
                String[] pair = pairs[i].split("=");
                parameters.put(pair[0], pair[1]);
            }
            
            String name = parameters.get("name");
            String id = parameters.get("id");
            String age = parameters.get("age");
            String salary = parameters.get("salary");
            
            JsonObject params = new JsonObject();
            params.put("salary", salary);
            if (name != null) {
                params.put("name", name);
            }
            if (id != null) {
                params.put("id", id);
            }
            if (age != null) {
                params.put("age", age);
            }
            if (salary != null) {
                params.put("salary", salary);
            }
            
            JsonObject deleteEmployee = dao.delete(params);
            out.println( Jsoner.serialize(deleteEmployee) );
        }
        catch (Exception e) { 
            e.printStackTrace(); }
        finally {
            if (br != null) {
                try { br.close(); } catch (Exception e) { e.printStackTrace(); }
            }
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Employee Servlet";
    }

}