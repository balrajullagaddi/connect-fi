package com.northgateps.cm.platform.api;
/*
This class will have enums related to card page object 
*/
public class CardEnum {	
	
	public enum By {
		ID, 
		Name, 
		Class
	}
	
	public enum ControlType {
		Boolean, 
		Date, 
		DateTime, 
		Time, 
		Integer, 
		Long, 
		Decimal, 
		Currency, 
		TextBox, 
		Lookup, 
		FreeText, 
		InternalList, 
		Radio, 
		SignatureCapture, 
		ImageCapture
	}
}
