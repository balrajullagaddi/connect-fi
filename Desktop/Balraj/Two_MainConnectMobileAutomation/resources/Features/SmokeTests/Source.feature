@Intelligence
Feature: Forensic Investigation Unit test for Source

#Scenario 2
@run @REGQA1 @REGQA2 @DEVINT2 @FUNCQA1 @TestCaseKey=CCI-T55792
Scenario: Creating Source Card for Forensic Investigation
	#Given User is on Card Index screen for a 'Create intelligence report' 
	When User read the test data sheet "Intel_ST" from file "SmokeTestData" 
	And User read the test data for cards on sheet "Intel_ST_Cards" from file "SmokeTestData" 
 
    When User clicks on "Source" card with Link Reason "" 
	And User has completed all the fields on "Source details" form on "Source" card with Link Reason "" 
	And User saves "Source" card 
	
	#Then Logout from an application and close the browser
