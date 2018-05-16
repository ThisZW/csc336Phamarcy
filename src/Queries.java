/**
 * Created by James on 7/22/2017.
 */
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Queries {
    private static final String URL = "jdbc:mysql://orderingsystemins.cdkb9s3xi6ry.us-east-2.rds.amazonaws.com/PharmacyDB";
    private static final String USERNAME = "Zw";
    private static final String PASSWORD = "a00789123";

    private Connection connection;
    //private PreparedStatement selectAllPeople;
    private Patient p;
    
    public Queries() {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            //selectAllPeople = connection.prepareStatement("SELECT * FROM patient");

        }
        catch(Exception sqlException){
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
    
    public Queries(Patient input) {
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
            this.p = input;
            //selectAllPeople = connection.prepareStatement("SELECT * FROM patient");
        }
        catch(Exception sqlException){
            sqlException.printStackTrace();
            System.exit(1);
        }
    }
    
    public void setPatient(Patient p){
    	this.p = p;
    }
    
    public void insertDataIntoDatabase(){
        
        
        /*
        String query = "{ call <insertDataIntoDatabase> }";
        ResultSet rs;
        
        try (Connection conn = MySQLJDBCUtil.getConnection();
             CallableStatement stmt = conn.prepareCall(query)) {
            );
    
         
    }
    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    */
    
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        */
        
    	try{
    		//Let's now only input a address string with 3 commas, no space around commas.
    		String[] address_arr = p.getAddress().split(",");
    		
    		//System.out.println(address_arr[1]);
    		PreparedStatement insertAddress = connection.prepareStatement(""
    				+ "INSERT INTO `address` "
    				+ "VALUES (NULL, ?,?,?,?,? );"
    				);
    		insertAddress.setString(1, address_arr[0]);
    		insertAddress.setString(2, address_arr[1]);
    		insertAddress.setString(3, address_arr[2]);
    		insertAddress.setString(4, address_arr[3]);
    		insertAddress.setInt(5, Integer.parseInt(address_arr[4]));
    		insertAddress.execute();
    		
    		PreparedStatement insertPatient = connection.prepareStatement(""
    				+ "INSERT INTO `patient`"
    				+ "VALUES (NULL, ?,?,?,LAST_INSERT_ID());"
    				);
    		insertPatient.setString(1, p.getFirstName());
    		insertPatient.setString(2, p.getLastName());
    		insertPatient.setString(3, p.getPhoneNumber());
    		insertPatient.execute();
    		
    		PreparedStatement insertPaymentMethod = connection.prepareStatement(""
    				//+ "SELECT id INTO @id from `payment_method` WHERE `description` = ? LIMIT 1;"
    				+ "INSERT INTO `payment_method` VALUES"
    				+ "(NULL, ?);"
    				);
    		insertPaymentMethod.setString(1, p.getPaymentMethod());
    		insertPaymentMethod.execute();

    		SimpleDateFormat dateFormat= new SimpleDateFormat("MMddyyyy");
    		java.util.Date date = dateFormat.parse(p.getDateOfFilled());
    		Date sqlDate = new Date(date.getTime());
    		
    		PreparedStatement insertPrescription = connection.prepareStatement(""
    				+ "INSERT INTO `prescription` "
    				+ "VALUES (NULL, (SELECT MAX(id) FROM `patient`) , ? , ?, LAST_INSERT_ID());  "
    				);
    		insertPrescription.setInt(1, p.getPrescriberId());
    		insertPrescription.setDate(2, sqlDate);
    		insertPrescription.execute();
    		
    		PreparedStatement insertCompanyName = connection.prepareStatement(""
    				+ "INSERT INTO `drug_company` "
    				+ "VALUES (NULL, ?, 0);"
    				);
    		insertCompanyName.setString(1, p.getDrugCompany());
    		insertCompanyName.execute();
    		
    		PreparedStatement insertDrug = connection.prepareStatement(""
    				+ "INSERT INTO `drug` "
    				+ "VALUES (NULL, ?,?,?,?,?,LAST_INSERT_ID());");
    		insertDrug.setString(1, p.getDrugName());
    		insertDrug.setDouble(2, p.getDrugCost());
    		insertDrug.setDouble(3, p.getAmount());
    		insertDrug.setInt(4, p.getUnit());
    		insertDrug.setInt(5, p.getDose());
    		insertDrug.execute();
    		
    		PreparedStatement insertPrescriptionItems = connection.prepareStatement(""
    				+ "INSERT INTO `prescription_items` "
    				+ "VALUES ( (SELECT MAX(id) FROM `prescription`), LAST_INSERT_ID() ); ");
    		insertPrescriptionItems.execute();
    		
    	}  
    	catch(Exception sqlException){
            sqlException.printStackTrace();
            //System.exit(1);
        }
    	
    }
    
    public ResultSet browseAllDataFromDatabase(){



/*
 String query = "{ call <browseDataIntoDatabase> }";
 ResultSet rs;
 
 try (Connection conn = MySQLJDBCUtil.getConnection();
 CallableStatement stmt = conn.prepareCall(query)) {
 );
 
 rs = stmt.executeQuery();
 while (rs.next()) {
 System.out.println(String.format("%s - %s",
 rs.getString("first_name") + " "
 + rs.getString("last_name"),
 rs.getString("skill")));
 }
 }
 catch (SQLException ex) {
 System.out.println(ex.getMessage());
 }
 */



    	try{
    		PreparedStatement browse = connection.prepareStatement(""
    				+ "SELECT p.id, p.first_name, p.last_name, p.phone_number, "
    				+ "CONCAT(a.street,',',a.city,',',state,',',country,',',zip_code) as address,"
    				+ "pm.description, psp.prescriber_id, DATE_FORMAT(psp.date_of_filled,'%m%d%Y'), d.name,"
					+ "d.cost, d.amount, d.unit, d.dose, dc.name, d.id "
					+ "FROM `prescription` as psp "
					+ "INNER JOIN `patient` as p on p.id = psp.patient_id "
					+ "INNER JOIN `payment_method` as pm on psp.payment_method_id = pm.id "
					+ "INNER JOIN `prescription_items`as pi on psp.id = pi.prescription_id "
					+ "INNER JOIN `address` as a on p.address_id = a.id "
					+ "INNER JOIN `drug` as d on d.id = pi.drug_id "
					+ "INNER JOIN `drug_company`as dc on dc.id = d.company_id "
					//+ "where p.id = ?"
    				);
    		//browse.setInt(1, patientId);
    		ResultSet result = browse.executeQuery();
    		return result;
    	}
    	catch(Exception sqlException){
            sqlException.printStackTrace();
            //System.exit(1);
        }
		return null;
    }
    
    public void deleteDataByPatientId(int id){



/*
 String query = "{ call <deleteDataIntoDatabase> }";
 ResultSet rs;
 
 try (Connection conn = MySQLJDBCUtil.getConnection();
 CallableStatement stmt = conn.prepareCall(query)) {
 );
 
 }
 catch (SQLException ex) {
 System.out.println(ex.getMessage());
 }
 */

    	try{
    		PreparedStatement delete = connection.prepareStatement(""
    				+ "DELETE p,pi,psp,d,dc FROM `prescription` as psp "
    				+ "LEFT JOIN `patient` as p on p.id = psp.patient_id "
    				+ "LEFT JOIN `prescription_items`as pi on psp.id = pi.prescription_id "
    				+ "LEFT JOIN `drug` as d on d.id = pi.drug_id "
    				+ "LEFT JOIN `drug_company`as dc on dc.id = d.company_id where p.id = ?; ");

    		//this will delete 5 joined tables
    		delete.setInt(1,id);
    		delete.execute();
    	}  
    	catch(Exception sqlException){
            sqlException.printStackTrace();
            //System.exit(1);
        }
    }
    
    public void updateDataByPatientId(){



/*
String query = "{ call <updateDataByPatientId> }";
ResultSet rs;

try (Connection conn = MySQLJDBCUtil.getConnection();
CallableStatement stmt = conn.prepareCall(query)) {
);

}
catch (SQLException ex) {
System.out.println(ex.getMessage());
}
*/

    	try{
    		PreparedStatement update = connection.prepareStatement(""
    				+ "update `prescription` as psp "
    				+ "LEFT JOIN `patient` as p on p.id = psp.patient_id "
    				+ "LEFT JOIN `prescription_items`as pi on psp.id = pi.prescription_id "
    				+ "LEFT JOIN `drug` as d on d.id = pi.drug_id "
    				+ "LEFT JOIN `drug_company`as dc on dc.id = d.company_id "
                    + "set p.first_name = ?, p.last_name = ?, p.phone_number = ?"
					+ "where p.id = ?");
    		update.setString(1, p.getFirstName());
    		update.setString(2, p.getLastName());
    		update.setString(3, p.getPhoneNumber());
    		update.setInt(4, p.getID());
    		update.execute();
    	}
    	catch(Exception sqlException){
            sqlException.printStackTrace();
            //System.exit(1);
        }
    }
    /*public List<Patient>getAllPeople() {
        List<Patient> results = null;
        ResultSet resultSet = null;
        try {
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList<Patient>();
            while (resultSet.next()) {
                results.add(new Patient(resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getInt("PhoneNumber"),
                        resultSet.getInt("address_id")));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }*/


    public void close(){
        try{
            connection.close();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
            close();
        }
    }
    
}
