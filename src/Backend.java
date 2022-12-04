import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmulh
 */
public class Backend {
    public Backend(){
        
    }
    
    private Connection getConnection() throws SQLException {
        final String ID = "jandalu1";
        final String PW = "COSC*jwc87";
        final String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/"+ID+"db";
        
        Connection con = DriverManager.getConnection (SERVER, ID, PW);
        Statement stmt = con.createStatement();
        stmt.executeQuery ("use jandalu1db;");
        
        return con;
    }
    
    //TODO Connect to Database and Confirm the given username and password are in the db.
    public boolean verifyLogin(String username, String password){        
        try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
        System.out.println (e);
        }
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery ("Select * from Admin where username ='" + username + "' and password ='" + password+ "'");
            while (rs.next ()) {
                return true;
            }
        }
        catch (SQLException e) {
            System.err.println (e);
        }
        return false;
    }
    
    //TODO returns a HashMap with varying values depending on the given type. I'd recommend Helper Functions.
    //Using the given ID
    //ID could be a name in the case of suppliers.
    //If type is "supplies" return a hashmap with {Name, Model, Device, Owner, Password}
    //If type is "suppliers" return a hashmap with {Name, Address, Phone, Email, itemsSupplied}
    //If type is "users" return a hashmap with {Name, Devices}.
    //If type is "maitenance" return a hashmap with {issue, cost, fixedBy, deviceSN, fixedDate}
    //If type does not equal any of the above return null.
    public HashMap<String,String> fetchPnlObjectItems(String ID, String type){
        
        HashMap<String,String> result = new HashMap();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;

            switch(type) {
                // TODO: Update tohandle PCs/Ipads and 
                case "supplies": 
                    rs = stmt.executeQuery ("SELECT PC.serial_number, model_name, barcode, status, password " +
                                            "FROM PC " +
                                            "JOIN Device using(serial_number) " +
                                            "WHERE serial_number =  '" + ID + "'");
                    while (rs.next()) {
                        result.put("Name", rs.getObject(1).toString());
                        result.put("Model", rs.getObject(2).toString());
                        result.put("Device", rs.getObject(3).toString());
                        result.put("Owner", rs.getObject(4).toString());
                        result.put("Password", rs.getObject(5).toString());
                    }
                    break;
                case "suppliers":
                    rs = stmt.executeQuery ("SELECT Name, address, phone, email, " +
                                            "(SELECT count(*) From Device WHERE supplier_name = Name) AS items_c " +
                                            "From Supplier" +
                                            "WHERE Name = '" + ID + "'");
                    while (rs.next()) {
                        result.put("Name", rs.getObject(1).toString());
                        result.put("Address", rs.getObject(2).toString());
                        result.put("Phone", rs.getObject(3).toString());
                        result.put("Email", rs.getObject(4).toString());
                        result.put("itemsSupplied", rs.getObject(5).toString());
                    }
                    break;
                case "users":
                    rs = stmt.executeQuery ("SELECT name, serial_number " +
                                            "FROM Employee e " +
                                            "LEFT OUTER JOIN Check_Out_Record using(Employee_ID) " +
                                            "WHERE e.Employee_ID = " + ID + "");
                    while (rs.next()) {
                        result.put("Name", rs.getObject(1).toString());
                        result.put("Devices", rs.getObject(2) == null ? "None" : rs.getObject(2).toString());
                    }
                    break;
                case "maintenance":
                    rs = stmt.executeQuery ("SELECT issue, cost, technician_name, serial_number, fixed_at "+
                                            "FROM Maintenance_Record "+
                                            "WHERE record_no= " + ID);
                    while (rs.next()) {
                        result.put("issue", rs.getObject(1).toString());
                        result.put("cost", rs.getObject(2).toString());
                        result.put("fixedBy", rs.getObject(3).toString());
                        result.put("deviceSN", rs.getObject(4).toString());
                        result.put("fixedDate", rs.getObject(5).toString());
                    }
                    break;
                default:
                   System.err.println ("Invalid Argument!"); 
            }
        }
        catch (SQLException e) {
            System.err.println (e);
        }
        return result;
    }
    
    //Does the same as fetchPnlObjectItems but uses the given name instead of ID.
    public HashMap<String,String> fetchPnlObjectItemsByName(String name, String type){
        return fetchPnlObjectItems(getEmployeeIDByName(name), type);
    }
    //returns the employee ID of the given name.
    public String getEmployeeIDByName(String name){
        return null;
    }
    //Returns the accessLevel given a user name.
    public int getAccessLevelByUsername(String username){
        return 0;
    }
    //Returns the employees Name By ID
    public String getEmployeeNameByID(String ID){
        return null;
    }
    //Returns the Employees SSN by ID
    public String getEmployeeSSNByID(String ID){
        return null;
    }
    //Returns the devices owned by the employee with the given ID
    public String[] getEmployeeDevicesByID(String ID){
        return new String[0];
    }
    //Returns the access level of the employee with the given ID
    public int getAccessLevelByID(String ID){
        return 0;
    }
    //Returns the Max Access Level in the database or this number can be arbitrarily set.
    public int getMaxAccessLevel(){
        return 0;
    }
    //Returns the location of the employee given the ID
    public String getEmployeeLocationByID(String ID){
        return null;
    }
    //Returns the employees working hours given the ID
    public int getEmployeeWorkingHoursByID(String ID){
        return 0;
    }
    //Changes the access Level of an employee given an ID and the new access level.
    //If ButtonText is "0" then remove that employee from the database.
    public void setEmployeeAccessLevelByID(String ID, int accessLevel){
    }
    //Updates the employees SSN by the given ID
    public void updateEmployeeSSNByID(String ID, String SSN){
    }
    //Updates the employees Location by the given ID
    public void updateEmployeeLocationByID(String ID, String location){
    }
    //Updates the employees working hours by the given ID
    public void updateEmployeeWorkingHoursByID(String ID, int workingHours){
    }
    //Creates a new employee given the parameters
    //Employee ID should be randomly generated with specific parameters.
    public void createEmployee(String name, String SSN, String username, String password, String location, int workingHours, int accessLevel){
    }
    //Updates the device either checking it in or out.
    public void checkDevice(String ID,String empID, String time, String condition, boolean checkedIn){
    }
    //Returns information about the device. This should be a hashmap with the following values.
    //{deviceType, warrantyExpiration, barcode, model, SN, dateAcquired, cost, condition, knownIssues, status, password, hasKeyboard, hasMouse, weight}.
    //For has keyboard and has mouse should return "Yes" or "No".
    public HashMap<String,String> getDeviceInformation(String ID){
        return null;
    }
    //Updates the device information given the ID and the hashmap of values.
    //HashMap values are {deviceType, warrantyExpiration, barcode, model, SN, dateAcquired, cost, condition, knownIssues, status, password, hasKeyboard, hasMouse, weight}.
    public void updateDeviceInformation(String ID, HashMap<String,String> deviceInfo){
    }
    //Returns a HashMap of Supplier information given the name.
    //{address, phone, devicesSupplied, email}
    //devicesSupplied should be a comma separated list of devices.
    public HashMap<String,String> getSupplierInformation(String name){
        return null;
    }
    //Removes a supplier from the Database given the name.
    public void deleteSupplier(String name){
    }
    
}
