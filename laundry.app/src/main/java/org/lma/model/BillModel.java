package org.lma.model;

import javax.swing.*;

import org.lma.helpers.Time;

public class BillModel {
	private String billID;
	private String timeCreated;
	private String userID;
	private String name;
	private int dry;
	private int wet;
	private int jacketBig;
	private int jacketMedium;
	private int jacketSmall;
	private int blanketBig;
	private int blanketMedium;
	private int blanketSmall;
	private String othersName;
	private long othersTotal;
	private long money;
	private boolean purchased;
	
	
	public String getBillID() {
		return billID;
	}
	public void setBillID(String billID) {
		this.billID = billID;
	}
	public String getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDry() {
		return dry;
	}
	public void setDry(int dry) {
		this.dry = dry;
	}
	public int getWet() {
		return wet;
	}
	public void setWet(int wet) {
		this.wet = wet;
	}
	public int getJacketBig() {
		return jacketBig;
	}
	public void setJacketBig(int jacketBig) {
		this.jacketBig = jacketBig;
	}
	public int getJacketMedium() {
		return jacketMedium;
	}
	public void setJacketMedium(int jacketMedium) {
		this.jacketMedium = jacketMedium;
	}
	public int getJacketSmall() {
		return jacketSmall;
	}
	public void setJacketSmall(int jacketSmall) {
		this.jacketSmall = jacketSmall;
	}
	public int getBlanketBig() {
		return blanketBig;
	}
	public void setBlanketBig(int blanketBig) {
		this.blanketBig = blanketBig;
	}
	public int getBlanketMedium() {
		return blanketMedium;
	}
	public void setBlanketMedium(int blanketMedium) {
		this.blanketMedium = blanketMedium;
	}
	public int getBlanketSmall() {
		return blanketSmall;
	}
	public void setBlanketSmall(int blanketSmall) {
		this.blanketSmall = blanketSmall;
	}
	public String getOthersName() {
		return othersName;
	}
	public void setOthersName(String othersName) {
		this.othersName = othersName;
	}
	public long getOthersTotal() {
		return othersTotal;
	}
	public void setOthersTotal(long othersTotal) {
		this.othersTotal = othersTotal;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public boolean isPurchased() {
		return purchased;
	}
	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	
	public BillModel(String newUserID, JTextField nameField, JTextField weightField1, JTextField weightField2, 
			JTextField to1Field, JTextField vua1Field, JTextField nho1Field, JTextField to2Field, JTextField vua2Field, JTextField nho2Field,
			JTextField tenDVField, JTextField soTienField, long numberTotalAmount, JCheckBox check1, JCheckBox check2, JRadioButton weightAfter1, JRadioButton weightAfter2) {
		this.setBillID(Time.convertTimeToID());
		this.setUserID(newUserID);
		this.setTimeCreated(Time.convertTimeToString());
		this.setName(nameField.getText());
		
		/////////////////////////////////////////////////////////////////////////////Wet and Dry
		if (weightField1.getText() == null || weightField1.getText().compareTo("") == 0) {
			this.setDry(0);
		}
		else {
			this.setDry(Integer.parseInt(weightField1.getText()));
		}
		
		if (weightField2.getText() == null || weightField2.getText().compareTo("") == 0) {
			this.setWet(0);
		}
		else {
			this.setWet(Integer.parseInt(weightField2.getText()));
		}
		
		///////////////////////////////////////////////////////////////////////////jacket
		if (to1Field.getText() == null || to1Field.getText().compareTo("") == 0) {
			this.setJacketBig(0);
		}
		else {
			this.setJacketBig(Integer.parseInt(to1Field.getText()));
		}
		
		if (vua1Field.getText() == null || vua1Field.getText().compareTo("") == 0) {
			this.setJacketMedium(0);
		}
		else {
			this.setJacketMedium(Integer.parseInt(vua1Field.getText()));
		}
		
		if (nho1Field.getText() == null || nho1Field.getText().compareTo("") == 0) {
			this.setJacketSmall(0);
		}
		else {
			this.setJacketSmall(Integer.parseInt(nho1Field.getText()));
		}
		
		//////////////////////////////////////////////////////////////////////////blanket
		if (to2Field.getText() == null || to2Field.getText().compareTo("") == 0) {
			this.setBlanketBig(0);
		}
		else {
			this.setBlanketBig(Integer.parseInt(to2Field.getText()));
		}
		
		if (vua2Field.getText() == null || vua2Field.getText().compareTo("") == 0) {
			this.setBlanketMedium(0);
		}
		else {
			this.setBlanketMedium(Integer.parseInt(vua2Field.getText()));
		}
		
		if (nho2Field.getText() == null || nho2Field.getText().compareTo("") == 0) {
			this.setBlanketSmall(0);
		}
		else {
			this.setBlanketSmall(Integer.parseInt(nho2Field.getText()));
		}
		
		////////////////////////////////////////////////////////////////others
		this.setOthersName(tenDVField.getText());
		
		if (soTienField.getText() == null || soTienField.getText().compareTo("") == 0) {
			this.setOthersTotal(0);
		}
		else {
			this.setOthersTotal(Integer.parseInt(soTienField.getText()));
		}
		
		////////////////////////////////////////////////////////////////totals
		this.setMoney(numberTotalAmount);
		
		
		////////////////////////////////////////////////////////////////purchased
		if ((check1.isSelected() && weightAfter1.isSelected()) ||
				(check2.isSelected() && weightAfter2.isSelected())) {
			this.setPurchased(false);
		}
		else {
			this.setPurchased(true);
		}
	}
	
}
