package Dewsolutions.TSSS;

import org.bson.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class signup12 {
	
	MongoClient mongoClient = null;
	MongoDatabase db = null;

	

		@Test
		public void beforeClass() {
		
				// STEP 1: Connect to database
				
				//MongoClient mongoClient = new MongoClient("13.232.125.176", 27017);
				
				String dbURI = "mongodb://sssdb:TatASsdB213@13.232.125.176:27017/sssdb";
				//com.mongodb.client.MongoClient mongoClient=MongoClients.create(dbURI);
				MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
				
				DB database = mongoClient.getDB("sssdb");
				
				DBCollection collection = database.getCollection("users");

				
			      
				    BasicDBObject whereQuery = new BasicDBObject();
				    whereQuery.put("email","vipula@dewsolutions.in");
				    DBCursor cursor = collection.find(whereQuery);
				    
				    for(     DBObject obj   : cursor)
				    {
				    	String firstname= obj.get("firstname").toString();
				    	System.out.println(firstname);
				    	
				    	String otp=obj.get("phpin").toString();
				    	System.out.println(otp);
				    
				    	}
		
		    
			 

			}} 


