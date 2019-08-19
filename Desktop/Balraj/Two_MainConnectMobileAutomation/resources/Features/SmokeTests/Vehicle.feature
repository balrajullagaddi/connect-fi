@Intelligence
Feature: Forensic Investigation Unit test for Vehicle

#Scenario 3
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario: Creating Vehicle Card for Forensic Investigation

    #Given User is on Card Index screen for a 'Create intelligence report' 
	When User read the test data sheet "IntelProdWF12" from file "SmokeTestData" 
	And User read the test data for cards on sheet "IntelProdWF12_Cards" from file "SmokeTestData" 
	
	When User clicks on "Vehicle" card with Link Reason "Subject of" 
	And User has completed all the fields on the "Vehicle" card with Link Reason "Subject of" 
	And User has completed all the fields on "Main details" form on "Vehicle" card with Link Reason "Subject of" 
	And User saves "Vehicle" card with Link Reason "Subject of" 
	
	#Then Logout from an application and close the browser 