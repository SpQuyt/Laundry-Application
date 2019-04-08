package org.lma.helpers;

import java.text.*;
import java.util.*;

public class Time {
	public static void main(String[] args) {
		convertTimeToString();
	}
	
	public static String convertTimeToString() {
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
		Date date = new Date();
		
		return dateFormat.format(date).toString() + counter;
	}
}
