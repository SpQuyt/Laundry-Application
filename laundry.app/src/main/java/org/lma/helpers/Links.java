package org.lma.helpers;

import java.io.File;

import javax.swing.ImageIcon;

public class Links {
	public static String urlLoginServer = "http://192.168.0.102:3000/users/login";
	public static String urlUpdateBillServer = "http://192.168.0.102:3000/bill/updateByBillID";
	public static String urlInsertBillServer = "http://192.168.0.102:3000/bill/insertBillToDB";
	public static String USER_AGENT = "Mozilla/5.0";
	public static ImageIcon img = new ImageIcon("./icon app.png");
	public static File testExist = new File("./laundryCookies");
}
