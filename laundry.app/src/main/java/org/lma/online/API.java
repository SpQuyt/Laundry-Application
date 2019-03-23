package org.lma.online;

import java.io.BufferedReader;
import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;

import omg.lma.helpers.Links;

public class API {
	
	public static JSONObject loginAPI(String user, String pass){	
		//add params
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", user));
		params.add(new BasicNameValuePair("password", pass));
		
		//create JSON response
		JSONObject response = null;
		
		//send POST request to server
		try {
			BufferedReader in = ConnectServer.sendPost(params, Links.urlLoginServer);
			String result ="";
			String output = null;
			while ((result = in.readLine()) != null) {
			    output = result.replace("[", "").replace("]", "");
			}
			System.out.println("");
			response = new JSONObject(output); 
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return response;
	}
	
	public static JSONObject getBillAPI(String objID){
		//add params
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("objID", objID));
		
		//create JSON response
		JSONObject response = null;
		JSONArray array = null;
		
		//send POST request to server
		try {
			BufferedReader in = ConnectServer.sendPost(params, Links.urlGetBillServer);
			String result ="";
			String output = null;
			while ((result = in.readLine()) != null) {
//				System.out.print("BILL" + result);
//			    output = result.replace("[", "").replace("]", "");
				output = result;
			}
			response = new JSONObject(output);
			
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
//		System.out.println("BILL  " + response.getJSONObject("result"));
		return response;
	}
	
}
