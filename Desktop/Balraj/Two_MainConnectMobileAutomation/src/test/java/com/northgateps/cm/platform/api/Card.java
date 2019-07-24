package com.northgateps.cm.platform.api;

import java.util.List;

public class Card {

	private String cardName;
	
	private List<CardPageObject> CardPageObjectList ;	
	
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public List<CardPageObject> getCardPageObjectList() {
		return CardPageObjectList;
	}

	public void setCardPageObjectList(List<CardPageObject> cardPageObjectList) {
		CardPageObjectList = cardPageObjectList;
	}

}
