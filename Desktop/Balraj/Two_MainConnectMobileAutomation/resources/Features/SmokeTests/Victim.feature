@Intelligence
Feature: Victim Card CF-6

Background: User is logging into the Forensic Investigation system

    Given User is on Card Index screen for a 'Create Generic Investigation'
	When User clicks on "Victim" card with Link Reason "" 

#Scenario 1
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario:  User  click on Victim card and than by  Searching the Victim Card , 
          adding the Victim Object Basic  details 
	
	Given user is on "Victim" card
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	When I click on "No,card not required" button
	Then the focus should be on the Main page
	
	
	Given user is on "Victim" card
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	Then the Object Basic Details search  form of Victim is displayed
	
Scenario: Search for Surname and Gender

	Given user is on the Object Basic Details search form of Victim
	When I enter "Rohan" as "Surname"
	And I select "Male" as "Gender"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 

Scenario: Search for Forename 1 and Gender

	Given user is on the Object Basic Details search form of Victim
	When I enter "Rodricks" as "Forename 1"
	And I select "Male" as "Gender"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 

	
Scenario: Checking for Mandatory feild
	
    Given user is on "Victim" card
	And It will display "Are there any Location " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Next" Button
	Then it should display message "Minimum data requirement not meet" 
	
	
    Given user is on Object Basic Details search  form of Victim 
	When I enter "Rohan" as "Forename 1"
	And I select "Male" as "Gender"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
Scenario:  For  "Card Not Required" button

	Given user is on Victim card selection form
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I enter "Rohan" as "Surname"
	And I select "Male" as "Gender"
	And click on "Card Not Required" button
	Then the Card should be deleted and focus should be on the Main page
	
	
    Given user is on Victim card selection form
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Index" button
	Then the focus should be on the Main page
	
	
	
    Given ser clicks on "Victim" card with Link Reason "" 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	And I enter "Rohan" as "Surname"
	And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	Then the Victim template should be displayed in Read only mode
	And click on  "This is the Victim " button
	Then the focus will be on the Object Editor form Tab  "Basic Details" of victim
	
Scenario: 	Unknown Victim = "Yes"

	
	Given user is on Victim card selection form
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim template should be displayed in Read only mode
	And I click on "Yes" on Unknown Victim
	And click on "Save & Return" button
	Then no need to enter any Basic details , Future Details , Home address and Examination address
	
	
	

Scenario:  Unknown Victim = "No" , Date of Birth selection
	 
    Given user is on Victim card selection form
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And I click on "No" on Unknown Victim
	And I enter "John" in Surname
	And I enter "Raymond " in Forename 1
	And I enter "York" in Forename 2
	And I select "Male" in Gender
	And I enter "01/01/1982" in Date of Birth
	And I enter "45666" in PNC ID
	And I enter "123456/19/A" in CRO
	And I enter "9820000000" in Mobile
	And I enter "22333393" in Landline
	And I enter "john@yahoo.com" in Email
	And I click "Yes" in Examination Required?
	And I click "Yes" in Examination Required?
	And I click "Yes" as Is Examination Address same as Home Address?
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid

# Unknown Victim = "Yes" and Age from and Age to and Add New Victim

    Given user is on the Victim card Grid
    And click on "Add new Victim" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And I click on "No" on Unknown Victim
	And I enter "John" in Surname
	And I enter "Raymond " in Forename 1
	And I enter "York" in Forename 2
	And I select "Male" in Gender
	And I select "Male" in Gender
	And I enter "25" in Age from
	And I enter "30" in Age To
	And I enter "20" in Estimated age
	And I enter "45666" in PNC ID
	And I enter "123456/19/A" in CRO
	And I enter "9820000000" in Mobile
	And I enter "22333393" in Landline
	And I enter "john@yahoo.com" in Email
	And I click "No" in Examination Required?
	And I click "No" as Is Examination Address same as Home Address?
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid

	
Scenario:  Validation for Date of Birth if added as Future date 
	
	Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And I click on "No" on Unknown Victim
	And I enter "John" in Surname
	And I enter "Raymond " in Forename 1
	And I enter "York" in Forename 2
	And I select "Male" in Gender
	And I enter "01/01/2020" in Date of Birth
	And I enter "45666" in PNC ID
	And I enter "123456/19/A" in CRO
	And I enter "9820000000" in Mobile
	And I enter "22333393" in Landline
	And I enter "john@yahoo.com" in Email
	And I click "Yes" in Examination Required?
	And I click "Yes" in Examination Required?
	And I click "Yes" as Is Examination Address same as Home Address?
	And click on "Save & Return" button
	Then I should get the validation message "Date of Birth cannot be of Future"
	
	
	# Verifying when we enter the Age From Greater than Age To and click on Save & Return button
	
	Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And I click on "No" on Unknown Victim
	And I enter "John" in Surname
	And I enter "Raymond " in Forename 1
	And I enter "York" in Forename 2
	And I select "Male" in Gender
	And I enter "01/01/2020" in Date of Birth
	Then I should get the message "Age From date cannot be Greater than Age To date"
	
	
Scenario: Validation for CRO Number

#When we enter Less digit in the First 6 digit slot 

    Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And I click on "No" on Unknown Victim
	And I enter "John" in Surname
	And I enter "Raymond " in Forename 1
	And I enter "York" in Forename 2
	And I select "Male" in Gender
	And I enter "01/01/1982" in Date of Birth
	And I enter "45666" in PNC ID
	And I enter "12345/78/B" in CRO
	And I enter "9820000000" in Mobile
	And I enter "22333393" in Landline
	And I enter "john@yahoo.com" in Email
	And I click "Yes" in Examination Required?
	And I click "Yes" in Examination Required?
	And I click "Yes" as Is Examination Address same as Home Address?
	And click on "Save & Return" button
	Then I should recive message "Enter CRO number in proper format"

# When we enter More digit in the First 6 digit slot

    Given user is on Victim card
    When I enter "1234567/78/B" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    
  # When we enter a char in the First 6 digit slot
  
    Given user is on Victim card
    When I enter "12D456/78/B" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
	
	# When we enter Less digit in the Second 2 digit slot
	
	Given user is on Victim card
    When I enter "123456/8/B" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
	 
	# When we enter More digit in the Second 2 digit slot
	
    Given user is on Victim card
    When I enter "1234567/978/B" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter a char in the Second 2 digit slot
    
    Given user is on Victim card
    When I enter "12D4567/W8/B" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter the future Year for  Second 2 digit slot
    
    Given user is on Victim card
    When I enter "12D4567/21/B" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
         
	
	# When we keep CRO number format char in Lower case  for Third slot
	
    Given user is on Victim card
    When I enter "123456/78/b" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
     	
     	
     # When we enter Digit in the  Third slot
    
    Given user is on Victim card
    When I enter "123456/78/2" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
      
    # When we enter Upper case char in Multiple in the  Third slot
    
    Given user is on Victim card
    When I enter "123456/78/AA" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter "I " in Third slot
    
    Given user is on Victim card
    When I enter "123456/78/I" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter " O " in Third slot
    
    Given user is on Victim card
    When I enter "123456/78/O" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter " S " in Third slot
    
    Given user is on Victim card
    When I enter "123456/78/S" in CRO
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
          
         
         
         
	
Scenario: Add data in  Future Detail Tab, Home Address and Examination Address
	
	Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And click on "Future Details" tab
	And enter "Details" in Notes
	And click on "Home Address" tab
	And I enter "Shop" in Location Type
	And I enter "345" in Number
	And I enter "Hill Town" in Premises Name
	And I enter "Bridgetone" in Flat
	And I enter "Bridgetone lane" in Address Line 1
	And I enter " lane 4" in Address Line 2
	And I enter "London" in Town
	And I enter " SW1A 2AA " in Postcode
	And I enter " UK " in County
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
	Then the record should Save and displayed in the Grid as Victim card
	
	 
Scenario: "This is not the Location " button
	 
	Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Victim Template should be displayed in Read only mode
	And click on  "This is not the Victim " button
	Then the Focus goes back on the Victim location search form
	 
Scenario:  "None of these  people are Victim" Button click 
	 
	Given user is on Victim card selection form  
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And the search result are displayed
	And click on "None of these  people are Victim " Button 
	Then focus should be on the Victim Object Editor form "Basic Detail"
	
Scenario:  No Search found in Pole database
	
	Given user is on Victim card selection form  
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Ravi" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And No search result found against the Pole database
	Then the focus will be on the Object Editor form of Victim
	
		
	# Edition  of the Card
	
Scenario: Edit of the Card

    Given user is on the Victim card grid
    And click on saved Victim Card which is displayed in the grid
	When I update "Johnnat" in Surname
	And I update "Raymond's " in Forename 1
	And I update "Yorkes" in Forename 2
	And I select "Male" in Gender
	And I update "01/01/1982" in Date of Birth
	And I update "4566" in PNC ID
	And I update "123457/19/A" in CRO
	And I update "9820000001" in Mobile
	And I update "22333394" in Landline
	And I update "john1@yahoo.com" in Email
    And click on "Future Details" tab
	And update "Details 1" in Notes
    And click on "Home Address" tab
	And I update "Mall" in Location Type
	And I update "456" in Number
	And I update "Hill road" in Premises Name
	And I update "Bridge" in Flat
	And I update "Bridgetone " in Address Line 1
	And I update " lane 5" in Address Line 2
	And I update "Liverpool" in Town
	And I update " SW1A 2AB " in Postcode
	And I update " United Kingdom " in County
	And click on "Examination Address" Tab
	And I update "Car" in Location Type
	And I update "89880" in Number
	And I update "Rawa Town" in Premises Name
	And I update "Bridgestone" in Flat
	And I update "Bridgetone" in Address Line 1
	And I update " laneNo 7" in Address Line 2
	And I update "Liverpool" in Town
	And I update " SW1A 2AC " in Postcode
	And I update " UK " in County
	And click on "Save & Return" button
	Then the record should Save and displayed in the Grid as Victim card
    	
	# Deleting the Victim card
	
	
Scenario: Deletion of the Card	

    Given user is on Victim card selection form  
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	And I enter "Ravi" as "Surname"
    And I select "Male" as "Gender"
	And click on "Card not Required" button
	Then Card details should get Deleted and the focus should go on the Main form
	
Scenario: Deletion of the card with added details	
	
	Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rohan" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the victim Template should be displayed in Read only mode
	And click on  "This is the Victim " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of victim
	And I click on "No" on Unknown Victim
	And I enter "John" in Surname
	And I enter "Raymond " in Forename 1
	And I enter "York" in Forename 2
	And I select "Male" in Gender
	And I select "Male" in Gender
	And I enter "25" in Age from
	And I enter "30" in Age To
	And I enter "20" in Estimated age
	And I enter "45666" in PNC ID
	And I enter "123456/19/A" in CRO
	And I enter "9820000000" in Mobile
	And I enter "22333393" in Landline
	And I enter "john@yahoo.com" in Email
	And I click "No" in Examination Required?
	And I click "No" as Is Examination Address same as Home Address?
	And click on "Save & Return" button
	And the Record should Save and displayed in the grid
	And click on "Card not Required" button 
	Then Saved Card details should get deleted
	
	
Scenario: Cancel button 

	Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Ravi" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Victim
	And click on "Delete Victim" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Victim "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "No , Cancel" button
	And the Popup should get close and the focus should be on Victim Object Editor form	
	
    Given user is on the Victim Object Editor form	
	When user click on "Delete Victim" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Victim "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "Yes,Remove"
	And the Card should be deleted 
	
Scenario: Click on Cross icon of the Popup message
	
    Given user is on Victim card selection form 
	And It will display "Are there any Victim " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Ravi" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Victim
	And click on "Delete Victim" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Victim "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "cross" icon
	And the Popup should get close and the focus should be on Victim Object Editor form
	
	
		
	
	