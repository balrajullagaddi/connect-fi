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
	Then the focus should be on the 'Dashboard page'
	
	
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
	Then the Card should be deleted and focus should be on the 'Dashboard page'
	
	
    Given user is on Operation card selection form
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	When I click on "Yes,card is required" button
	And I click on "Index" button
	Then the focus should be on the 'Dashboard page'
	
	
	
    Given ser clicks on "Operation" card with Link Reason "" 
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And click on the desired search result 
	Then the Operation template should be displayed in Read only mode
	And click on  "This is the Operation " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Operation
	And keep Operation Start Time and Operation End Time Blank
	And click on Save & Return button
	Then I should recieve message "Operation Start Time cannot be Blank"
	And I should receive message "Operation End Time cannot be Blank"
	
	Given user is on Basic details Tab
	And I enter "12:00" in  Operation Start Time
	And I enter "12:00" in  Operation End Time
	When I click on Further Details Tab
	And click on Save & Return button
	Then I should recieve message "Operation Description cannot be Blank"
	And I should recieve message "Type cannot be Blank"
	And I should recieve message "Owning Force ID cannot be Blank"
	And I should recieve message "Owning Department cannot be Blank"
	And I should recieve message "GPMS Classification cannot be Blank"
	And I should recieve message "GPMS Descriptor cannot be Blank"
	
	

    

Scenario:  Saving of the data in the Basic details tab
	 
    Given user is on Operation card selection form
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And click on the desired search result 
	And the Operation Template should be displayed in Read only mode
	And click on  "This is the Operation " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Operation
	And I enter "Blue Star" in Operation Name field
	And I enter "01/01/2019 " in Operation Start Date field
	And I enter "12:00" in Operation Start Time field
	And I enter "31/01/2019" in Operation End Date field
	And I enter "10:30" in Operation End Time field
	And click on "Save & Return" button
	Then the Record should Save 
	And displayed in the 'Dashboard form'

       
Scenario:  Start date is greater than the System date 

 
    Given user is on Operation card selection form
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I enter "Blue Star" as "Operation Name"
	And click on "Next" button
	And click on the desired search result 
	And the Operation Template should be displayed in Read only mode
	And click on  "This is the Operation " button
	And the focus will be on the Object Editor form Tab  "Basic Details" of Operation
	And I enter "Blue Star" in Operation Name field
	And I enter "01/01/2019 " in Operation Start Date field
	And I enter "12:00" in Operation Start Time field
	And I enter "31/01/2019" in Operation End Date field
	And I enter "10:30" in Operation End Time field
	And click on "Save & Return" button
	Then I should get the message "Operation Start Date should not be greater than the Current date"
	
	
	# Operation Start date is Greater than End date
	
    Given user is on Operation card form
    When user enter "02/01/2019 " in Operation Start Date field
	And I enter "12:00" in Operation Start Time field
	And I enter "01/01/2019" in Operation End Date field
	And I enter "10:30" in Operation End Time field
	Then I should get the message "Operation Start Date should not be greater than the Operation End Date"
	
	
# Operation End  date is Greater than Start date
	
    Given user is on Operation card form
    When user enter "01/01/2019 " in Operation Start Date field
	And I enter "12:00" in Operation Start Time field
	And I enter "31/12/2019" in Operation End Date field
	And I enter "10:30" in Operation End Time field
	Then I should get the message "Operation Start Date should not be greater than the Operation End Date"
	
	
Scenario: Adding  data in Basic details and   Future Detail Tab
	
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
	And I enter "Blue Star" in Operation Name field
	And I enter "01/01/2019 " in Operation Start Date field
	And I enter "12:00" in Operation Start Time field
	And I enter "31/01/2019" in Operation End Date field
	And I enter "10:30" in Operation End Time field
	And click on "Furture Details" tab
	And I enter "Operation 1" in Operation Description field
	And I select "Operation" in Type field
	And I select "223" in Owning Force ID field
	And I select "Department Investigation" in Owning Department field
	And I select "Classification" in GPMS Classification field
	And I select "CSI" in GPMS Descriptor field
	And click on "Save & Return" button
	Then the record should Save 
	And displayed in the Grid as Operation card

Scenario: Adding Special char data in Basic details and   Future Detail Tab
	
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
	And I enter "!~@#$%^'" in Operation Name field
	And I enter "01/01/2019 " in Operation Start Date field
	And I enter "12:00" in Operation Start Time field
	And I enter "31/01/2019" in Operation End Date field
	And I enter "10:30" in Operation End Time field
	And click on "Furture Details" tab 
	And I enter "!~@#$%^'" in Operation Description field
	And I select "Operation" in Type field
	And I select "223" in Owning Force ID field
	And I select "Department Investigation" in Owning Department field
	And I select "Classification" in GPMS Classification field
	And I select "CSI" in GPMS Descriptor field
	And click on "Save & Return" button
	Then the record should Save 
	And displayed in the Grid as Operation card

	
	 
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
	When I update "Blue Star" in Operation Name field
	And I update "01/01/2019 " in Operation Start Date field
	And I update "12:00" in Operation Start Time field
	And I update "31/01/2019" in Operation End Date field
	And I update "10:30" in Operation End Time field
	And click on "Furture Details" tab
	And I update "Operation 1" in Operation Description field
	And I update select "Operation" in Type field
	And I update select "223" in Owning Force ID field
	And I update select "Department Investigation" in Owning Department field
	And I update select "Classification" in GPMS Classification field
	And I update select "CSI" in GPMS Descriptor field
	And click on "Save & Return" button
	Then the record should Save 
	And displayed in the Grid as Operation card
    	
	# Deleting the Operation card
	
	
Scenario: Deletion of the Card	

    Given user is on Operation card selection form  
	And It will display "Are there any Operation " involved as "No,card not required" and "Yes,card is required" button
	And I click on "Yes,card is required" button
	When I update "Blue Star" in Operation Name
	And click on "Card not Required" button
	Then Card details should get Deleted 
	And the focus should go on the 'Dashboard form' 
	
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
	When I update "Blue Star" in Operation Name field
	And I update "01/01/2019 " in Operation Start Date field
	And I update "12:00" in Operation Start Time field
	And I update "31/01/2019" in Operation End Date field
	And I update "10:30" in Operation End Time field
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
	And the Popup should get close 
	And the focus should be on Operation Object Editor form	
	
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
	And the Popup should get close 
	And the focus should be on Operation Object Editor form
	
	
		
Scenario: Verifying the Submit button

	Given user is on Main form of the Cards after saving all the details in the card
	When user click on "Submit" button
	Then a  Unique Incident Number should be Generated
	And "Cancel" button will be disabled
	
	
