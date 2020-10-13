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

@Path("/salesstore")
public class Regsales {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String Amountdue(@DefaultValue("2")@QueryParam("gna")String gna ,@QueryParam("pna")String pna,@QueryParam("rda")String rda,@QueryParam("price")int price,@QueryParam("agid")int agid,@QueryParam("region")String region,@QueryParam("fna")String fna,@QueryParam("lna")String lna,@QueryParam("gen")String gen,@QueryParam("nid")int nid,@QueryParam("age")int age,@QueryParam("ker")String ker,@QueryParam("hou")String hou,@DefaultValue("2")@QueryParam("ele")String ele ,@QueryParam("inc")String inc) throws Exception
	{
		
		System.out.println(gna+" "+pna+" "+rda+" "+price+" "+agid+" "+region+" "+fna+" "+lna+" "+gen+" "+nid+" "+age+" "+ker+" "+hou+" "+ele+" "+ inc);
		String food2= "{\"status\": "+true+", \"message\": \" "+pna+" already registered\"}";
		String food3="";
		
//		System.out.println("hello ian");
		
		try{  
			//register driver
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			//open connection
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:/sales","root","");  
			//
			
		 //execute query-statement 
			Statement stmt=con.createStatement();  
			
//		      ResultSet rs = stmt.executeQuery("SELECT * FROM `vehicle` WHERE `Regno`='"+id+"'");
		      //STEP 5: Extract data from result set
		     
//		      String no="0";
	
		     
		      
			 stmt.executeUpdate("INSERT INTO `sales` (`Group_name`, `Product_name`, `Registration_date`, `Price`, `Agent_id`, `Region`, `First_name`, `Last_name`, `Gender`, `ID_no`, `Age`, `Kerosene`, `Housing`, `Electricity`, `Income`) VALUE ('"+gna+"','"+pna+"','"+rda+"','"+price+"','"+agid+"','"+region+"','"+fna+"','"+lna+"','"+gen+"','"+nid+"','"+age+"','"+ker+"','"+hou+"','"+ele+"','"+inc+"')");
			
System.out.println("Records inserted");
			
			

		      

			
			
 
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
		
		
		
		
		
		
//		food2=food3;
		return food2;
	
	
	
}
}