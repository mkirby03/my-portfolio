package edu.jsu.mcis.employeedb.dao;

import edu.jsu.mcis.employeedb.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.github.cliftonlabs.json_simple.*;
import java.util.Objects;

public class EmployeeDAO {
    
    private final List<Employee> employees;
    private int employeeid;
    
    private static final String FILENAME = "data.json";

    EmployeeDAO() {
        this.employees = new ArrayList<>();
        this.employeeid = 1;
        this.init();
    }
    
    private void init() {
        
        BufferedReader reader = null;
        InputStream file = null;
        
        try {
            
            file = this.getClass().getResourceAsStream("resources" + File.separator + FILENAME);
            reader = new BufferedReader(new InputStreamReader(file));
            
            StringBuilder data = new StringBuilder();
            
            String line;
            
            while((line = reader.readLine()) != null) {
                data.append(line);
            }
            
            JsonArray json = Jsoner.deserialize(data.toString(), new JsonArray());
            
            for (int i = 0; i < json.size(); ++i) {
                JsonObject record = (JsonObject)json.get(i);
                Employee employee = new Employee((employeeid++), record);
                employees.add(employee);
            }
            
        }
        catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        finally {
            try {
                if (reader != null) { reader.close(); }
                if (file != null) { file.close(); }
            }
            catch (Exception e) { throw new DAOException(e.getMessage()); }
        }
        
    }
    
    public JsonObject create(JsonObject parameters) {
        
        // create a new employee record from the collection of parameters given by the client
        
        JsonObject json = new JsonObject();
        
        /* INSERT YOUR CODE HERE */
        boolean success = false;
        Employee newEmployeeRecord = new Employee(employeeid++, parameters);
        employees.add(newEmployeeRecord);
        json.put("data", newEmployeeRecord.getProperties());
        if (parameters != null) {
            success = true;
            json.put("success", success);
            json.put("message", "Employee record has been created successfully!");
        }
        return json;
        
    }
    
    public JsonObject update(JsonObject parameters) {
        
        // update an existing employee record from the collection of parameters given by the client
        
        JsonObject json = new JsonObject();
        
        /* INSERT YOUR CODE HERE */
        int id = Integer.parseInt(parameters.get("id").toString());
        boolean success = false;
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                Employee update = new Employee(id, parameters);
                employees.set(employees.indexOf(employee), update);
                json.put("data", update.getProperties());
                success = true;
                json.put("success", success);
                json.put("message", "Employee record has been updated successfully!");
            }
        }
        return json;   
    }
    
    public JsonObject delete(JsonObject parameters) {
        
        // delete the employee record specified by the client
        
        JsonObject json = new JsonObject();
        
        /* INSERT YOUR CODE HERE */
        int id = Integer.parseInt(parameters.get("id").toString());
        boolean success = false;
        
        Employee deleted = null;
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                deleted = employee;
                break;
            }
        }
        if (deleted != null){
            employees.remove(deleted);
            success = true;
            json.put("data", deleted.getProperties());
            json.put("success", success);
            json.put("message", "Employee record has been deleted successfully!");
        }
        else {
            success = false;
            json.put("success", success);
            json.put("message", "Employee record has not been deleted.");
        }
        
        return json;
    }
    
    public String find(Integer id) {
        
        // return the individual employee record specified by the client in JSON format
        
        JsonObject json = new JsonObject();
        
        /* INSERT YOUR CODE HERE */
        boolean success = false;
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                json.put("data", employee.getProperties());
                success = true;
                json.put("success", success);
                json.put("message", "Employee record has been fetched successfully!");
            }
        }
        return Jsoner.serialize(json);
        
    }
    
    public String list() {
        
        // return all employee records (in their original order) in JSON format
        
        JsonObject json = new JsonObject();
        
        /* INSERT YOUR CODE HERE */
        JsonArray jsonArray = new JsonArray();
        boolean success = true;
        for (Employee employee : employees) {
            jsonArray.add(employee.getProperties());
        }
        json.put("data", jsonArray);
        json.put("success", success);
        json.put("message", "All employee records have been fetched successfully!");
        return Jsoner.serialize(json);   
        
    } 
}