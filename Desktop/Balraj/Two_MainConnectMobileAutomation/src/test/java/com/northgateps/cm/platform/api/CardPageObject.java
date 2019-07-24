package com.northgateps.cm.platform.api;

import com.northgateps.cm.platform.api.CardEnum.ControlType;
import org.openqa.selenium.WebDriver;
// JSON CARDS 
/*
This class will have enums related to card page object 
*/
public class CardPageObject {
	public static WebDriver webDriver;
	
	private String name;
	private String validationMessage;
	private String label;
	private String mainPoleObjectType;	
	private String by;	
	private ControlType controlType;
	private String groupType;
	private String groupName;
	private String cardName;
	private String tabName;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBy() {
		return by;
	}
	
	public void setBy(String by) {
		this.by = by;
	}
	
	public ControlType getControlType() {
		return controlType;
	}
	
	public void setControlType(ControlType controlType) {
		this.controlType = controlType;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMainPoleObjectType() {
		return mainPoleObjectType;
	}

	public void setMainPoleObjectType(String mainPoleObjectType) {
		this.mainPoleObjectType = mainPoleObjectType;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
}
