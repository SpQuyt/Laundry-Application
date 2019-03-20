package org.lma.model;

import java.io.*;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import omg.lma.helpers.Links;

public class Cookies {
	public static void createCookieFile(JSONObject response) throws JSONException, IOException {
		FileOutputStream out = new FileOutputStream("laundryCookies");
		String space = " ";
		out.write(response.getJSONObject("result").get("username").toString().getBytes());
		out.write(space.getBytes());
		out.write(response.getJSONObject("result").get("password").toString().getBytes());
//		String lineBreak = "\n";
//		out.write(lineBreak.getBytes());
		out.close();
	}
	
	public static boolean checkCookies() {
		if (!Links.testExist.exists()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@SuppressWarnings("null")
	public static String readCookieFileUsername() throws IOException {
		String cookie = "";
		String username = "";
		String password = "";
		try (BufferedReader br = new BufferedReader(new FileReader(Links.testExist))) {

			String read;
			while ((read = br.readLine()) != null) {
//				if (read.compareTo("\n") == 0) {
//					cookie += " ";
//				}
				cookie += read;
			}
			
			username = cookie.split(" ")[0];
			password = cookie.split(" ")[1];
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println(username);
		System.out.println(password);
		
		return username;
	}
	
	public static String readCookieFilePassword() throws IOException {
		String cookie = "";
		String username = "";
		String password = "";
		try (BufferedReader br = new BufferedReader(new FileReader(Links.testExist))) {

			String read;
			while ((read = br.readLine()) != null) {
//				if (read.compareTo("\n") == 0) {
//					cookie += " ";
//				}
				cookie += read;
			}
			
			username = cookie.split(" ")[0];
			password = cookie.split(" ")[1];
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println(username);
		System.out.println(password);
		
		return password;
	}
}
