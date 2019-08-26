@Intelligence
Feature: Operation Card CF-6

Background: User is logging into the Forensic Investigation system

    Given User is on Card Index screen for a 'Create Generic Investigation'
	When User clicks on "Operation" card with Link Reason "" 

#Scenario 1
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario:  User  click on Operation card and than by  Searching the Operation Card , 
          adding the Operation Object Basic  details 
	
	Given user is on "Operation" card
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	When I click on "No,card not required" button
	Then the focus should be on the Main page
	
	
	Given user is on "Operation" card
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	Then the Object Basic Details search  form of Operation is displayed
	
Scenario: Search for Operation Name and Mandatory feild checked on Object editor form

	Given user is on the Object Basic Details search form of Operation
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And I should get the data searched against pole database and displayed
	And click on the displayed record
	And the object editor for Basic details should be displayed
	And clear the "Operation Name"
	And click on "Save & Return" button
	Then I should get the message "Please enter Operation Name"
	

Scenario: Search for Operation Start Date

	Given user is on the Object Basic Details search form of Operation
	When I enter "01/01/2019" as "Operation Start Date"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
	
Scenario: Search for Operation End Date

    Given user is on the Object Basic Details search form of Operation
	When I enter "01/01/2019" as "Operation End Date"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 


	
Scenario: Checking for Mandatory feild
	
    Given user is on "Operation" card
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Next" Button
	Then it should display message "Minimum data requirement not meet" 
	
	
    Given user is on Object Basic Details search  form of Operation 
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	Then I should get the data searched against pole database and displayed 
	
Scenario:  For  "Card Not Required" button

	Given user is on Operation card selection form
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And enter "Blue Star" as "Operation Name"
	And click on "Card Not Required" button
	Then the Card should be deleted and focus should be on the Main page
	
	
    Given user is on Operation card selection form
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Index" button
	Then the focus should be on the Main page
	
	
	
    Given ser clicks on "Operation" card with Link Reason "" 
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And click on the desired search result 
	Then the Operation template should be displayed in Read only mode
	And click on  "This is the Operation " button
	Then the focus will be on the Object Editor form Tab  "Basic Details" of Operation
	


Scenario:  Saving of the data 
	 
    Given user is on Operation card selection form
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And click on the desired search result 
	And the Operation Template should be displayed in Read only mode
	And click on  "This is the Operation " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Operation
	And I enter "Blue Star" in Operation Name
	And I enter "01/01/2019 " in Operation Start Date
	And I enter "12:00" in Operation Start Time
	And I enter "31/01/2019" in Operation End Date
	And I enter "10:30" in Operation End Time
	And click on "Save & Return" button
	Then the Record should Save and displayed in the grid

       
         
	
Scenario: Add data in Basic details and   Future Detail Tab
	
	Given user is on Operation card selection form 
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And click on the desired search result 
	And the Operation Template should be displayed in Read only mode
	And click on  "This is the Operation " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Operation
	And click on "Baisc Details" tab
	And I enter "Blue Star" in Operation Name
	And I enter "01/01/2019 " in Operation Start Date
	And I enter "12:00" in Operation Start Time
	And I enter "31/01/2019" in Operation End Date
	And I enter "10:30" in Operation End Time
	And click on "Furture Details" tab
	And I enter "Operation 1" in Operation Description
	And I select "Operation" in Type
	And I select "223" in Owning Force ID
	And I select "Department Investigation" in Owning Department
	And I select "Classification" in GPMS Classification
	And I select "CSI" in GPMS Descriptor
	And click on "Save & Return" button
	Then the record should Save and displayed in the Grid as Operation card
	
	 
Scenario: "This is not the Operation " button
	 
	Given user is on Operation card selection form 
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And click on the desired search result 
	And the Operation Template should be displayed in Read only mode
	And click on  "This is not the Operation " button
	Then the Focus goes back on the Operation search form
	 
Scenario:  "None of these  people are Operation" Button click 
	 
	Given user is on Operation card selection form  
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And the search result are displayed
	And click on "None of these  people are Operation " Button 
	Then focus should be on the Operation Object Editor form "Basic Detail"
	
Scenario:  No Search found in Pole database
	
	Given user is on Operation card selection form  
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And No search result found against the Pole database
	Then the focus will be on the Object Editor form of Operation
	
		
	# Edition  of the Card
	
Scenario: Edit of the Card

    Given user is on the Operation card grid
    And click on saved Operation Card which is displayed in the grid
	And click on "Baisc Details" tab
	When I update "Blue Star" in Operation Name
	And I update "01/01/2019 " in Operation Start Date
	And I update "12:00" in Operation Start Time
	And I update "31/01/2019" in Operation End Date
	And I update "10:30" in Operation End Time
	And click on "Furture Details" tab
	And I update "Operation 1" in Operation Description
	And I update select "Operation" in Type
	And I update select "223" in Owning Force ID
	And I update select "Department Investigation" in Owning Department
	And I update select "Classification" in GPMS Classification
	And I update select "CSI" in GPMS Descriptor
	And click on "Save & Return" button
	Then the record should Save and displayed in the Grid as Operation card
    	
	# Deleting the Operation card
	
	
Scenario: Deletion of the Card	

    Given user is on Operation card selection form  
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I update "Blue Star" in Operation Name
	And click on "Card not Required" button
	Then Card details should get Deleted and the focus should go on the Main form
	
Scenario: Deletion of the card with added details	
	
	Given user is on Operation card selection form 
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I update "Blue Star" in Operation Name
	And click on "Next" button
	And click on the desired search result 
	And the Operation Template should be displayed in Read only mode
	And click on  "This is the Operation " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Operation
	When I update "Blue Star" in Operation Name
	And I update "01/01/2019 " in Operation Start Date
	And I update "12:00" in Operation Start Time
	And I update "31/01/2019" in Operation End Date
	And I update "10:30" in Operation End Time
	And click on "Save & Return" button
	And the Record should Save and displayed in the grid
	And click on "Card not Required" button 
	Then Saved Card details should get deleted
	
	
Scenario: Cancel button 

	Given user is on Operation card selection form 
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I update "Blue Star" in Operation Name
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Operation
	And click on "Delete Operation" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Operation "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "No , Cancel" button
	And the Popup should get close and the focus should be on Operation Object Editor form	
	
    Given user is on the Operation Object Editor form	
	When user click on "Delete Operation" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Operation "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "Yes,Remove"
	And the Card should be deleted 
	
Scenario: Click on Cross icon of the Popup message
	
    Given user is on Operation card selection form 
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I update "Blue Star" in Operation Name
	And click on "Next" button
	And No search result found against the Pole database
	And the focus will be on the Object Editor form of Operation
	And click on "Delete Operation" button
	Then I should get a Warning Popup "Are you Sure you want to Remove the Operation "
	And I should view two button "No , Cancel "and "Yes,Remove"
	And click on "cross" icon
	And the Popup should get close and the focus should be on Operation Object Editor form
	
	
		
Scenario: Verifying the Submit button

	Given user is on Main form of the Cards after saving all the details in the card
	When user click on "Submit" button
	Then a  Unique Incident Number should be Generated
	And "Cancel" button will be disabled
	
	
