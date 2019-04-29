package org.lma.online;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.http.NameValuePair;
import org.lma.helpers.Links;

public class ConnectServer {

	// HTTP GET request
	public static BufferedReader sendGet(String urlServer) throws Exception {
		
		URL obj = new URL(urlServer);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", Links.USER_AGENT);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		
		return in;
	}
	
	// HTTP POST request
	public static BufferedReader sendPost(List<NameValuePair> params, String urlServer) throws Exception {
		
		URL obj = new URL(urlServer);
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

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		
		return in;
	}
	
	// HTTP PATCH request
		public static BufferedReader sendPatch(String urlServer) throws Exception {
			
			URL obj = new URL(urlServer);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("PATCH");

			//add request header
			con.setRequestProperty("User-Agent", Links.USER_AGENT);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			
			return in;
		}
	
	//Change Params to Query
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
