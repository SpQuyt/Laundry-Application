package org.lma.online;

import java.io.BufferedReader;
import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;
import org.lma.helpers.Links;
import org.lma.helpers.Storage;
import org.lma.model.BillModel;

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
		
		//send POST request to server
		try {
			BufferedReader in = ConnectServer.sendPost(params, Links.urlGetBillServer);
			String result ="";
			String output = null;
			while ((result = in.readLine()) != null) {
				output = result;
			}
			response = new JSONObject(output);
			
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return response;
	}
	
	public static JSONObject updateBillAPI(BillModel newBill){
		//add params
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("billID", newBill.getBillID()));
		params.add(new BasicNameValuePair("userID", Storage.newUserLogin.getObjID()));
		params.add(new BasicNameValuePair("name", newBill.getName()));
		params.add(new BasicNameValuePair("dry", Integer.toString(newBill.getDry())));
		params.add(new BasicNameValuePair("wet", Integer.toString(newBill.getWet())));
		params.add(new BasicNameValuePair("jacketBig", Integer.toString(newBill.getJacketBig())));
		params.add(new BasicNameValuePair("jacketMedium", Integer.toString(newBill.getJacketMedium())));
		params.add(new BasicNameValuePair("jacketSmall", Integer.toString(newBill.getJacketSmall())));
		params.add(new BasicNameValuePair("blanketBig", Integer.toString(newBill.getBlanketBig())));
		params.add(new BasicNameValuePair("blanketMedium", Integer.toString(newBill.getBlanketMedium())));
		params.add(new BasicNameValuePair("blanketSmall", Integer.toString(newBill.getBlanketSmall())));
		params.add(new BasicNameValuePair("otherName", newBill.getOthersName()));
		
		System.out.println(newBill.getOthersTotal());
		params.add(new BasicNameValuePair("otherTotal", Long.toString(newBill.getOthersTotal())));
		params.add(new BasicNameValuePair("money", Long.toString(newBill.getMoney())));
		params.add(new BasicNameValuePair("purchased", Boolean.toString(newBill.isPurchased())));
		
		//create JSON response
		JSONObject response = null;
		
		//send POST request to server
		try {
			BufferedReader in = ConnectServer.sendPost(params, Links.urlInsertBillServer);
			String result ="";
			String output = null;
			while ((result = in.readLine()) != null) {
				output = result;
			}
			response = new JSONObject(output);
			
			in.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return response;
	}
	
}
