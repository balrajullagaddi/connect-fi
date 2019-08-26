@Intelligence
Feature: Vehicle Card CF-6

Background: User is logging into the Forensic Investigation system

    Given User is on Card Index screen for a 'Create Generic Investigation'
	When User clicks on "Vehicle" card with Link Reason "" 

#Scenario 1
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario:  User  click on Vehicle card and than by  Searching the Vehicle Card , 
          adding the Vehicle Object Basic  details 
	
	Given user is on "Vehicle" card
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	When I click on "No,card not required" button
	Then the focus should be on the Main page
	
	
	Given user is on "Vehicle" card
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	Then the Object Basic Details search  form of Vehicle is displayed
	
Scenario: Search functionality for  VRM Type and VRM

	Given user is on the Object Basic Details search form of Vehicle
	When I enter "Full" as "VRM Type"
	And I select " 2002-21-0063" as "VRM"
	And click on "Next" button
	And I should get the data searched against pole database and displayed
	And click on the displayed record
	And the object editor for Basic details should be displayed
	And clear the "VRM Type"
	And clear the "VRM"
	And click on "Save & Return" button
	Then I should get the message "Please enter VRM Type"
	And I should get message "Please enter VRM"
	
Scenario: Search functionality for  Make and Model

	Given user is on the Object Basic Details search form of Vehicle
	When I enter "2011" as "Make"
	And I select "i10" as "Model"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
Scenario: Checking for Mandatory feild
	
    Given user is on "Vehicle" card
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Next" Button
	Then it should display message "Minimum data requirement not meet" 
	
	
    Given user is on Object Basic Details search  form of Vehicle 
	When I enter "Full" as "VRM Type"
	And I select " 2002-21-0063" as "VRM"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
Scenario:  Functionality for "Card Not Required" button

	Given user is on Vehicle card selection form
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Card Not Required" button
	Then the Card should be deleted and focus should be on the Main page
	
	
    Given user is on Vehicle card selection form
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Index" button
	Then the focus should be on the Main page
	
	
	
    Given user is on Vehicle card selection form 
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	And I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And click on the desired search result 
	Then the Vehicle template should be displayed in Read only mode
	And click on  "This is the Vehicle " button
	Then the focus will be on the Object Editor form Tab  "Basic Details" of Vehicle
	
	
	
Scenario: Add data in Vehicle Basic details,  Future Detail Tab and Examination Address and Yes for Country Of Registration
	
	Given user is on Vehicle card selection form 
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And click on the desired search result 
	And the Vehicle Template should be displayed in Read only mode
	And click on  "This is the Vehicle " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Vehicle
	And click on "Basic details" tab
	When I select "Full" as VRM Type
	And I enter " 2002-21-0063" in VRM
	And I select "2011" in Make
	And I select "i10" in Model
	And I enter "234" in Chassis Number
	And I select "Yes" in Examination Required?
	And click on "Future Details" tab
	And I select "Four wheeler" in Category
	And I select "Car" in Type
	And I select  "White" in Colour 1
	And I select  "White" in Colour 2
	And I enter "4889" in Engine Number
	And I enter "1.9" in Cubic Capacity
	And I select "Petrol" in Fuel Type
	And I select "2011" in Year Of Manufacturer
	And I eneter "details added" in Notes
	And I select "Yes" in Foreign Vehicle
	And I select "United Kingdom" in Country Of Registration
	And click on "Examination Address" Tab
	And I enter "Car Park" in Location Type
	And I enter "8988" in Number
	And I enter "Hill Town" in Premises Name
	And I enter "Bridgelon" in Flat
	And I enter "Bridgetone lane" in Address Line 1
	And I enter " lane 4" in Address Line 2
	And I enter "London" in Town
	And I enter " SW1A 2AA " in Postcode
	And I enter " UK " in County
	And click on "Save & Return" button
	Then the record should Save and displayed in the Grid as Vehicle card
	
	

Scenario: Add data in Vehicle Basic details,  Future Detail Tab and Examination Address and No for Country Of Registration
	
	Given user is on Vehicle card selection form 
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And click on the desired search result 
	And the Vehicle Template should be displayed in Read only mode
	And click on  "This is the Vehicle " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Vehicle
	And click on "Basic details" tab
	When I select "Full" as VRM Type
	And I enter " 2002-21-0063" in VRM
	And I select "2011" in Make
	And I select "i10" in Model
	And I enter "234" in Chassis Number
	And I select "No" in Examination Required?
	And click on "Future Details" tab
	And I select "Four wheeler" in Category
	And I select "Car" in Type
	And I select  "White" in Colour 1
	And I select  "White" in Colour 2
	And I enter "4889" in Engine Number
	And I enter "1.9" in Cubic Capacity
	And I select "Petrol" in Fuel Type
	And I select "2011" in Year Of Manufacturer
	And I eneter "details added" in Notes
	And I select "No" in Foreign Vehicle
	And click on "Examination Address" Tab
	And I enter "Car Park" in Location Type
	And I enter "8988" in Number
	And I enter "Hill Town" in Premises Name
	And I enter "Bridgelon" in Flat
	And I enter "Bridgetone lane" in Address Line 1
	And I enter " lane 4" in Address Line 2
	And I enter "London" in Town
	And I enter " SW1A 2AA " in Postcode
	And I enter " UK " in County
	And click on "Save & Return" button
	Then the record should Save and displayed in the Grid as Vehicle card

# Add new Vehicle

    Given user is on the Vehicle card Grid
    And click on "Add new Vehicle" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And click on "Basic details" tab
	When I select "Full" as VRM Type
	And I enter " 2002-21-0063" in VRM
	And I select "2011" in Make
	And I select "i10" in Model
	And I enter "234" in Chassis Number
	And I select "No" in Examination Required?
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid

	 
Scenario: Funtionality of "This is not the Location " button
	 
	Given user is on Vehicle card selection form 
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And click on the desired search result 
	And the Vehicle Template should be displayed in Read only mode
	And click on  "This is not the Vehicle " button
	Then the Focus goes back on the Vehicle location search form
	 
Scenario: Funtionality of "None of these  people are Vehicle" Button 
	 
	Given user is on Vehicle card selection form  
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And the search result are displayed
	And click on "None of these  people are Vehicle " Button 
	Then focus should be on the Vehicle Object Editor form "Basic Detail"
	
Scenario: Funtionality of No Search found in Pole database
	
	Given user is on Vehicle card selection form  
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And No search result found against the Pole database
	Then the focus will be on the Object Editor form of Vehicle
	
		
	# Edition  of the Card
	
Scenario: Funtionality of Edit 

    Given user is on the Vehicle card grid
    And click on saved Vehicle Card which is displayed in the grid
	And click on "Basic details" tab
	When I  update select "Partial" as VRM Type
	And I update " 2002-21-0064" in VRM
	And I  update select "20121" in Make
	And I update select "i10 sportz" in Model
	And I update "234" in Chassis Number
	And I update select "Yes" in Examination Required?
	And click on "Future Details" tab
	And I update select "Four wheeler" in Category
	And I update select "SUV" in Type
	And I update select  "White" in Colour 1
	And I update select  "Green" in Colour 2
	And I update "4883" in Engine Number
	And I update "1.4" in Cubic Capacity
	And I update select "Desiel" in Fuel Type
	And I update select "2010" in Year Of Manufacturer
	And I update "details added 1" in Notes
	And I update select "Yes" in Foreign Vehicle
	And I update select "United Kingdom" in Country Of Registration
	And click on "Examination Address" Tab
	And I update "Car Park avenue" in Location Type
	And I update "8988" in Number
	And I update "Hill way" in Premises Name
	And I update "Bridgestone" in Flat
	And I update "Bridgetone road" in Address Line 1
	And I update " lane 6" in Address Line 2
	And I update "London" in Town
	And I update " SW1A 2AB " in Postcode
	And I update " UK " in County
	And click on "Save & Return" button
	Then the record should Save and displayed in the Grid as Vehicle card
    	
	# Deleting the Vehicle card
	
	
Scenario: Funtionality of Deletion of the Card	

    Given user is on Vehicle card selection form  
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Card not Required" button
	Then Card details should get Deleted and the focus should go on the Main form
	
Scenario: Deletion of the card with added details	
	
	Given user is on Vehicle card selection form 
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And click on the desired search result 
	And the Vehicle Template should be displayed in Read only mode
	And click on  "This is the Vehicle " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Vehicle
	And click on "Basic details" tab
	When I select "Full" as VRM Type
	And I enter " 2002-21-0063" in VRM
	And I select "2011" in Make
	And I select "i10" in Model
	And I enter "234" in Chassis Number
	And I select "No" in Examination Required?
	And click on "Save & Return" button
	And the Record should Save and displayed in the grid
	And click on "Card not Required" button 
	Then Saved Card details should get deleted
	
	
Scenario: Funtionality of Cancel button 

	Given user is on Vehicle card selection form 
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Vehicle
	And click on "Delete Vehicle" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Vehicle "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "No , Cancel" button
	And the Popup should get close and the focus should be on Vehicle Object Editor form	
	
    Given user is on the Vehicle Object Editor form	
	When user click on "Delete Vehicle" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Vehicle "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "Yes,Remove"
	And the Card should be deleted 
	
Scenario: Click on Cross icon of the Popup message
	
    Given user is on Vehicle card selection form 
	And It will display "Are there any Vehicle " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I select "Full" as "VRM Type"
	And I enter " 2002-21-0063" as "VRM"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Vehicle
	And click on "Delete Vehicle" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Vehicle "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "cross" icon
	And the Popup should get close and the focus should be on Vehicle Object Editor form
	
	
		
	
	
