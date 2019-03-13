package org.lma.online;

import java.net.UnknownHostException;

import javax.swing.*;

import com.mongodb.*;

public class Database {
	private static String uri = "mongodb://<dbuser>:<dbpassword>@ds141368.mlab.com:41368/quick_laundry";
	private static MongoClient mongoClient = null;
	private static DB database;
	
	public static void main(String[] args) {
		connectDB();
	}
	
	public static boolean connectDB() {
		try {
			mongoClient = new MongoClient(new MongoClientURI(uri));
			database = mongoClient.getDB("quick_laundry");
			JOptionPane.showMessageDialog(new JFrame(), "Kết nối thành công!");
			return true;
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(new JFrame(), "Không thể kết nối dữ liệu!");
			return false;
		}
	}
	
	public static void queryUsers() {
		try {
			DBCollection collection = database.getCollection("users");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
