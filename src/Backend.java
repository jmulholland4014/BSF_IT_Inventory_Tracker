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
    public ResultSet getAdminByCredentials(String username, String password){        
        try{
            Class.forName ("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
        System.out.println (e);
        }
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            return stmt.executeQuery ("Select Admin_ID, access_level from Admin where username ='" + username + "' and password ='" + password+ "'");
        }
        catch (SQLException e) {
            System.err.println (e);
        }
        return null;
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
                    rs = stmt.executeQuery ("SELECT model_name, `condition`, PC.username AS pc_username, PC.password AS pc_password, " +
                                            "IPad.passcode, Chromebook.username AS c_username, Chromebook.password AS c_password, status " +
                                            "FROM Device d " +
                                            "LEFT OUTER JOIN PC using(serial_number) " +
                                            "LEFT OUTER JOIN IPad using(serial_number) " +
                                            "LEFT OUTER JOIN Chromebook using(serial_number) " +
                                            "WHERE d.serial_number = '" + ID + "'");
                    while (rs.next()) {
                        result.put("Model", rs.getObject(1).toString());
                        result.put("Condition", rs.getObject(2).toString());
                        result.put("Status", rs.getObject(8).toString());
                        
                        String device_type, access;
                        if (rs.getObject(3) != null) {
                            device_type = "PC";
                            access = rs.getObject(3).toString() + " - " + rs.getObject(4).toString();
                        }
                        else if (rs.getObject(5) != null) {
                            device_type = "IPad";
                            access = rs.getObject(5).toString();
                        } else {
                            device_type = "Chromebook";
                            access = rs.getObject(6).toString() + " - " + rs.getObject(7).toString();
                        }
                        
                        result.put("Type", device_type);
                        result.put("Access", access);
                    }
                    break;
                case "suppliers":
                    rs = stmt.executeQuery ("SELECT Name, address, phone, email, " +
                                            "(SELECT count(*) From Device WHERE supplier_name = Name) AS items_c " +
                                            "From Supplier " +
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
                    rs = stmt.executeQuery ("SELECT issue, cost, technician_name, serial_number, fixed_at, location "+
                                            "FROM Maintenance_Record "+
                                            "WHERE record_no= " + ID);
                    while (rs.next()) {
                        result.put("issue", rs.getObject(1).toString());
                        result.put("cost", rs.getObject(2).toString());
                        result.put("fixedBy", rs.getObject(3).toString());
                        result.put("deviceSN", rs.getObject(4).toString());
                        result.put("fixedDate", rs.getObject(5).toString());
                        result.put("location", rs.getObject(6).toString());
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
    public HashMap<String,String> getEmployeeByID(String ID){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            HashMap<String,String> result = new HashMap();
            rs = stmt.executeQuery ("SELECT * FROM Employee WHERE Employee_ID = '" + ID + "'");
            while (rs.next()) {
                result.put("Name", rs.getObject(3).toString());
                result.put("SSN", rs.getObject(1).toString());
                result.put("Address", rs.getObject(4).toString());
                result.put("Location", rs.getObject(7).toString());
                result.put("ID", rs.getObject(2).toString());
                result.put("Email", rs.getObject(5).toString());
                result.put("Phone", rs.getObject(6).toString());
            }
            rs = stmt.executeQuery("SELECT * from Admin WHERE Admin_ID = '" + ID +"'");
            while(rs.next()){
                result.put("Access", rs.getObject(4).toString());
                result.put("User", rs.getObject(2).toString());
                result.put("Pass", rs.getObject(3).toString());
            }

            if(result.get("Access") == null){
                result.put("Access", "User");
            }
            return result;
        }
        catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }

    public void setEmployeeByID(String ID, String SSN, String location, String address, String email, String phone, int accessLevel, String user, String pass){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT Admin_ID FROM Admin WHERE Admin_ID = '" + ID +"'");
            if(rs.next()){
                if(accessLevel == 1){
                    stmt.executeUpdate("DELETE FROM Admin WHERE Admin_ID = '" + ID + "'");
                }
            }
            else{
                if(accessLevel ==2){
                    stmt.executeUpdate("INSERT INTO Admin (Admin_ID, access_level,username, password) VALUES ('" + ID + "', 'Admin', '" + user + "', '" + pass + "')");
                }
                if(accessLevel == 0){
                    stmt.executeUpdate("DELETE FROM Employee WHERE Employee_ID = " + ID);
                }
            }
            stmt.executeUpdate("UPDATE Employee SET SSN = " + SSN + ", location_address = '" + location + "', address = '" + address + "', email = '" + email + "', phone = '" + phone + "' WHERE Employee_ID = '" + ID + "'");
            
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }
    //Creates a new employee given the parameters
    //Employee ID should be randomly generated with specific parameters.
    public void createEmployee(String name, String SSN, String username, String password, 
                               String location, String accessLevel, String email, String phone, 
                               String address){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            
            // Create Employee Entry
            stmt.executeUpdate("INSERT INTO Employee (SSN, name, address, email, phone, location_address) " +
                               "VALUES ('" + SSN + "','"+ name +"','"+ address +"','"+ email +"','"+ phone +"','"+ location +"')");
            
            // Create Admin entery if necessary
            if (!accessLevel.equals("Employee")){
                
                // Retrieve employee id
                ResultSet rs = stmt.executeQuery ("SELECT Employee_ID " + 
                                                  "FROM Employee " +
                                                  "WHERE SSN = '" + SSN + "'" );
                rs.next();
                stmt.executeUpdate("INSERT INTO Admin (Admin_ID, username, password, access_level) " +
                                   "VALUES ('" + rs.getObject(1).toString() + "','"+ username +"','"+ password +"','"+ accessLevel +"')");
            }
        }
        catch (SQLException e) {
            System.err.println (e);
        }
    }
    
    public void createDevice(String type, String serial_number, String supplier, String purchase_date,
                             String barcode, String brand, String condition,
                             String color, double cost, String issues, String graphic_card,
                             String memory, String model, String processor, double screen_size,
                             String status,
                             String warranty, String location, double weight, String extraField1,
                             String extraField2, String extraField3,
                             boolean has_keyboard,
                             boolean has_mouse,
                             boolean has_headphones,
                             boolean has_stylus){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            
            
            // Create Device Entry
            stmt.executeUpdate("INSERT INTO Device " +
                               "(serial_number, supplier_name, puchased_date, barcode," +
                               "brand, `condition`, color, cost, issue, graphic_card," +
                               "`memory`, model_name, operating_system, processor, " +
                               "screen_size, `status`, warranty, location_address, weight) " +
                               "VALUES ('"+ serial_number+"', '" + supplier +"', '" + purchase_date + "'," +
                                       "'"+ barcode+"', '" + brand +"', '" + condition + "'," +
                                       "'"+ color +"', " + cost +", '" + issues + "'," +
                                       "'"+ graphic_card +"', '" + memory +"', '" + model + "'," +
                                       "'', '" + processor +"', " + screen_size + "," +
                                       "'"+ status+"', '" + warranty +"', '" + location + "'," + weight + ")");
//            System.out.println(query);
            
            // Create PC/ Ipad / Chromebook entry
            switch(type)
            {
                case "ipad":
                    stmt.executeUpdate("INSERT INTO IPad (serial_number, model_number, passcode, software_version) " +
                                       "VALUES ('" + serial_number + "','"+ extraField3 +"','"+ extraField1 +"','"+ extraField2 +"')");
                    break;
                case "pc":
                    stmt.executeUpdate("INSERT INTO PC (serial_number, username, password) " +
                                       "VALUES ('" + serial_number + "','"+ extraField1 +"','"+ extraField2 +"')");
                    break;
                case "chromebook":
                    stmt.executeUpdate("INSERT INTO Chromebook (serial_number, username, password, eMCC) " +
                                       "VALUES ('" + serial_number + "','"+ extraField1 +"','"+ extraField2 +"','"+ extraField3 +"')");
                    break;
                default:
                    System.err.println ("Not a valid type");
            }
            
            // Create Accessories entries
            if (has_keyboard) {
                stmt.executeUpdate("INSERT INTO Device_Accessories (serial_number, accessory_type) " +
                                   "VALUES ('" + serial_number + "', 'keyboard')");
            }
            if (has_mouse) {
                stmt.executeUpdate("INSERT INTO Device_Accessories (serial_number, accessory_type) " +
                                   "VALUES ('" + serial_number + "', 'mouse')");
            }
            if (has_headphones) {
                stmt.executeUpdate("INSERT INTO Device_Accessories (serial_number, accessory_type) " +
                                   "VALUES ('" + serial_number + "', 'headphones')");
            }
            if (has_stylus) {
                stmt.executeUpdate("INSERT INTO Device_Accessories (serial_number, accessory_type) " +
                                   "VALUES ('" + serial_number + "', 'stylus')");
            }
        }
        catch (SQLException e) {
            System.err.println (e);
        }
    }
    
    public void createMaintenanceRecord(String serial_number, double cost, String issue, String fixedBy, 
                               String dateFixed, String location){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            
            // Create Employee Entry
            stmt.executeUpdate("INSERT INTO Maintenance_Record " + 
                               "(serial_number, cost, issue, location, technician_name, fixed_at) " +
                               "VALUES ('" + serial_number + "', "+ cost +" , '"+ issue +"','" + location + "', '" +
                                fixedBy +"', '"+ dateFixed +"')");
            
        }
        catch (SQLException e) {
            System.err.println (e);
        }
    }
    
    public void createSupplier(String Name, String Address, String Phone, String Email){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            
            // Create Employee Entry
            stmt.executeUpdate("INSERT INTO Supplier (Name, address, email, phone) " +
                               "VALUES ('" + Name + "', '"+ Address +"', '"+ Email +"', '"+ Phone +"')");
            
        }
        catch (SQLException e) {
            System.err.println (e);
        }
    }
    
    public void checkOutDevice(int empId, int adminId, String serial_number, String condition){ 
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
        
            // Update Device status field
        
            stmt.executeUpdate("INSERT INTO Check_Out_Record (serial_number, Employee_ID, checkout_time, Admin_ID_checkout, checkout_condition) " +
                               "VALUES ('" + serial_number + "', "+ empId +" , NOW(), '"+ adminId +"', '"+ condition +"')");
            
             stmt.executeUpdate("Update Device " +
                                "SET status = 'ASSIGNED' " +
                                "WHERE serial_number = '" + serial_number + "'");
            
        }
        catch (SQLException e) {
            System.err.println (e);
        }
    }
    
    public void checkInDevice(int adminId, String serial_number, String condition){
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement(); 
        
            stmt.executeUpdate("UPDATE Check_Out_Record SET return_time = NOW(), Admin_ID_checkin = "+ adminId +", " +
                               "checkout_condition = '" + condition + "' "+
                               "WHERE serial_number = '" + serial_number + "' AND return_time IS NULL");
            
             stmt.executeUpdate("Update Device " +
                                "SET status = 'UNASSIGNED', `condition` = '" + condition +"' " +
                                "WHERE serial_number = '" + serial_number + "'");
            
        }
        catch (SQLException e) {
            System.err.println (e);
        } 
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
