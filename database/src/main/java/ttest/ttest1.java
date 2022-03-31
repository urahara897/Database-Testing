package ttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ttest1 {
    
	@Test
	public void sql() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
        //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.println("Driver Loaded");
		String jdbcurl = "jdbc:mysql://localhost:3310/selenium" +"?characterEncoding=latin1&useConfigs=maxPerformance";
		String username = "root";
		String password = "root" ;
		Connection con = DriverManager.getConnection(jdbcurl, username, password);
		System.out.println("Connection established");
		Statement stmt1 = con.createStatement();
		String s = "select * from seleniumuser";
		ResultSet rslt = stmt1.executeQuery(s);
		while(rslt.next()) {
			
			String firstname = rslt.getString("firstname");
			System.out.println("Database Name is" +firstname);
			String email = rslt.getString("email");
			System.out.println("Database Email is" +email);
			
			
		}
		
		//String s1 = "update seleniumuser set email = 'chong@gmail.com' where firstname = 'Chang'";
		//int rslt1 = stmt1.executeUpdate(s1);
		//System.out.println(rslt1);
		System.out.println("After Email Update");
		rslt = stmt1.executeQuery(s);
          while(rslt.next()) {
			
			String firstname = rslt.getString("firstname");
			System.out.println("Database Name is" +firstname);
			String email = rslt.getString("email");
			System.out.println("Database Email is" +email);
			
			
		}
          
        String s2 = "update seleniumuser set firstname = 'Chang' where email = 'ching@gmail.com'";
        System.out.println("After Name Update");
        int rslt2 = stmt1.executeUpdate(s2);
        System.out.println(rslt2);
        rslt = stmt1.executeQuery(s);
        while(rslt.next()) {
			
			String firstname = rslt.getString("firstname");
			System.out.println("Database Name is" +firstname);
			String email = rslt.getString("email");
			System.out.println("Database Email is" +email);
			
			
		}
    
		con.close();
		System.out.println("Done");
		
	}
	
}
