@Intelligence
Feature: Forensic Investigation Unit test for Location

#Scenario 3
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario: Creating Location Card for Forensic Investigation

   # Given User is on Card Index screen for a 'Create intelligence report' 
	When User read the test data sheet "IntelProdWF12" from file "SmokeTestData" 
	And User read the test data for cards on sheet "IntelProdWF12_Cards" from file "SmokeTestData" 
	
    When User clicks on "Location" card with Link Reason "Subject of" 
	And User has completed all the fields on the "Location" card with Link Reason "Subject of" 
	And User saves "Location" card with Link Reason "Subject of" 
	
	#Then Logout from an application and close the browser 