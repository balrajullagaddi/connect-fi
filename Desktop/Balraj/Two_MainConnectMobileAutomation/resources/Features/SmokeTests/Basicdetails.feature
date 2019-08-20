@Intelligence
Feature: Forensic Investigation Test CF-5

#Scenario 1
@run @REGQA1 @REGQA2 @DEVINT2 @FUNCQA1 @TestCaseKey=CCI-T55792
Scenario: Create an Forensic Investigation record by adding data in Basic details card
1) User will select the provision to ‘Create New Forensic Investigation’ from the menu.
2) User will enter Basic Details of the incident - including offence type, date/time of offence, OIC. 
   Fields within Basic Details

	Given User is on Card Index screen for a 'Create intelligence report' 
	And User clicks on "Basic details" card with Link Reason "" 
	When I enter "324" in "Crimeno" feild
	And I enter "4567" in "Incident log" feild	
	And I Select "Murder" in  "Offence" feild
	And I Select "CSI" in "OIC" feild 
	And I Select "Force" in "Force" feild
	And I Select "John" in "Crime Scene Coordinator" feild
	And I Select "01/02/2019" in "Offence Date Start" feild
	And I Select "12:00" in "Offence Time Start" feild
	And I Select "01/02/2019" in "Offence Date End" feild
	And I Select "12:00" in "Offence Time End" feild
	And I enter "Summary data" in "Incident Summary" feild
	And I Select "High" in  "Priority" feild
	And  "Socrates Case Reference" number displayed if present in Socrates
	And I Select "Open" in "Investigation Status" feild
	And I enter "01/08/2019" in "Investigation Finalisation Date" feild
	And I Select "Filed" in "Outcome Code" feild
	And click on Save & Return button
	Then the record should save and focus should be on the Main form
	  
	   
#Scenario 2
	   
 Scenario: Basic details Validation 
	 
	When I am on the "Basic Detail" form
	And click on Save & Return button
	Then I should receive message "Crime Number cannot be Blank"
	And I should receive message "Incident Log cannot be Blank"
    And I should receive message "Offence cannot be Blank"
    And I should receive message "Force cannot be Blank"
	And I should receive message "Offence Date Start cannot be Blank"
	And I should receive message "Offence Date End cannot be Blank" 
	And I should receive message "Priority cannot be Blank"
	And I should receive message "Investigation Status cannot be Blank"
	
	
#Scenario 3

Scenario: If the Crime Number or Incident Log number entered by the user is already recorded in some other 
existing investigation record, then the application will not allow creation of another investigation for the same
Crime Number or Incident Log number. Instead, the application would suggest the corresponding existing investigation record   

   When I enter existing  "324" in "Crime no" feild
   And click on Save & Return button
   Then I should receive the message "Forensic Investigation Already Exist"
   
   When  I enter  existing "4567" in "Incident log" feild	
   And click on Save & Return button
   Then I should receive the message "Forensic Investigation Already Exist"
   
   
   #Scenario 4

Scenario: While the creation of forensic investigation, user may wish to change the already entered details before 
submission of investigation. 

    When User clicks on "Basic details" card with Link Reason "" 
	And I enter "324" in "Crimeno" feild
	And I enter "4567" in "Incident log" feild	
	And I Select "Murder" in  "Offence" feild
	And I Select "CSI" in "OIC" feild 
	And I Select "Force" in "Force" feild
	And I Select "John" in "Crime Scene Coordinator" feild
	And I Select "01/02/2019" in "Offence Date Start" feild
	And I Select "12:00" in "Offence Time Start" feild
	And I Select "01/02/2019" in "Offence Date End" feild
	And I Select "12:00" in "Offence Time End" feild
	And I enter "Summary data" in "Incident Summary" feild
	And I Select "High" in  "Priority" feild
	And  "Socrates Case Reference" number displayed if present in Socrates
	And I Select "Open" in "Investigation Status" feild
	And I enter "01/08/2019" in "Investigation Finalisation Date" feild
	And I Select "Filed" in "Outcome Code" feild
	And click on Save & Return button
	And the record should save and focus should be on the Main form
	And click on "Basic detail" form
	And I update "478" in "Crimeno" feild
	And I update "0988" in "Incident log" feild	
	And I update "Buglery" in  "Offence" feild
	And I update "SOCO" in "OIC" feild 
	And I update "Force" in "Force" feild
	And I update "Deric" in "Crime Scene Coordinator" feild
	And I update "02/02/2019" in "Offence Date Start" feild
	And I update "11:00" in "Offence Time Start" feild
	And I update "04/02/2019" in "Offence Date End" feild
	And I update "10:00" in "Offence Time End" feild
	And I enter "Summary data" in "Incident Summary" feild
	And I update "Medium" in  "Priority" feild
	And  "Socrates Case Reference" number displayed if present in Socrates
	And I Select "Open" in "Investigation Status" feild
	And I update "05/08/2019" in "Investigation Finalisation Date" feild
	And I update "Filed" in "Outcome Code" feild
	And click on Save & Return button
	Then the data should be Updated and Focus should be on Main form
	
#Scenario 5
Scenario:  Use may choose to ‘Cancel’ the creation of the investigation.

