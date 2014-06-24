package net.mongodb.example;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

/**
 * @author krisjin
 * @date  2014-6-24下午3:34:01
 */

public class MongoDbTest {
	
	@Test
	public  void test() throws UnknownHostException {
		Mongo mongo =new Mongo();
		
		for(String name:mongo.getDatabaseNames()){
			System.out.println("数据库:"+name);
		}
		
		DB db = mongo.getDB("test");
		
		System.out.println("聚集名:");
		for(String name:db.getCollectionNames()){
			System.out.print(name+",");
		}
		
		DBCollection users = db.getCollection("users");
		DBCursor cur= users.find();
		
		while(cur.hasNext()){
			System.out.println(cur);
		}
		
	}
}

