@Intelligence
Feature: Forensic Investigation Unit test for Person

#Scenario 3
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario: Creating Person Card for Forensic Investigation

   # Given User is on Card Index screen for a 'Create intelligence report' 
	When User read the test data sheet "IntelProdWF12" from file "SmokeTestData" 
	And User read the test data for cards on sheet "IntelProdWF12_Cards" from file "SmokeTestData" 
	
	When User clicks on "Person" card with Link Reason "Subject of" 
	And User has completed all the fields on the "Person" card with Link Reason "Subject of" 
	And User saves "Person" card with Link Reason "Subject of" 
	
    #Then Logout from an application and close the browser 