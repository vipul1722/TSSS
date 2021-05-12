package Dewsolutions.TSSS;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Signup {


	

	

	@Test
	public void beforeClass() {
	
			// STEP 1: Connect to database
			
			//MongoClient mongoClient = new MongoClient("13.232.125.176", 27017);
			
			String dbURI = "mongodb://sssdb:TatASsdB213@13.232.125.176:27017/sssdb";
			//com.mongodb.client.MongoClient mongoClient=MongoClients.create(dbURI);
			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
			
			DB database = mongoClient.getDB("sssdb");
			
			DBCollection collection = database.getCollection("users");

			/*
			 * DBCursor cursor = collection.find(); while(cursor.hasNext()) {
			 * System.out.println(cursor.next()); }
			 */
		      
			    BasicDBObject whereQuery = new BasicDBObject();
			    whereQuery.put("email","vipula@dewsolutions.in");
			    DBCursor cursor = collection.find(whereQuery);
			    while(cursor.hasNext()) {
			        System.out.println(cursor.next());
			    }
			    

		     
		      
	}}

			
			
			

