package org.lma.online;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class API {
	public static void loginAPI(String user, String pass) throws Exception {	
		//add params
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user", "A"));
		params.add(new BasicNameValuePair("pass", "A"));
		
		//send POST request to server
		ConnectServer.sendPost(params);

	}
	
}
