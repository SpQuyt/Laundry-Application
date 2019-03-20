package org.lma.online;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class API {
	public static ConnectServer con;
	public static JSONObject response;
	
	public static JSONObject loginAPI(String user, String pass){	
		//add params
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", user));
		params.add(new BasicNameValuePair("password", pass));
		
		//send POST request to server
		try {
			response = ConnectServer.sendPost(params);
		} catch (Exception e1) {
			response = null;
			e1.printStackTrace();
		}
		return response;
	}
	
}
