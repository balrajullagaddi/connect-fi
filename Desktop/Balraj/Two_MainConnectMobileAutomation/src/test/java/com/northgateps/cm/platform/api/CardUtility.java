package com.northgateps.cm.platform.api;

/*
 * This function gets the fields for particular card, identifies the controltype
 * and passes the value based on it Parameter passed : card name Scope: This
 * function will be exposed to external objects out of the class. It is main
 * class
 */

import com.northgateps.cm.platform.api.CardEnum.By;
import com.northgateps.cm.platform.api.CardEnum.ControlType;

//import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CardUtility {

	// Constant declaration
	final static String FILENAME = "src/main/resources/configs/card_definitions.json";
	final static String LABEL = "label";
	final static String UNDERSCORE = "_";
	final static String NAMETEXT = "name";
	final static String WIDGETTYPE = "widgetType";
	final static String DATATYPE = "dataType";
	final static String POLEDATAITEMNAME = "poleDataItemName";
	final static String MAILPOLEOBJECTTYPE = "mainPoleObjectType";
	final static String LINKREASON = "linkReason";
	final static String DEFINITIONS = "definitions";
	final static String EVENTTYPE = "eventType";
	final static String OBJECTTYPE = "_type";
	final static String ACTION = "action";
	final static String CARDS = "cardDefinitions";
	final static String FORMS = "formDefinitions";
	final static String CONTENTS = "itemDefinitions";
	final static String GROUP = ".GroupDefinition";
	final static String HIDDEN = "hidden";
	final static String MODE = "mode";
	final static String READONLY = "readOnly";
	final static String VALIDATOR = "validators";
	final static String MULTIPLEENTRIES = "multipleEntries";
	final static String DISPLAYED = "Displayed";
	public final static String OPTIONAL = "Optional";
	final static String AVAILABLE = "Available";
	final static String REPEATINGGROUP = "RepeatingGroup";
	final static String GROUPTYPE = "groupType";
	final static String FORMGROUP = "formGroupDefinitions";
	// Variable declaration
	static String eventTypeText = null;
	static String cardNameText = null;
	static String cardLabelText = null;
	static String contentNameText = null;
	static String element = null;
	static String groupNameText = null;
	static String formNameText = null;
	static String tabNameText = null;
	static String actionText = null;
	static Object globalJsonObject = null;

	static WebElement webelement = null;
	static WebDriver driver = null;
	static List<CardPageObject> cardPageObjectList = new ArrayList<CardPageObject>();
	static CardPageObject cardPageObject;
	static Object jsonObject = null;
	static Properties properties;
	static boolean isVersionIdentical = false;
	public static String globalEventType = null;
	static String globalGroupType = null;
	static String globalGroupName = null;
	public static List<CardPageObject> globalCardPageObject = new ArrayList<CardPageObject>();
	

	/*
	 * This function gets the fields for particular card, identifies the controltype
	 * and passes the value based on it Parameter passed : card name Scope: This
	 * function will be exposed to external objects out of the class. It is main
	 * class
	 */
	public static void fillForm(String card, String event, WebDriver driver) throws IOException, ParseException {
		List<CardPageObject> objectList = null;
		ControlType control = null;
		String elementName = null;
		BufferedReader br = null;
		String line = "";
		String fieldValue = "";
		String csvCardName = "";
		int tab = 0;

		String endOfFile = getNameWithoutSpace("End");
		card = getNameWithoutSpace(card);
		event = getNameWithoutSpace(event);

		// Get list of fields on the card
//		objectList = getListOfCardPageObject(card, event);
		objectList = CardUtility.globalCardPageObject;

		// Get test data from csv file
		br = new BufferedReader(new FileReader("src/main/resources/TestData.csv"));
		while ((line = br.readLine()) != null) {

			// get value from csv file
			String[] strArray = line.split(",");

			if (strArray.length > 0 && strArray[0].length() > 0) {
				csvCardName = getNameWithoutSpace(strArray[0]);
				if (getNameWithoutSpace(strArray[0]).compareToIgnoreCase(endOfFile) == 0) {
					break;
				}
			}

			if (csvCardName.compareToIgnoreCase(card) == 0) {
				String field = getNameWithoutSpace(strArray[1]);
				if (strArray.length < 3) {
					fieldValue = "";
				} else {
					fieldValue = strArray[2];
				}

				// Get tab id
				if (strArray.length > 3 && strArray[3].length() > 0) {
					tab = Integer.parseInt(strArray[3]);
				}

				// Code to exit loop when tab switched from first tab
				if (tab > 1) {
					break;
				}

				// iterate object list and insert value in field
				for (CardPageObject cardPageObject : objectList) {
					elementName = cardPageObject.getName();
					if (elementName.endsWith(UNDERSCORE + field) && elementName.contains(card)) {
						control = cardPageObject.getControlType();
						switch (control) {
						case Date:
							Utility.enterDateTime(fieldValue, elementName, driver);
							break;
						case Time:
							elementName = UNDERSCORE + field;
							Utility.enterDateTime(fieldValue, elementName, driver);
							break;
						case DateTime:
							elementName = UNDERSCORE + field + UNDERSCORE + "date";
							Utility.enterDateTime(fieldValue, elementName, driver);
							elementName = UNDERSCORE + field + UNDERSCORE + "time";
							Utility.enterDateTime("00:00", elementName, driver);
							break;
						case TextBox:
							Utility.enterText(fieldValue, elementName, driver);
							break;
						case FreeText:
							Utility.enterText(fieldValue, elementName, driver);
							break;
						case Integer:
							Utility.enterText(fieldValue, elementName, driver);
							break;
						case InternalList:
							Utility.selectValueDropDown(fieldValue, elementName, driver);
							break;
						case Lookup:
							Utility.selectValueDropDown(fieldValue, elementName, driver);
							break;
						default:
							break;
						}
						break;
					}
				}
			}
		}
	}

	public List<String> getCardList(String event) {
		List<String> listOfCard = new ArrayList<String>();
		String eventText = "";
		String labelText = "";
		String nameText = "";
		String modeText = "";
		String mainPoleObjectType = "";
		String linkReason = "";

		JSONObject jsonObject = (JSONObject) globalJsonObject;
		JSONArray definitionsList = (JSONArray) jsonObject.get(DEFINITIONS);

		for (Object definitionObj : definitionsList) {
			eventText = ((JSONObject) definitionObj).get(EVENTTYPE).toString();
			if (eventText.compareToIgnoreCase(event) == 0) {
				JSONArray cardList = (JSONArray) ((JSONObject) definitionObj).get(CARDS);
				for (Object cardObj : cardList) {
					labelText = ((JSONObject) cardObj).get(LABEL).toString();
					nameText = ((JSONObject) cardObj).get(NAMETEXT).toString();
					mainPoleObjectType = ((JSONObject) cardObj).get(MAILPOLEOBJECTTYPE).toString();
					linkReason = ((JSONObject) cardObj).get(LINKREASON).toString();
					modeText = ((JSONObject) cardObj).get(MODE).toString();
					if (!modeText.equals("Available")) {

					}
					listOfCard.add(mainPoleObjectType + "," + linkReason + "," + labelText + "," + nameText + "," + modeText);
				}
				break;
			}
		}
		return listOfCard;
	}

	/*
	 * This function returns of the returns list of fields (in forms) for the given
	 * card. Argument passed : card name Scope: Within the class
	 */
	public static List<CardPageObject> getListOfCardPageObject(String cardProcessed, String eventSelected)
			throws IOException, ParseException {
		List<CardPageObject> cardPageObjects = null;
		Card card;

		try {
			// Find event type
			eventSelected = getNameWithoutSpace(globalEventType);

			JSONObject jsonObject = (JSONObject) globalJsonObject;
			JSONArray definitionsList = (JSONArray) jsonObject.get(DEFINITIONS);
			for (Object definitionObj : definitionsList) {
				eventTypeText = ((JSONObject) definitionObj).get(EVENTTYPE).toString();
				eventTypeText = getNameWithoutSpace(eventTypeText);
				eventTypeText = eventTypeText.replace("\t", "	");

				if (eventTypeText.trim().compareToIgnoreCase(eventSelected) == 0
						&& ((JSONObject) definitionObj).get(ACTION).toString().compareToIgnoreCase(actionText) == 0) {

					JSONArray cardList = (JSONArray) ((JSONObject) definitionObj).get(CARDS);
					for (Object cardObj : cardList) {
						card = new Card();
						cardNameText = ((JSONObject) cardObj).get(NAMETEXT).toString();
						cardNameText = getNameWithoutSpace(cardNameText);
						cardLabelText = ((JSONObject) cardObj).get(LABEL).toString();
						cardLabelText = getNameWithoutSpace(cardLabelText);

						if (cardLabelText.compareToIgnoreCase(cardProcessed) == 0) {
							if ((JSONArray) ((JSONObject) cardObj).get(FORMGROUP) != null) {
                                JSONArray formGroupData = (JSONArray) ((JSONObject) cardObj).get(FORMGROUP);
                                for (Object formGroupObject : formGroupData) {
                                    JSONArray formData = (JSONArray) ((JSONObject) formGroupObject).get(FORMS);
                                    for (Object formObj : formData) {
                                        formNameText = ((JSONObject) formObj).get(NAMETEXT).toString();
                                        formNameText = getNameWithoutSpace(formNameText);
                                        tabNameText = ((JSONObject) formObj).get(LABEL).toString();
                                        JSONArray contentData = (JSONArray) ((JSONObject) formObj).get(CONTENTS);
                                        cardPageObjects = getCardPageObject(contentData);
                                        List<CardPageObject> found = new ArrayList<CardPageObject>();
                                        for(CardPageObject item : cardPageObjects){
                                            if(!item.getCardName().equalsIgnoreCase(cardNameText)){
                                                found.add(item);
                                            }
                                        }
                                        cardPageObjects.removeAll(found);
                                        card.setCardPageObjectList(cardPageObjects);
                                    }
                                }
                            } else if ((JSONArray) ((JSONObject) cardObj).get(FORMS) != null) {
                                JSONArray formData = (JSONArray) ((JSONObject) cardObj).get(FORMS);
                                for (Object formObj : formData) {
                                    formNameText = ((JSONObject) formObj).get(NAMETEXT).toString();
                                    formNameText = getNameWithoutSpace(formNameText);
                                    tabNameText = ((JSONObject) formObj).get(LABEL).toString();
                                    JSONArray contentData = (JSONArray) ((JSONObject) formObj).get(CONTENTS);
                                    cardPageObjects = getCardPageObject(contentData);
                                    List<CardPageObject> found = new ArrayList<CardPageObject>();
                                    for(CardPageObject item : cardPageObjects){
                                        if(!item.getCardName().equalsIgnoreCase(cardNameText)){
                                            found.add(item);
                                        }
                                    }
                                    cardPageObjects.removeAll(found);
                                    card.setCardPageObjectList(cardPageObjects);
                                }
                            }
							break;
						}
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cardPageObjects;
	}

	/*
	 * This function returns content data inside the card Scope: Within the class
	 */
	private static List<CardPageObject> getCardPageObject(JSONArray contentData) {
		String widgetType = null;
		String dataType = null;
		String by = null;
		String label = null;
		String name = null;

		for (Object contentObj : contentData) {

			// code to check if object type is group
			if (((JSONObject) contentObj).get(OBJECTTYPE).toString().compareToIgnoreCase(GROUP) == 0) {
				groupNameText = ((JSONObject) contentObj).get(NAMETEXT).toString();
				groupNameText = getNameWithoutSpace(groupNameText);
				if (((JSONObject) contentObj).get(GROUPTYPE) != null && ((JSONObject) contentObj).get(GROUPTYPE)
						.toString().compareToIgnoreCase(REPEATINGGROUP) == 0) {
					globalGroupType = REPEATINGGROUP;
					globalGroupName = ((JSONObject) contentObj).get(LABEL).toString();
				}
			}

			// Add card object to list
			if (((JSONObject) contentObj).get(WIDGETTYPE) == null
					|| ((JSONObject) contentObj).get(POLEDATAITEMNAME) == null) {

				JSONArray childContentData = (JSONArray) ((JSONObject) contentObj).get(CONTENTS);
				getWidgetType(childContentData);
				groupNameText = null;
				globalGroupType = null;
				globalGroupName = null;
			} else {

				by = ((JSONObject) contentObj).get(POLEDATAITEMNAME).toString();
				widgetType = ((JSONObject) contentObj).get(WIDGETTYPE).toString();
				dataType = ((JSONObject) contentObj).get(DATATYPE).toString();
				label = ((JSONObject) contentObj).get(LABEL).toString();
				name = ((JSONObject) contentObj).get(NAMETEXT).toString();

				contentNameText = ((JSONObject) contentObj).get(POLEDATAITEMNAME).toString();
				contentNameText = getNameWithoutSpace(contentNameText);

				element = eventTypeText + UNDERSCORE + cardNameText + UNDERSCORE + formNameText + UNDERSCORE
						+ contentNameText;

				cardPageObject = getCardObject(widgetType, dataType, element, by, label, name, globalGroupType,
						globalGroupName, cardNameText, tabNameText);
				cardPageObjectList.add(cardPageObject);
			}
		}
		return cardPageObjectList;
	}

	/*
	 * This function sets name and control in card class Scope: Within the class
	 */
	private static CardPageObject getCardObject(String widgetType, String dataType, String elementName, String by,
			String label, String name, String groupType, String groupName, String cardName, String tabName) {
		CardPageObject cardPageObject = new CardPageObject();

		cardPageObject.setControlType(getPageControlType(widgetType));
		if (dataType.equalsIgnoreCase("DATE")) {
			cardPageObject.setName(name);
		} else {
			cardPageObject.setName(elementName);
		}
		cardPageObject.setBy(by);
		cardPageObject.setLabel(label);
		cardPageObject.setGroupType(groupType);
		cardPageObject.setGroupName(groupName);
		cardPageObject.setCardName(cardName);
		cardPageObject.setTabName(tabName);
		return cardPageObject;
	}

	/*
	 * This function returns the controltype Scope: Within the class
	 */
	private static ControlType getPageControlType(String widgetType) {
		ControlType controlType = null;
		switch (widgetType.toUpperCase()) {
		case "BOOLEAN":
			controlType = ControlType.Boolean;
			break;
		case "TODAYDATE":
			controlType = ControlType.Date;
			break;
		case "DATE":
			controlType = ControlType.Date;
			break;
		case "DATETIME":
			controlType = ControlType.DateTime;
			break;
		case "NOWTIME":
			controlType = ControlType.Time;
			break;
		case "INTEGER":
			controlType = ControlType.Integer;
			break;
		case "LONG":
			controlType = ControlType.Long;
			break;
		case "DECIMAL":
			controlType = ControlType.Decimal;
			break;
		case "TEXTBOX":
			controlType = ControlType.TextBox;
			break;
		case "FREETEXT":
			controlType = ControlType.FreeText;
			break;
		case "INTERNALLIST":
			controlType = ControlType.InternalList;
			break;
		case "RADIO":
			controlType = ControlType.Radio;
			break;
		case "SIGNATURECAPTURE":
			controlType = ControlType.SignatureCapture;
			break;
		case "UNIT_LOOKUP":
			controlType = ControlType.Lookup;
			break;
		default:
			controlType = null;
			break;
		}

		return controlType;
	}

	/*
	 * This function returns the pagetype Scope: Within the class
	 */
	private static By getPageBy(String byLocator) {
		By controlBy = null;

		switch (byLocator.toUpperCase()) {
		case "ID":
			controlBy = By.ID;
			break;
		case "NAME":
			controlBy = By.Name;
			break;
		case "CLASS":
			controlBy = By.Class;
			break;
		default:
			controlBy = null;
			break;
		}
		return controlBy;
	}

	/*
	 * This function returns the name of text truncating space and converting to
	 * lowercase Scope: Within the class
	 */
	public static String getNameWithoutSpace(String nameWithSpace) {
		String nameWithoutSpace = null;
		nameWithoutSpace = nameWithSpace.replaceAll(" ", "");
		nameWithoutSpace = nameWithoutSpace.toLowerCase();
		return nameWithoutSpace;
	}

	/*
	 * This function returns the widget type Scope: Within the class
	 */

	private static void getWidgetType(JSONArray childContentData) {
		String widgetType = "";
		String dataType = "";
		String by = "";
		String label = "";
		String name = "";
		
		for (Object childContentObj : childContentData) {
			boolean currentRecord = true;
			
			if (((JSONObject) childContentObj).get(OBJECTTYPE).toString().compareToIgnoreCase(GROUP) == 0) {
				
				if (((JSONObject) childContentObj).get(GROUPTYPE) != null && ((JSONObject) childContentObj).get(GROUPTYPE)
						.toString().compareToIgnoreCase(REPEATINGGROUP) == 0) {
					globalGroupType = ((JSONObject) childContentObj).get(GROUPTYPE).toString();
					globalGroupName = ((JSONObject) childContentObj).get(LABEL).toString();
				}
				
				JSONArray subChildContentData = (JSONArray) ((JSONObject) childContentObj).get(CONTENTS);
				if (isContentExists(subChildContentData)) {
					String subgroupNameText = ((JSONObject) childContentObj).get(NAMETEXT).toString();
					subgroupNameText = getNameWithoutSpace(subgroupNameText);
					groupNameText = groupNameText + UNDERSCORE + subgroupNameText;
					getWidgetType(subChildContentData);
					currentRecord = false;
					groupNameText = groupNameText.substring(0, groupNameText.lastIndexOf(UNDERSCORE));
					globalGroupType = null;
					globalGroupName = null;
				}
			}

			if (currentRecord) {
				widgetType = (((JSONObject) childContentObj).get(WIDGETTYPE)==null) ? "" : ((JSONObject) childContentObj).get(WIDGETTYPE).toString();
				dataType = (((JSONObject) childContentObj).get(DATATYPE)==null) ? "" : ((JSONObject) childContentObj).get(DATATYPE).toString();
				by = (((JSONObject) childContentObj).get(POLEDATAITEMNAME)==null) ? "" : ((JSONObject) childContentObj).get(POLEDATAITEMNAME).toString();
				label = (((JSONObject) childContentObj).get(LABEL)==null) ? "" : ((JSONObject) childContentObj).get(LABEL).toString();
				name = (((JSONObject) childContentObj).get(NAMETEXT)==null) ? "" : ((JSONObject) childContentObj).get(NAMETEXT).toString();

				contentNameText = by;
				contentNameText = getNameWithoutSpace(contentNameText);

				if (dataType.equals("TIME")) {
					
					element = UNDERSCORE + getNameWithoutSpace(by);
					
				} else if (((JSONObject) childContentObj).get(OBJECTTYPE).toString().compareToIgnoreCase(GROUP) == 0) {
					
					String subgroupNameText = ((JSONObject) childContentObj).get(NAMETEXT).toString();
					subgroupNameText = getNameWithoutSpace(subgroupNameText);
					
					element = eventTypeText + UNDERSCORE + cardNameText + UNDERSCORE + groupNameText + UNDERSCORE + subgroupNameText + UNDERSCORE
							+ formNameText + UNDERSCORE + contentNameText;
				} 
				else {
					
					element = eventTypeText + UNDERSCORE + cardNameText + UNDERSCORE + groupNameText + UNDERSCORE
							+ formNameText + UNDERSCORE + contentNameText;
				}

				cardPageObject = getCardObject(widgetType, dataType, element, by, label, name, globalGroupType,
						globalGroupName, cardNameText, tabNameText);
				cardPageObjectList.add(cardPageObject);
			}
		}
		
	}

	public static List<String> getCardFieldList(String event, String card) {
		List<String> fieldList = new ArrayList<String>();
		String action = "";
		JSONObject jsonObject = (JSONObject) globalJsonObject;
		JSONArray definitionsList = (JSONArray) jsonObject.get(DEFINITIONS);
		for (Object definitionObj : definitionsList) {
			eventTypeText = ((JSONObject) definitionObj).get(EVENTTYPE).toString();
			action = ((JSONObject) definitionObj).get(ACTION).toString();
			if (eventTypeText.compareToIgnoreCase(event) == 0 && action.compareToIgnoreCase(actionText) == 0) {
				JSONArray cardList = (JSONArray) ((JSONObject) definitionObj).get(CARDS);
				for (Object cardObj : cardList) {
					cardNameText = ((JSONObject) cardObj).get(NAMETEXT).toString();
					if (cardNameText.compareToIgnoreCase(card) == 0) {
						JSONArray formData = (JSONArray) ((JSONObject) cardObj).get(FORMS);
						for (Object formObj : formData) {
							JSONArray contentData = (JSONArray) ((JSONObject) formObj).get(CONTENTS);
							for (Object contentObj : contentData) {
								if (((JSONObject) contentObj).get(POLEDATAITEMNAME) == null) {
									JSONArray childContentData = (JSONArray) ((JSONObject) contentObj).get(CONTENTS);
									for (Object childContentObj : childContentData) {
										if (((JSONObject) childContentObj).get(POLEDATAITEMNAME) == null) {
											JSONArray subChildContentData = (JSONArray) ((JSONObject) childContentObj)
													.get(CONTENTS);
											for (Object subChildContentObj : subChildContentData) {
												fieldList.add(getListValues(subChildContentObj));
											}
										} else {
											fieldList.add(getListValues(childContentObj));
										}
									}
								} else {
									fieldList.add(getListValues(contentObj));
								}
							}
						}
						break;
					}
				}
				break;
			}
		}
		return fieldList;
	}

	/*
	 * This function will return string with status of readonly, mandatory, multiple
	 * and controltype
	 */
	private static String getListValues(Object jsonObj) {
		String field = "";
		String readonly = "";
		String mandatory = "";
		String multiple = "";
		String controlType = "";
		String fieldValues = "";

		field = ((JSONObject) jsonObj).get(POLEDATAITEMNAME).toString();

		if (((JSONObject) jsonObj).get(READONLY) != null) {
			if (((JSONObject) jsonObj).get(READONLY).toString().compareToIgnoreCase("false") == 0) {
				readonly = "no";
			} else {
				readonly = "yes";
			}
		}

		if (((JSONObject) jsonObj).get(VALIDATOR) != null) {
			if (((JSONObject) jsonObj).get(VALIDATOR).toString().compareToIgnoreCase("[]") == 0) {
				mandatory = "no";
			} else {
				mandatory = "yes";
			}
		}

		if (((JSONObject) jsonObj).get(MULTIPLEENTRIES) != null) {
			multiple = "yes";
		} else {
			multiple = "no";
		}

		if (((JSONObject) jsonObj).get(WIDGETTYPE) != null) {
			controlType = ((JSONObject) jsonObj).get(WIDGETTYPE).toString();
		}

		fieldValues = field + "," + readonly + "," + mandatory + "," + multiple + "," + controlType;

		return fieldValues;
	}

	// Adding following code for returning element name
	public String getElementName(String card, String tab, String event, String label) {
		String elementName = null;
		String labelName = null;
		String field = null;
		String cardName = "";
		String tabName = "";
		List<CardPageObject> objectList = null;

		try {
			card = getNameWithoutSpace(card);
			event = getNameWithoutSpace(event);
			label = label.trim().toUpperCase();

			// Get list of fields on the card
			objectList = CardUtility.globalCardPageObject;

			// iterate object list and insert value in field
			for (CardPageObject cardPageObject : objectList) {
				elementName = cardPageObject.getName();
				labelName = cardPageObject.getLabel().trim().toUpperCase();
				cardName = cardPageObject.getCardName();
				tabName = cardPageObject.getTabName();

				if (label.compareTo(labelName) == 0) {
					if (cardPageObject.getControlType() == ControlType.Date) {
						field = elementName;
						break;
					}
					if (cardPageObject.getControlType() == ControlType.Boolean) {
						field = label;
						break;
					}
					
					if (tab != null) {
						if (cardName.equalsIgnoreCase(card) && elementName.contains(card) && tab.equalsIgnoreCase(tabName)) {
							field = elementName;
							break;
						}
						
					} else if (cardName.equalsIgnoreCase(card) && elementName.contains(card)) {
						field = elementName;
						break;
					} 
					
					if (elementName.startsWith("_")) {
						field = getNameWithoutSpace(elementName);
						break;
					}
				}
			}
		} catch (Exception e) {
			throw(e);
		}
		return field;

	}
	
	// Adding following code for returning element name for repeating group
	public String getElementNameForGroup(String card, String tab, String event, String label) {
		String elementName = null;
		String labelName = null;
		String field = null;
		String groupName = null;
		String cardName = "";
		String tabName = "";
		List<CardPageObject> objectList = null;

		try {
			card = getNameWithoutSpace(card);
			event = getNameWithoutSpace(event);
			label = label.trim().toUpperCase();

			// Get list of fields on the card
			objectList = CardUtility.globalCardPageObject;
			
			// iterate object list and insert value in field
			for (CardPageObject cardPageObject : objectList) {
				elementName = cardPageObject.getName();
				labelName = cardPageObject.getLabel().trim().toUpperCase();
				cardName = cardPageObject.getCardName();
				tabName = cardPageObject.getTabName();
				groupName = cardPageObject.getGroupName();

				if(groupName!=null) {
					if (label.compareTo(labelName) == 0) {
						if (cardPageObject.getControlType() == ControlType.Date) {
							field = elementName;
							break;
						}
						if (cardPageObject.getControlType() == ControlType.Boolean) {
							field = label;
							break;
						}
						if (tab != null) {
							if (cardName.equalsIgnoreCase(card) && elementName.contains(card) && tab.equalsIgnoreCase(tabName)) {
								field = elementName;
								break;
							}
						} else if (cardName.equalsIgnoreCase(card) && elementName.contains(card)) {
							field = elementName;
							break;
						} 
						if (elementName.startsWith("_")) {
							field = getNameWithoutSpace(elementName);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}

	// Return group name for repeating group
	public String getGroupName(String card, String tab, String event, String  label) throws IOException, ParseException {
		String labelName = null;
		String groupName = null;
		String groupType = null;
		String cardName = "";
		String tabName = "";
		List<CardPageObject> objectList = null;

		card = getNameWithoutSpace(card);
		event = getNameWithoutSpace(event);
		label = label.trim().toUpperCase();

		// Get list of fields on the card
		objectList = CardUtility.globalCardPageObject;

		for (CardPageObject cardPageObject : objectList) {
			labelName = cardPageObject.getLabel().trim().toUpperCase();
			groupName = cardPageObject.getGroupName();
			groupType = cardPageObject.getGroupType();
			cardName = cardPageObject.getCardName();
			tabName = cardPageObject.getTabName();

			if(tab == null) {
				if (label.compareTo(labelName) == 0 && cardName.equalsIgnoreCase(card)) {
					if (groupType != null && groupType.equalsIgnoreCase(REPEATINGGROUP)) {
						return groupName;
					}
					break;
				}
			} else
				if (label.compareTo(labelName) == 0 && cardName.equalsIgnoreCase(card) && tabName.equalsIgnoreCase(tab)) {
					if (groupType != null && groupType.equalsIgnoreCase(REPEATINGGROUP)) {
						return groupName;
					}
					break;
				}
		}

		return null;
	}

	public void setAction(String action) {
		actionText = action;
	}

	public void setEventType(String eventType) {
		globalEventType = eventType;
	}

	public void setJsonOject(Object jsonObj) {
		globalJsonObject = jsonObj;
	}

	public int getMaxNoOfObject(String card) {
		int maxNoOfObject = 0;
		String linkReason = "";

		try {
			JSONObject jsonObject = (JSONObject) globalJsonObject;
			JSONArray definitionsList = (JSONArray) jsonObject.get(DEFINITIONS);
			mainLoop: for (Object definitionObj : definitionsList) {
				eventTypeText = ((JSONObject) definitionObj).get(EVENTTYPE).toString();
				eventTypeText = getNameWithoutSpace(eventTypeText);

				if (eventTypeText.compareToIgnoreCase(getNameWithoutSpace(globalEventType)) == 0
						&& ((JSONObject) definitionObj).get(ACTION).toString().compareToIgnoreCase(actionText) == 0) {
					JSONArray cardList = (JSONArray) ((JSONObject) definitionObj).get(CARDS);
					for (Object cardObj : cardList) {
						linkReason = ((JSONObject) cardObj).get(LINKREASON).toString();
						linkReason = getNameWithoutSpace(linkReason);

						cardNameText = ((JSONObject) cardObj).get(NAMETEXT).toString();
						cardNameText = getNameWithoutSpace(cardNameText);

						card = getNameWithoutSpace(card);

						if (cardNameText.compareToIgnoreCase(card) == 0
								&& ((JSONObject) cardObj).get("maxNumberOfObjects") != null) {
							maxNoOfObject = Integer
									.parseInt(((JSONObject) cardObj).get("maxNumberOfObjects").toString());
							break mainLoop;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNoOfObject;
	}

	public String cardMode(String cardName) {
		String cardMode = "";
		try {
			cardName = getNameWithoutSpace(cardName);

			JSONObject jsonObject = (JSONObject) globalJsonObject;
			JSONArray definitionsList = (JSONArray) jsonObject.get(DEFINITIONS);
			mainLoop: for (Object definitionObj : definitionsList) {
				eventTypeText = ((JSONObject) definitionObj).get(EVENTTYPE).toString();
				eventTypeText = getNameWithoutSpace(eventTypeText);

				if (eventTypeText.compareToIgnoreCase(getNameWithoutSpace(globalEventType)) == 0
						&& ((JSONObject) definitionObj).get(ACTION).toString().compareToIgnoreCase(actionText) == 0) {
					JSONArray cardList = (JSONArray) ((JSONObject) definitionObj).get(CARDS);
					for (Object cardObj : cardList) {
						cardNameText = ((JSONObject) cardObj).get(NAMETEXT).toString();
						cardNameText = getNameWithoutSpace(cardNameText);
						if (cardNameText.compareToIgnoreCase(cardName) == 0) {
							cardMode = ((JSONObject) cardObj).get(MODE).toString();
							break mainLoop;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cardMode;
	}
	
	private static boolean isContentExists(JSONArray childContentData) {
		try {
			for (Object childContentObj : childContentData) {
				if (((JSONObject) childContentObj).get(OBJECTTYPE)!=null)
					break;
			}
			return true;
		}catch(Exception e) {		
			return false;
		}
	}
		
}