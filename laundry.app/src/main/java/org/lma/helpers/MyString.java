package org.lma.helpers;

public class MyString {
	// Function to check String for only Alphabets 
    public static boolean isStringOnlyAlphabet(String str) 
    { 
        return ((str != null) 
                && (!str.equals("")) 
//                && (str.matches("^[a-zA-Z]*$"))
                ); 
    } 
}
