package net.mongodb.example;

import java.net.UnknownHostException;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * @author krisjin
 * @date 2014-6-24下午4:30:39
 */

public class MongoDBCRUDTest {

	private Mongo mongo = null;
	private DB db;
	private DBCollection users;

	@Before
	public void inti() {
		try {
			mongo = new Mongo("127.0.0.1",27017);
			db = mongo.getDB("shop");
			users = db.getCollection("users");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
	
	@After
    public void destory() {
        if (mongo != null)
        	mongo.close();
        mongo = null;
        db = null;
        users = null;
        System.gc();
    }
	
	@Test
	public void queryAll(){
		DBCursor cursor = users.find();
		while(cursor.hasNext()){
			print(cursor.next());
		}
		
	}
	
	//@Test
	public void add(){
		
		DBObject user  =  new BasicDBObject();
		user.put("name", "jingui");
		user.put("age", 28);
		user.put("sex", "男");
		users.save(user);
		queryAll();
	}
	
//	@Test
	public void delete(){
		
//		print("删除Id=53a93d97957a3f1c3e54f22d");
//		users.remove(new BasicDBObject(("_id"),new ObjectId("53a93d97957a3f1c3e54f22d")));
		
		print("删除年龄大于24的用户");
		users.remove(new BasicDBObject("age", new BasicDBObject("$gte", 24)));
		
		
	}
	
	
	
	public void print(Object o) {
        System.out.println(o);
    }
}
