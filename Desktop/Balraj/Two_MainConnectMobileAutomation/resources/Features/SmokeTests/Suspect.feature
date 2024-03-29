@Intelligence
Feature: Suspect Card CF-6

Background: User is logging into the Forensic Investigation system

    Given User is on Card Index screen for a 'Create Generic Investigation'
	When User clicks on "Suspect" card with Link Reason "" 

#Scenario 1
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario:  User  click on Suspect card and than by  Searching the Suspect Card , 
          adding the Suspect Object Basic  details 
	
	Given user is on "Suspect" card
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	When I click on "No,card not required" button
	Then the focus should be on the 'Dashboard page'
	
	
	Given user is on "Suspect" card
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	Then the Object Basic Details search  form of Suspect is displayed
	
Scenario: Search for Surname and Gender and Mandatory feild checked on Object editor form

	Given user is on the Object Basic Details search form of Suspect
	When I enter "John" as "Surname"
	And I select "Male" as "Gender"
	And click on "Next" button
	And I should get the data searched against pole database and displayed
	And click on the displayed record
	And the object editor for Basic details should be displayed
	And clear the "Surname"
	And clear the "Gender"
	And click on "Save & Return" button
	Then I should get the message "Please enter Surname"
	And I should get message "Please enter Gender"

Scenario: Search for Forename 1 and Gender

	Given user is on the Object Basic Details search form of Suspect
	When I enter "Deric" as "Forename 1"
	And I select "Male" as "Gender"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 

	
Scenario: Checking for Mandatory feild
	
    Given user is on "Suspect" card
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Next" Button
	Then it should display message "Minimum data requirement not meet" 
	
	
    Given user is on Object Basic Details search  form of Suspect 
	When I enter "Feric" as "Forename 1"
	And I select "Male" as "Gender"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
Scenario:  For  "Card Not Required" button

	Given user is on Suspect card selection form
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I enter "Raha" as "Surname"
	And I select "Male" as "Gender"
	And click on "Card Not Required" button
	Then the Card should be deleted 
	And focus should be on the 'Dashboard page'
	
	
    Given user is on Suspect card selection form
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Index" button
	Then the focus should be on the 'Dashboard page'
	
	
	
    Given ser clicks on "Suspect" card with Link Reason "" 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	And I enter "Raha" as "Surname"
	And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	Then the Suspect template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	Then the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	

Scenario:  Entering Date of birth
	 
    Given user is on Suspect card selection form
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Raha" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter "Andrewe" in Surname field
	And I enter "Raymond " in Forename 1 field
	And I enter "York" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "01/01/1982" in Date of Birth field
	And I enter "45666" in PNC ID field
	And I enter "123456/19/A" in CRO field
	And I enter "9820000000" in Mobile field
	And I enter "22333393" in Landline field
	And I enter "andrewe@yahoo.com" in Email field
	And I click "Yes" in Examination Required?
	And click on "Save & Return" button
	Then the Record should Save 
	And displayed in the grid as Suspect card

#  Age from and Age to and Add New Suspect

    Given user is on the Suspect card Grid
    And click on "Add new Suspect" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter "Andrewe" in Surname field
	And I enter "Raymond " in Forename 1 field
	And I enter "York" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "25" in Age from field		
	And I enter "30" in Age To field
	And I enter "20" in Estimated age field
	And I enter "45666" in PNC ID field
	And I enter "123456/19/A" in CRO field
	And I enter "9820000000" in Mobile field
	And I enter "22333393" in Landline field
	And I enter "john@yahoo.com" in Email field
	And I click "No" in Examination Required?
	And click on "Save & Return" button
	Then the Record should Save 
	And displayed in the grid as Suspect card

	
Scenario:  Validation for Date of Birth if added as Future date 
	
	Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter "Andrewe" in Surname field
	And I enter "Raymond " in Forename 1 field
	And I enter "York" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "01/01/2020" in Date of Birth field
	And I enter "45666" in PNC ID field
	And I enter "123456/19/A" in CRO field
	And I enter "9820000000" in Mobile field
	And I enter "22333393" in Landline field
	And I enter "john@yahoo.com" in Email field
	And I click "Yes" in Examination Required?
	And click on "Save & Return" button
	Then I should get the validation message "Date of Birth cannot be of Future"
	
	
	# Verifying when we enter the Age From Greater than Age To and click on Save & Return button
	
	Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter "Andrewe" in Surname field
	And I enter "Raymond " in Forename 1 field
	And I enter "York" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "01/01/2020" in Date of Birth field
	Then I should get the message "Age From date cannot be Greater than Age To date"
	
	
Scenario: Validation for CRO Number

#When we enter Less digit in the First 6 digit slot 

    Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter "Andrewe" in Surname field
	And I enter "Raymond " in Forename 1 field
	And I enter "York" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "01/01/1982" in Date of Birth field
	And I enter "45666" in PNC ID field
	And I enter "12345/78/B" in CRO field
	And I enter "9820000000" in Mobile field
	And I enter "22333393" in Landline field
	And I enter "john@yahoo.com" in Email field
	And I click "Yes" in Examination Required?
	And click on "Save & Return" button
	Then I should recive message "Enter CRO number in proper format"

# When we enter More digit in the First 6 digit slot

    Given user is on Suspect card
    When I enter "1234567/78/B" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    
  # When we enter a char in the First 6 digit slot
  
    Given user is on Suspect card
    When I enter "12D456/78/B" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
	
	# When we enter Less digit in the Second 2 digit slot
	
	Given user is on Suspect card
    When I enter "123456/8/B" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
	 
	# When we enter More digit in the Second 2 digit slot
	
    Given user is on Suspect card
    When I enter "1234567/978/B" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter a char in the Second 2 digit slot
    
    Given user is on Suspect card
    When I enter "12D4567/W8/B" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter the future Year for  Second 2 digit slot
    
    Given user is on Suspect card
    When I enter "12D4567/21/B" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
         
	
	# When we keep CRO number format char in Lower case  for Third slot
	
    Given user is on Suspect card
    When I enter "123456/78/b" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
     	
     	
     # When we enter Digit in the  Third slot
    
    Given user is on Suspect card
    When I enter "123456/78/2" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
      
    # When we enter Upper case char in Multiple in the  Third slot
    
    Given user is on Suspect card
    When I enter "123456/78/AA" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter "I " in Third slot
    
    Given user is on Suspect card
    When I enter "123456/78/I" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter " O " in Third slot
    
    Given user is on Suspect card
    When I enter "123456/78/O" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
    
    # When we enter " S " in Third slot
    
    Given user is on Suspect card
    When I enter "123456/78/S" in CRO field
    And click on "Save & Return" button
    Then I should recive message "Enter CRO number in proper format"
          
         
         
         
	
Scenario: Adding  data in  Future Detail Tab, Home Address and Examination Address
	
	Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And click on "Examination Address" Tab
	And I enter "Car Park" in Location Type field
	And I enter "8988" in Number field
	And I enter "Hill Town" in Premises Name field
	And I enter "Bridgelon" in Flat field
	And I enter "Bridgetone lane" in Address Line 1 field
	And I enter " lane 4" in Address Line 2 field
	And I enter "London" in Town field
	And I enter " SW1A 2AA " in Postcode field
	And I enter " UK " in County field
	And click on "Save & Return" button
	Then the record should Save 
	And displayed in the Grid as Suspect card


Scenario: Adding Special char  in  Future Detail Tab, Home Address and Examination Address
	
	Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter "!~@#$%^'" in Surname field
	And I enter "!~@#$%^' " in Forename 1 field
	And I enter "!~@#$%^'" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "01/01/1982" in Date of Birth field
	And I enter "!~@#$%^'" in PNC ID field
	And I enter "!~@#$%^'" in CRO field
	And I enter "!~@#$%^'" in Mobile field
	And I enter "!~@#$%^'" in Landline field
	And I enter "!~@#$%^'@yahoo.com" in Email field
	And I click "Yes" in Examination Required?
	And click on "Examination Address" Tab
	And I select "Car Park" in Location Type field
	And I enter "8988" in Number field
	And I enter "!~@#$%^'" in Premises Name field
	And I enter "!~@#$%^'" in Flat field
	And I enter "!~@#$%^'" in Address Line 1 field
	And I enter "!~@#$%^'" in Address Line 2 field
	And I enter "!~@#$%^'" in Town field
	And I enter "!~@#$%^'" in Postcode field
	And I enter "!~@#$%^'" in County field
	And click on "Save & Return" button
	Then the record should Save 
	And displayed in the Grid as Suspect card
	

Scenario: Adding more data in the Text box

Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter characters more than "100" in Surname field
	And I enter characters more than "100" in Forename 1 field
	And I enter characters more than "100" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "01/01/1982" in Date of Birth field
	And I enter characters more than "100"in PNC ID field
	And I enter "123456/23/T" in CRO field
	And I enter "98208888888" in Mobile field
	And I enter "456727272" in Landline field
	And I enter "john@yahoo.com" in Email field
	And I click "Yes" in Examination Required?
	And click on "Examination Address" Tab
	And I select "Car Park" in Location Type field
	And I enter "8988" in Number field
	And I enter characters more than "100" in Premises Name field
	And I enter characters more than "100" in Flat field
	And I enter characters more than "100" in Address Line 1 field
	And I enter characters more than "100" in Address Line 2 field
	And I enter characters more than "100" in Town field
	And I enter characters more than "8" in Postcode field
	And I enter characters more than "100" in County field
	And click on "Save & Return" button
	Then the record should Save 
	And displayed in the Grid as Suspect card

	 
Scenario: "This is not the Suspect " button
	 
	Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname" field
    And I select "Male" as "Gender"field
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is not the Suspect " button
	Then the Focus goes back on the Suspect search form
	 
Scenario:  "None of these  people are Suspect" Button click 
	 
	Given user is on Suspect card selection form  
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And the search result are displayed
	And click on "None of these  people are Suspect " Button 
	Then focus should be on the Suspect Object Editor form "Basic Detail"
	
Scenario:  No Search found in Pole database
	
	Given user is on Suspect card selection form  
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Rajesh" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And No search result found against the Pole database
	Then the focus will be on the Object Editor form of Suspect
	
		
	# Edition  of the Card
	
Scenario: Edit of the Card

    Given user is on the Suspect card grid
    And click on saved Suspect Card which is displayed in the grid
	When I update "Johnnat" in Surname field
	And I update "Raymond's " in Forename 1 field
	And I update "Yorkes" in Forename 2 field
	And I select "Male" in Gender field
	And I update "01/01/1982" in Date of Birth field
	And I update "4566" in PNC ID field
	And I update "123457/19/A" in CRO field
	And I update "9820000001" in Mobile field
	And I update "22333394" in Landline field
	And I update "john1@yahoo.com" in Email field
    And click on "Examination Address" Tab
	And I update "Car" in Location Type field
	And I update "89880" in Number field
	And I update "Rawa Town" in Premises Name field
	And I update "Bridgestone" in Flat field
	And I update "Bridgetone" in Address Line 1 field
	And I update " laneNo 7" in Address Line 2 field
	And I update "Liverpool" in Town field
	And I update " SW1A 2AC " in Postcode field
	And I update " UK " in County field
	And click on "Save & Return" button
	Then the record should Save 
	And displayed in the Grid as Suspect card
    	
	# Deleting the Suspect card
	
	
Scenario: Deletion of the Card	

    Given user is on Suspect card selection form  
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	And I enter "Ravi" as "Surname"
    And I select "Male" as "Gender"
	And click on "Card not Required" button
	Then Card details should get Deleted 
	And the focus should go on the 'Dashboard form' 
	
Scenario: Deletion of the card with added details	
	
	Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And click on the desired search result 
	And the Suspect Template should be displayed in Read only mode
	And click on  "This is the Suspect " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Suspect
	And I enter "Andrewe" in Surname field
	And I enter "Raymond " in Forename 1 field
	And I enter "York" in Forename 2 field
	And I select "Male" in Gender field
	And I enter "25" in Age from field
	And I enter "30" in Age To field
	And I enter "20" in Estimated age field
	And I enter "45666" in PNC ID field
	And I enter "123456/19/A" in CRO field
	And I enter "9820000000" in Mobile field
	And I enter "22333393" in Landline field
	And I enter "john@yahoo.com" in Email field
	And I click "No" in Examination Required?
	And click on "Save & Return" button
	And the Record should Save and displayed in the grid
	And click on "Card not Required" button 
	Then Saved Card details should get deleted
	
	
Scenario: Cancel button 

	Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Ravi" as "Surname"
    And I select "Andrewe" as "Gender"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Suspect
	And click on "Delete Suspect" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Suspect "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "No , Cancel" button
	And the Popup should get close and the focus should be on Suspect Object Editor form	
	
    Given user is on the Suspect Object Editor form	
	When user click on "Delete Suspect" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Suspect "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "Yes,Remove"
	And the Card should be deleted 
	
Scenario: Click on Cross icon of the Popup message
	
    Given user is on Suspect card selection form 
	And It will display "Are there any Suspect " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Andrewe" as "Surname"
    And I select "Male" as "Gender"
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Suspect
	And click on "Delete Suspect" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Suspect "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "cross" icon
	And the Popup should get close and the focus should be on Suspect Object Editor form 
	
	
		
	
	
