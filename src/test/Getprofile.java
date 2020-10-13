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

@Path("/findinf")
public class Getprofile {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getmvc(@DefaultValue("2")@QueryParam("agid")int agid) throws Exception
	{
		int i=0;		
		System.out.println(agid+" "+" ");
//		boolean sta = false;
		String message = "ian";
		
		ArrayList<Profile> vehList = new ArrayList<>();
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
			      

		      ResultSet rs = stmt.executeQuery("SELECT * FROM `agents` WHERE  `Agent_id`='"+agid+"'");
		      //STEP 5: Extract data from result set
		     

		      while(rs.next()){
//		    	  Policy policy = new Policy();
		    	Profile veh = new Profile();
		    	  veh.setPno(rs.getInt("Phone"));
		    	  veh.setNid(rs.getInt("ID_No"));
                  veh.setFna(rs.getString("First_name"));

		          veh.setLna(rs.getString("Last_name"));
		          veh.setGen(rs.getString("Gender"));
		          veh.setRegion(rs.getString("Region"));
		          veh.setUser(rs.getString("Username"));
		          veh.setAgid(rs.getInt("Agent_id"));

		    	  

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
		        Profile veh =new Profile();
		    	  veh.setPno(0);
		    	  veh.setNid(0);
                veh.setFna("None");
		          veh.setLna("None");
		          veh.setGen("None");
		          veh.setUser("None");
		    	  veh.setRegion("None");
		    	  veh.setAgid(agid);

		    	  

		    	  vehList.add(i, veh);}
		        else {
		            System.out.println("The ArrayList is not empty"); 
		        }
		        
			 Gson gson = new Gson();
			 String jsonArray = gson.toJson(vehList);
			
			return jsonArray;
		
		
		
	}
}
