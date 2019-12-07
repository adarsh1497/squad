package com.squad.ESP.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrimarySecondary {
	
	private int number;
	private String userName;
	private String primary;
	private String secondary;
	private boolean select;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	public String getSecondary() {
		return secondary;
	}
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	
	
	
	
}