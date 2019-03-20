package org.lma.online;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.http.NameValuePair;
import org.json.*;

import omg.lma.helpers.Links;

public class ConnectServer {
	
	

//	public static void main(String[] args) throws Exception {
//
//		ConnectServer http = new ConnectServer();
//		// co the xoa dong tiep theo nay
//		Internet inter = new Internet();
//
////		System.out.println("Testing 1 - Send Http GET request");
////		http.sendGet();
//		
//		System.out.println("\nTesting 2 - Send Http POST request");
//		http.sendPost();
//
//	}

	// HTTP GET request
	public static void sendGet() throws Exception {
		
		URL obj = new URL(Links.urlServer);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", Links.USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + Links.urlServer);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	
	// HTTP POST request
	public static JSONObject sendPost(List<NameValuePair> params) throws Exception {
		
		URL obj = new URL(Links.urlServer);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", Links.USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
				
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(getQuery(params));
		wr.flush();
		wr.close();

		System.out.println("\nSending 'POST' request to URL : " + Links.urlServer + "\n");

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		
		String result ="";
		String output = null;
		while ((result = in.readLine()) != null) {
		    output = result.replace("[", "").replace("]", "");
		}
		JSONObject jsonObject = new JSONObject(output); 
		return jsonObject;
	}
	
	private static String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
	{
	    StringBuilder result = new StringBuilder();
	    boolean first = true;

	    for (NameValuePair pair : params)
	    {
	        if (first)
	            first = false;
	        else
	            result.append("&");

	        result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
	        result.append("=");
	        result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
	    }

	    return result.toString();
	}

}
