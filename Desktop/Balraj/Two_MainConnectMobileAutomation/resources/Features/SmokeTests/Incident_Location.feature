@Intelligence
Feature: Intelligence smoke tests for Source

#Scenario 4
@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
Scenario:  Create Create Generic Investigation with all static objects linked and take it to Requires Assessment or Review status 
	Given User is on Card Index screen for a 'Create Generic Investigation'
	When User read the test data sheet "Inv_Smoke_Scenario2" from file "SmokeTestData" 
	And User read the test data for cards on sheet "Inv_Smoke_Scenario2_Cards" from file "SmokeTestData" 

    
	When User clicks on "Incident location" card with Link Reason "" 
	And User has completed all the fields on the "Incident location" card with Link Reason "" 
	And User saves "Incident location" card with Link Reason "" 

