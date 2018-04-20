package com.websystique.springsecurity.model;

public enum UserProfileType {
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN"),
	TRANS("TRANS"),
	DOCT("DOCT"),
	HOPITTAL("HOPITTAL"),
	PATIENT("PATIENT");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
