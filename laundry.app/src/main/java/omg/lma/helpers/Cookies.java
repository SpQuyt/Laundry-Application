package omg.lma.helpers;

import java.io.*;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Cookies {
	public static void createCookieFile(String username, String password) throws JSONException, IOException {
		FileOutputStream out = new FileOutputStream("laundryCookies");
		String space = " ";
		out.write(username.getBytes());
		out.write(space.getBytes());
		out.write(password.getBytes());
		String lineBreak = "\n";
		out.write(lineBreak.getBytes());
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
				cookie += read;
			}
			
			username = cookie.split(" ")[0];
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return username;
	}
	
	public static String readCookieFilePassword() throws IOException {
		String cookie = "";
		String username = "";
		String password = "";
		try (BufferedReader br = new BufferedReader(new FileReader(Links.testExist))) {

			String read;
			while ((read = br.readLine()) != null) {
				cookie += read;
			}
			password = cookie.split(" ")[1];
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return password;
	}
}
