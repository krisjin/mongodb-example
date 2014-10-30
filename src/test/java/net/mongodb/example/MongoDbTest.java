package net.mongodb.example;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * @author krisjin
 * @date 2014-6-24下午3:34:01
 */

public class MongoDbTest {

	@Test
	public void test() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient();

		for (String name : mongoClient.getDatabaseNames()) {
			System.out.println("数据库:" + name);
		}

		DB db = mongoClient.getDB("test");

		for (String name : db.getCollectionNames()) {
			System.out.print(name + ",");
		}

		DBCollection users = db.getCollection("users");
		DBCursor cur = users.find();

		while (cur.hasNext()) {
			System.out.println(cur);
		}

	}
}
