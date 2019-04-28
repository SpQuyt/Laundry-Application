package org.lma.helpers;

import java.text.*;
import java.util.*;

public class MyTime {
	
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
		Date date = new Date();
		return dateFormat.format(date).toString() + counter;
	}
	
	public static String convertTimeToString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy   HH:mm:ss");
		Date date = new Date();
		String string = dateFormat.format(date).toString();
		
		return string;
	}
}
