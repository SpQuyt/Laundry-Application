package org.lma.helpers;

import java.text.*;
import java.util.*;

public class Time {
	private static Date date = new Date();
	
	public static void main(String[] args) {
		convertTimeToString();
	}
	
	public static String convertTimeToID() {
		String counter = "";
		if (Storage.billCounter < 10) {
			counter += "00";
			counter += Storage.billCounter;
		}
		else if (Storage.billCounter < 100) {
			counter += "0";
			counter += Storage.billCounter;
		}
		else {
			counter += Storage.billCounter;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		
		return dateFormat.format(date).toString() + counter;
	}
	
	public static String convertTimeToString() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String string = dateFormat.format(date).toString();
		
		return string;
	}
}
