package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

@Path("/findsales")
public class Getsales {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getmvc(@DefaultValue("2")@QueryParam("agid")int agid) throws Exception
	{
		int i=0;		
		System.out.println(agid+" "+" ");
//		boolean sta = false;
		String message = "ian";
		
		ArrayList<Sales> vehList = new ArrayList<>();
		//Creating a JSONObject object
	      JSONObject jsonObject = new JSONObject();
	      //Creating a json array
	      JSONArray array = new JSONArray();
	      JSONObject record = new JSONObject();
	      
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
			      
//			      SELECT * FROM `vehicle` WHERE `Natid`="35032507" AND `VehType`="Motorcycle"
		      ResultSet rs = stmt.executeQuery("SELECT * FROM `tsales` WHERE  `Agent_id`='"+agid+"'");
		      //STEP 5: Extract data from result set
		     

		      while(rs.next()){
//		    	  Policy policy = new Policy();
		    	Sales veh = new Sales();
		    	  veh.setId(rs.getInt("id"));
		    	  veh.setGna(rs.getString("Group_name"));
                  veh.setPna(rs.getString("Product_name"));
		          veh.setFna(rs.getString("First_name"));
		          veh.setLna(rs.getString("Last_name"));
		          veh.setAgid(rs.getInt("Agent_id"));
		          veh.setDate(rs.getString("Registration_date"));

	        
		    	  

		    	  vehList.add(veh);

		      }
		     
		     
			      rs.close();
					con.close();  
				}catch(Exception e){ System.out.println(e);}  
		  
		  
//			 for (Vehicle obj : vehList) {
//		          System.out.print("Regno: "+obj.getRegno()+", ");
//		          System.out.print("Amount: "+obj.getNatid()+", ");
//		          System.out.print("gar: "+obj.getGar()+", ");
//		          System.out.print("issue date: "+obj.getIssue()+", ");
//		          System.out.print("model: "+obj.getModel()+", ");
//		          System.out.print("polno: "+obj.getPolno()+", ");
//		          System.out.print("stat1: "+obj.getStat1()+", ");
//		          System.out.print("type: "+obj.getType()+", ");
//		          
//		          
//		          System.out.println();
//		       }

			 System.out.println("FINISH"+i);
		        boolean ans = vehList.isEmpty(); 
		        if (ans == true) 
		        { System.out.println("The ArrayList is empty"); 
		        Sales veh =new Sales();
		    	  veh.setPna("None");
		    	  veh.setGna("None");
                veh.setFna("None");
		          veh.setLna("None");
		          veh.setId(0);
		          veh.setAgid(agid);
		          veh.setDate("None");
		          
		    	  

		    	  vehList.add(i, veh);}
		        else {
		            System.out.println("The ArrayList is not empty"); 
		        }
		        
			 Gson gson = new Gson();
			 String jsonArray = gson.toJson(vehList);
			
			return jsonArray;
		
		
		
	}
}
