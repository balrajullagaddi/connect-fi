@Intelligence
Feature: Forensic Investigation Test CF-5

Background: User is logging into the Forensic Investigation system

    Given user is on Card Index screen for a 'Create intelligence report' 
	When user clicks on "Basic details" card with Link Reason "" 

#Scenario 1
@run @REGQA1 @REGQA2 @DEVINT2 @FUNCQA1 @TestCaseKey=CCI-T55792
Scenario: Create an Forensic Investigation record by adding data in Basic details card
1) user will select the provision to ‘Create New Forensic Investigation’ from the menu.
2) user will enter Basic Details of the incident - including offence type, date/time of offence, OIC. 
   Fields within Basic Details

	Given user is on "Basic details" card
	When I enter "324" in "Crimeno" field
	And I enter "4567" in "Incident log" field	
	And I Select "Murder" in  "Offence" field
	And I Select "CSI" in "OIC" field 
	And I Select "Force" in "Force" field
	And I Select "John" in "Crime Scene Coordinator" field
	And I Select "01/02/2019" in "Offence Date Start" field
	And I Select "12:00" in "Offence Time Start" field
	And I Select "01/02/2019" in "Offence Date End" field
	And I Select "12:00" in "Offence Time End" field
	And I enter "Summary data" in "Incident Summary" field
	And I Select "High" in  "Priority" field
	And  "Socrates Case Reference" number displayed if present in Socrates
	And click on Save & Return button
	Then the record should save and focus should be on the Main form
	  
	   
#Scenario 2
	   
 Scenario: Basic details Validation 
	 
	Given user is on "Basic details" card
	When I click on Save & Return button
	Then I should receive message "Crime Number cannot be Blank"
	And I should receive message "Incident Log cannot be Blank"
    And I should receive message "Offence cannot be Blank"
    And I should receive message "Force cannot be Blank"
	And I should receive message "Offence Date Start cannot be Blank"
	And I should receive message "Offence Date End cannot be Blank" 
	And I should receive message "Priority cannot be Blank"
	And I should receive message "Investigation Status cannot be Blank"
	
	# Special Char in text box
	
    Given user is on "Basic details" form
    When I enter "!@#$%^&*()A'" in "Crimeno" field
	And I enter "!@#$%^&*()A'" in "Incident log" field	
	And I Select "Murder" in  "Offence" field
	And I Select "CSI" in "OIC" field 
	And I Select "Force" in "Force" field
	And I Select "John" in "Crime Scene Coordinator" field
	And I Select "01/02/2019" in "Offence Date Start" field
	And I Select "12:00" in "Offence Time Start" field
	And I Select "01/02/2019" in "Offence Date End" field
	And I Select "12:00" in "Offence Time End" field
	And I enter "!@#$%^&*()'" in "Incident Summary" field
	And I Select "High" in  "Priority" field
	And  "Socrates Case Reference" number displayed if present in Socrates
	And click on Save & Return button
	Then the record should save and focus should be on the Main form
	
	
	
	
#Scenario 3

Scenario: If the Crime Number or Incident Log number entered by the user is already recorded in some other 
existing investigation record, then the application will not allow creation of another investigation for the same
Crime Number or Incident Log number. Instead, the application would suggest the corresponding existing investigation record   

   Given user is on "Basic details" card
   When I enter existing  "324" in "Crime no" field
   And click on Save & Return button
   Then I should receive the message "Forensic Investigation Already Exist"
   
   Given user is on "Basic details" card
   When I enter  existing "4567" in "Incident log" field	
   And click on Save & Return button
   Then I should receive the message "Forensic Investigation Already Exist"
   
   
   #Scenario 4

Scenario: While the creation of forensic investigation, user may wish to change the already entered details before 
submission of investigation. 

    Given user is on "Basic details" card 
    When I enter "324" in "Crimeno" field
	And I enter "4567" in "Incident log" field	
	And I Select "Murder" in  "Offence" field
	And I Select "CSI" in "OIC" field 
	And I Select "Force" in "Force" field
	And I Select "John" in "Crime Scene Coordinator" field
	And I Select "01/02/2019" in "Offence Date Start" field
	And I Select "12:00" in "Offence Time Start" field
	And I Select "01/02/2019" in "Offence Date End" field
	And I Select "12:00" in "Offence Time End" field
	And I enter "Summary data" in "Incident Summary" field
	And I Select "High" in  "Priority" field
	And  "Socrates Case Reference" number displayed if present in Socrates
	And click on Save & Return button
	And the record should save and focus should be on the Main form
	And click on "Basic detail" form
	And I update "478" in "Crimeno" field
	And I update "0988" in "Incident log" field	
	And I update "Buglery" in  "Offence" field
	And I update "SOCO" in "OIC" field 
	And I update "Force" in "Force" field
	And I update "Deric" in "Crime Scene Coordinator" field
	And I update "02/02/2019" in "Offence Date Start" field
	And I update "11:00" in "Offence Time Start" field
	And I update "04/02/2019" in "Offence Date End" field
	And I update "10:00" in "Offence Time End" field
	And I enter "Summary data" in "Incident Summary" field
	And I update "Medium" in  "Priority" field
	And  "Socrates Case Reference" number displayed if present in Socrates
	And click on Save & Return button
	Then the data should be Updated and Focus should be on Main form

#Scenario 5
Scenario:  Validation for Offence Start Date is Greater than current date (21/08/2019) .

    Given user is on "Basic details" card
    When I enter "3241" in "Crimeno" field
	And I Select "Murder" in  "Offence" field
	And I Select "CSI" in "OIC" field 
	And I Select "Force" in "Force" field
	And I Select "22/08/2019" in "Offence Date Start" field
	And I Select "12:00" in "Offence Time Start" field
	And I Select "21/08/2019" in "Offence Date End" field
	And I Select "12:00" in "Offence Time End" field
	And I enter "Summary data" in "Incident Summary" field
	And I Select "High" in  "Priority" field
	And click on Save & Return button
	Then I should receive the Message "Offence Date Start should not be greater than current date"


# Validation for Offence Start Date is Greater than Offence End  date (21/08/2019) .

    Given user is on "Basic details" card
    When I enter "3241" in "Crimeno" field
	And I Select "Murder" in  "Offence" field
	And I Select "CSI" in "OIC" field 
	And I Select "Force" in "Force" field
	And I Select "22/08/2019" in "Offence Date Start" field
	And I Select "12:00" in "Offence Time Start" field
	And I Select "21/08/2019" in "Offence Date End" field
	And I Select "12:00" in "Offence Time End" field
	And I enter "Summary data" in "Incident Summary" field
	And I Select "High" in  "Priority" field
	And click on Save & Return button
	Then I should receive the Message "Offence Date Start should not be greater than Ofence End date"
	
# Validation for Offence End  Date is Greater than Offence Start  date (21/08/2019) .
	
	Given user is on "Basic details" card 
	When I enter "3241" in "Crimeno" field
	And I Select "Murder" in  "Offence" field
	And I Select "CSI" in "OIC" field 
	And I Select "Force" in "Force" field
	And I Select "21/08/2019" in "Offence Date Start" field
	And I Select "12:00" in "Offence Time Start" field
	And I Select "20/08/2019" in "Offence Date End" field
	And I Select "12:00" in "Offence Time End" field
	And I enter "Summary data" in "Incident Summary" field
	And I Select "High" in  "Priority" field
	And click on Save & Return button
	Then I should receive the Message "Offence End date should  be greater than Ofence Start date"
	
#Scenario 6
Scenario:  user when click on Cancel button on the Main page
    
    Given user is on Card Index screen for a 'Create intelligence report' 
	When I click on "Cancel" button on the Main page
    And a popup of Warning message is displayed
    And click on "Cancel" button
    Then the popup should be closed and focus should be on the Main  form
    
    Given user is on Card Index screen for a 'Create intelligence report' 
	When I click on "Cancel" button on the Main page
    And a popup of Warning message is displayed
    And click on "Save for Later" button
    Then the popup should be closed and focus should be on the Home page
    
    Given user is on Card Index screen for a 'Create intelligence report' 
	When I click on "Cancel" button on the Main page
    And a popup of Warning message is displayed
    And click on "Exit Without Saving" button
    Then the popup should be closed and focus should be on the Home page
    
    Given user is on Card Index screen for a 'Create intelligence report' 
	When I click on "Cancel" button on the Main page
    And a popup of Warning message is displayed
    And click on "Cross " Icon
    Then the popup should be closed and focus should be on the Main page
    

#Scenario 7
Scenario:  user when click on Save for Later button on the Main page

    Given user is on Card Index screen for a 'Create intelligence report' 
    When I click on "Save for Later"  button on the Main page
    And a popup of Save for Later is displayed
    And click on "Cancel " button
    Then the popup should be closed and focus should be on the Main page
    
    Given user is on Card Index screen for a 'Create intelligence report' 
	When I click on "Save for Later"  button on the Main page
    And a popup of Save for Later is displayed
    And click on "Save for Later " button
    Then the popup should be closed and focus should be on the Home page
    
 #Scenario 8
Scenario:  user when click on Submit  button on the Main page when no data has been entered

    Given user is on Card Index screen for a 'Create intelligence report' 
	When I click on "Submit"  button on the Main page
    And a popup of Submittion Error is displayed
    And click on "Cancel " button
    Then the popup should be closed and focus should be on the Main page
    
    Given user is on Card Index screen for a 'Create intelligence report' 
	When I click on "Submit"  button on the Main page
    And a popup of Submittion Error is displayed
    And click on "Cross " icon
    Then the popup should be closed and focus should be on the Main page
    
    
 #Scenario 9
Scenario:  user when click on Basic detail card and click on Index button
    
    Given user is on Card Index screen for a 'Create intelligence report' 
	When user clicks on "Basic details" card with Link Reason "" 
    And I click on "Index " button
    Then the focus should be on the Main page
    
 