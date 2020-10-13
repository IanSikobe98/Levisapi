package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/login")
public class Login {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String Amountdue(@DefaultValue("2")@QueryParam("user")String pno ,@QueryParam("pass")String pass) throws Exception
	{
		
		System.out.println(pno+" "+" "+pass+" ");
		boolean sta = false;
		String message = "ian";
		 int id = 0 ;
		 String fname= "tr";
		 String mname=" ";
		 String sname=" ";
		 String mn="u";
		 String food2 ="pop";

		
		  Statement stmt = null;
		try{  
			//register driver
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			//open connection
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:/sales","root","");  
	     
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = con.createStatement();
		      

	      ResultSet rs = stmt.executeQuery("SELECT * FROM `agents` WHERE Username='"+pno+"' AND Password='"+pass+"'");
	      //STEP 5: Extract data from result set
	     
	      String no="0";
	      String passw = null;
	      while(rs.next()){
	         //Retrieve by column name
	         id  = rs.getInt("Agent_ID");
	         no = rs.getString("Username");
	         passw = rs.getString("Password");
	         fname = rs.getString("First_name");
	         mname = rs.getString("Username");
	         sname = rs.getString("Last_name");
	         

	         //Display values
	         System.out.print("Agent ID_No: " + id);
	         System.out.print(", Username: " + no);
	         System.out.print(", Password: " + passw);
	         System.out.print(", First_name: " + fname);
	         System.out.print(", Username: " + mname);
	         System.out.print(", Last_name: " + sname);
	         
	      }
	      if(pno.equals(no)&&pass.equals(passw)) {
	    	  
	    	  System.out.println("true");
	    	  sta =true;
	    	  message = "Successful Login";
	  		food2 = "{\"status\": "+sta+", \"message\": \" "+message+"\", \"fname\": \" "+fname+"\", \"Agentid\":  "+id+", \"sname\": \" "+sname+"\"}";
			
	      }
	      
	      else {
	    	  System.out.println("false");
	    	 sta =false;
	    	 message = "Unsuccessful Login";
	    	food2 ="{\"status\": "+sta+", \"Message\": \""+message+"\"}";
	      }
	      
	      mn=fname;
	      System.out.println(fname+fname);
	      rs.close();
			
 
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		
		System.out.println(message);

	
		
		return food2;
	
	
	
}}