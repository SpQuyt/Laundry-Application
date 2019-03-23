package org.lma.model;

import org.json.JSONObject;

public class UserLoginModel {
	private String username;
	private String password;
	private String fullname;
	private String objID;
		
	private int giatSay;
	private int giatUot;
	private int aoKhoacTo;
	private int aoKhoacVua;
	private int aoKhoacNho;
	private int chanTo;
	private int chanVua;
	private int chanNho;
	
	/////////////////////////////////////////////////getter
	public int getGiatSayTien() {
		return giatSay;
	}
	
	public int getGiatUotTien() {
		return giatUot;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public String getObjID() {
		return objID;
	}
	
	public int getAoKhoacToTien() {
		return aoKhoacTo;
	}
	
	public int getAoKhoacVuaTien() {
		return aoKhoacVua;
	}
	
	public int getAoKhoacNhoTien() {
		return aoKhoacNho;
	}
	
	public int getChanToTien() {
		return chanTo;
	}
	
	public int getChanVuaTien() {
		return chanVua;
	}
	
	public int getChanNhoTien() {
		return chanNho;
	}
	
	/////////////////////////////////////////////////setter
	
	public void setAoKhoacToTien(int aoKhoacTo) {
		this.aoKhoacTo = aoKhoacTo;
	}
	
	public void setAoKhoacVuaTien(int aoKhoacVua) {
		this.aoKhoacVua = aoKhoacVua;
	}
	
	public void setAoKhoacNhoTien(int aoKhoacNho) {
		this.aoKhoacNho = aoKhoacNho;
	}
	
	public void setChanToTien(int chanTo) {
		this.chanTo = chanTo;
	}
	
	public void setChanVuaTien(int chanVua) {
		this.chanVua = chanVua;
	}
	
	public void setChanNhoTien(int chanNho) {
		this.chanNho = chanNho;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public void setObjID(String objID) {
		this.objID = objID;
	}
	
	public void setGiatUotTien(int giatUot) {
		this.giatUot = giatUot;
	}
	
	public void setGiatSayTien(int giatSay) {
		this.giatSay = giatSay;
	}
		
	
	public UserLoginModel(JSONObject obj) {
		this.username = obj.getJSONObject("result").get("username").toString();
		this.password = obj.getJSONObject("result").get("password").toString();
		this.fullname = obj.getJSONObject("result").get("fullname").toString();
		this.objID = obj.getJSONObject("result").getString("_id").toString();
		
		JSONObject price = obj.getJSONObject("result").getJSONObject("price");		
		this.giatSay = Integer.parseInt(price.get("dry").toString());
		this.giatUot = Integer.parseInt(price.get("wet").toString());
		this.aoKhoacTo = Integer.parseInt(price.getJSONObject("jacket").get("big").toString());
		this.aoKhoacVua = (Integer.parseInt(price.getJSONObject("jacket").get("medium").toString()));
		this.aoKhoacNho = (Integer.parseInt(price.getJSONObject("jacket").get("small").toString()));
		this.chanTo = Integer.parseInt(price.getJSONObject("blanket").get("big").toString());
		this.chanVua = Integer.parseInt(price.getJSONObject("blanket").get("medium").toString());
		this.chanNho = Integer.parseInt(price.getJSONObject("blanket").get("small").toString());
		
	}
}
