@Intelligence
Feature: Incident Location CF-6

Background: User is logging into the Forensic Investigation system

    Given user is on Card Index screen for a 'Create intelligence report' 
	When user clicks on "Incident Location" card with Link Reason "" 


#Scenario 1
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario: User should be able to map the Incident Location to the New Forensic Investigation
          by Searching the Location in the Pole database ,Adding data 
          
	Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	When I click on "No,card not required" button
	Then the focus should be on the Main page
	
	# Examination Required is Yes
	
	Given user is on Incident Location card selection form
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "UK129" as "Number"
	And the Object Basic Details form of Incident Location is displayed
	And click on the desired search result 
	And the Incident Location Template should be displayed in Read only mode
	And click on  "This is the Location " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Incident Location
	And I enter "Cycle Path" in Location Type
	And I enter "3456" in Number
	And I enter "Hill Road " in Premises Name
	And I enter "Heritage" in Flat
	And I enter "Address 1" in Address Line 1
	And I enter "Address 2" in Address Line 2
	And I enter "Liverpool" in Town
	And I enter "SW15 5PU" in Postcode
	And I enter "County 23" in County
	And I select "Yes" as Examination Required?
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid
	
	
Scenario: Adding Blank data 
	
    Given user is on Incident Location card selection form
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Next" Button
	Then it should display message "Minimum data requirement not meet" 
	
Scenario: Adding Special char

    Given user is on Incident Location card selection form
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "UK129" as "Number"
	And the Object Basic Details form of Incident Location is displayed
	And click on the desired search result 
	And the Incident Location Template should be displayed in Read only mode
	And click on  "This is the Location " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Incident Location
	And I select  "Cycle Path" in Location Type
	And I enter "!@#$%^'" in Number
	And I enter "!@#$%^' " in Premises Name
	And I enter "!@#$%^'" in Flat
	And I enter "!@#$%^'" in Address Line 1
	And I enter "!@#$%^'" in Address Line 2
	And I enter "!@#$%^'" in Town
	And I enter "!@#$%^'" in Postcode
	And I enter "!@#$%^'" in County
	And I select "Yes" as Examination Required?
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid
	

	
Scenario: Search Creteria for Location type , Number and  Address Line 1
	
    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "UK129" as "Number"
	And I enter "1 Hamstrang street" as "Address Line 1"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
Scenario: Search Creteria for Location type , Name  and  Address Line 1
	
	Given user is on Incident Location card selection form
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "Hallmark" as "Premises Name"
	And I enter "1 Hamstrang street" as "Address Line 1"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
Scenario: Search Creteria for Location type and Postcode
	
    Given user is on Incident Location card selection form
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 5PU" as "Postcode"
	And click on "Card Not Required" button
	Then the Card should be deleted and focus should be on the Main page
	
	
Scenario: Index button
	
    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I click on "Index" button
	Then the focus should be on the Main page
	    
Scenario: Examination Required is No
	
    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 5PU" as "Postcode"
	And click on "Next" button
	And click on the desired search result 
	And the Incident Location Template should be displayed in Read only mode
	And click on  "This is the Location " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Incident Location
	And I enter "Court way" in Location Type
	And I enter "4566" in Number
	And I enter "Hill Road " in Premises Name
	And I enter "Heritage" in Flat
	And I enter "Address 11" in Address Line 1
	And I enter "Address 12" in Address Line 2
	And I enter "Liverpool" in Town
	And I enter "SW15 5PU" in Postcode
	And I enter "County 23" in County
	And I select "No" as Examination Required?
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid of Incident Location
	
	
Scenario: "Add new incident location" button
	 
    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 5PU" as "Postcode"
	And click on "Next" button
	And click on the desired search result 
	And the Incident Location Template should be displayed in Read only mode
	And click on  "This is the Location " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Incident Location
	And click on "Save & Return" button
	And the focus will be on the grid of Incident Location
	And click on "Add new incident location" button
	Then the focus will be on the incident location search form
	
Scenario: "This is not the Location " button

    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 5PU" as "Postcode"
	And click on "Next" button
	And click on the desired search result 
	And the Incident Location Template should be displayed in Read only mode
	And click on  "This is not the Location " button
	Then the Focus goes back on the incident location search form
	
Scenario:  Cancel button	

    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 5PU" as "Postcode"
	And click on "Next" button
	And desired search result are displayed
	And click on "Cancel" button
	Then the focus will be on the incident location search form
	
Scenario: "None of these  Location are Location " Button 
	
    Given user is on Incident Location card selection form  
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 5PU" as "Postcode"
	And click on "Next" button
	And the search result are displayed
	And click on "None of these  Location are Location " Button 
	Then focus should be on the Incident Location Object Editor form "Basic Detail"
	


Scenario: No Search result	
	
	Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 6PU" as "Postcode"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Incident Location
	And I enter "Court way" in Location Type
	And I enter "4566" in Number
	And I enter "Hill Road " in Premises Name
	And I enter "Heritage" in Flat
	And I enter "Address 11" in Address Line 1
	And I enter "Address 12" in Address Line 2
	And I enter "Liverpool" in Town
	And I enter "SW15 5PU" in Postcode
	And I enter "County 23" in County
	And I select "No" as Examination Required?
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid of Incident Location
	
Scenario:  Multiple Incident Location

    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 5PU" as "Postcode"
	And click on "Next" button
	And click on the desired search result 
	And the Incident Location Template should be displayed in Read only mode
	And click on  "This is the Location " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Incident Location
	And click on "Save & Return" button
	And the focus will be on the grid of Incident Location
	And click on "Add new incident location"
	And the focus will be on the incident location search form
    And I enter "United Kingdom" as "Location type"
	And I enter "SW15 7PU" as "Postcode"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Incident Location
	And I enter "Court way" in Location Type
	And I enter "4566" in Number
	And I enter "Hill Road " in Premises Name
	And I enter "Heritage" in Flat
	And I enter "Address 11" in Address Line 1
	And I enter "Address 12" in Address Line 2
	And I enter "Liverpool" in Town
	And I enter "SW15 5PU" in Postcode
	And I enter "County 23" in County
	And I select "No" as Examination Required?
	And click on "Save & Return" button
	Then the Incident location grid will display Multiple records
	
	
Scenario: Edit
	
	Given user is on Incident Location card selection form  
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 6PU" as "Postcode"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Incident Location
	And I enter "Court way" in Location Type
	And I enter "4566" in Number
	And I enter "Hill Road " in Premises Name
	And I enter "Heritage" in Flat
	And I enter "Address 11" in Address Line 1
	And I enter "Address 12" in Address Line 2
	And I enter "Liverpool" in Town
	And I enter "SW15 5PU" in Postcode
	And I enter "County 23" in County
	And I select "No" as Examination Required?
	And click on "Save & Return" button
	And the Record should Save and displayed in the grid of Incident Location
	And click on the Saved record
	Then the record will be available for Edit
	And I update "Court " in Location Type
	And I update "566" in Number
	And I update "Hill way " in Premises Name
	And I update "Hamalton" in Flat
	And I update "Address 32" in Address Line 1
	And I update "Address 40" in Address Line 2
	And I update "London" in Town
	And I update "SW15 5PU" in Postcode
	And I update "County 56" in County
	And I select "No" as Examination Required?
	And click on "Save & Return" button
	And the Record should Save and displayed in the grid of Incident Location
	
Scenario: "Card not Required" button 
	
    Given user is on Incident Location card selection form 
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 6PU" as "Postcode"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Incident Location
	And I enter "Court way" in Location Type
	And I enter "4566" in Number
	And I enter "Hill Road " in Premises Name
	And I enter "Heritage" in Flat
	And I enter "Address 11" in Address Line 1
	And I enter "Address 12" in Address Line 2
	And I enter "Liverpool" in Town
	And I enter "SW15 5PU" in Postcode
	And I enter "County 23" in County
	And I select "No" as Examination Required?
	And click on "Save & Return" button
	And the Record should Save and displayed in the grid of Incident Location
	And click "Card not Required" button 
	Then the saved card details should be deleted
	
Scenario: Deleting the Saved card
	
	
	Given user is on Incident Location card selection form  
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 8PU" as "Postcode"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Incident Location
	And click on "Delete Incident Location "  button 
	And the A Warning message popup should be displayed "Are you Sure you want to Remove the Location"
	And  "No, Cancel" and "Yes,Remove" button are displayed
	And click on "Yes,Remove" button
	Then the displayed record will be deleted
	
Scenario: "Delete Incident Location "  button 
	
	Given user is on Incident Location card selection form  
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 8PU" as "Postcode"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Incident Location
	And click on "Delete Incident Location "  button 
	And the A Warning message popup should be displayed "Are you Sure you want to Remove the Location"
	And  "No, Cancel" and "Yes,Remove" button are displayed
	And click on "No,Cancel" button
	Then popup should get close and the Focus should be on the Incident Location Object Editor form
	
Scenario: Cancel button
	
	Given user is on Incident Location card selection form 	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "United Kingdom" as "Location type"
	And I enter "SW15 8PU" as "Postcode"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Incident Location
	And click on "Delete Incident Location "  button 
	And the A Warning message popup should be displayed "Are you Sure you want to Remove the Location"
	And  "No, Cancel" and "Yes,Remove" button are displayed
	And click on "cross" Icon of the popup
	Then popup should get close and the Focus should be on the Incident Location Object Editor form
	
	
	Given user is on Incident Location Object Editor form
	When user click on "Delete Incident Location " button
	And the A Warning message popup should be displayed "Are you Sure you want to Remove the Location"
	And  "No, Cancel" and "Yes,Remove" button are displayed
	And click on "Yes,Remove" button
	Then the displayed record will be deleted
	
 
	 