package com.squad.ESP.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPrimaryMapping {
	
	@Id
	private String userName;
	private String primaryImg;
	private String secondaryImg;
	private boolean select;
	
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPrimaryImg() {
		return primaryImg;
	}
	public void setPrimaryImg(String primaryImg) {
		this.primaryImg = primaryImg;
	}
	public String getSecondaryImg() {
		return secondaryImg;
	}
	public void setSecondaryImg(String secondaryImg) {
		this.secondaryImg = secondaryImg;
	}
	
}
