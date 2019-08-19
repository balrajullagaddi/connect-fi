@Intelligence
Feature: Intelligence smoke tests

#Scenario 1
@run @REGQA1 @REGQA2 @DEVINT2 @FUNCQA1 @TestCaseKey=CCI-T55792
Scenario: Create an Intelligence record into REQUIRES ASSESEMENT state without any static object linked 
	#Given User is on Card Index screen for a 'Create intelligence report' 
	When User read the test data sheet "Intel_ST" from file "SmokeTestData" 
	And User read the test data for cards on sheet "Intel_ST_Cards" from file "SmokeTestData" 
	
	When User clicks on "Basic details" card with Link Reason "" 
	And User has completed all the fields on 'Basic Details' card 
	And User saves "Basic Details" card 
	#Then Logout from an application and close the browser

#	When User clicks on "Source" card with Link Reason "" 
#	And User has completed all the fields on "Source details" form on "Source" card with Link Reason "" 
#	And User saves "Source" card 
#	
#	When User clicks on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Submission" form on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Provenance" form on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Risk factors" form on "Submission" card with Link Reason "" 
#	And User saves "Submission" card 
#	
#	When User sets the following card as 'Not Applicable' 
#	And All the cards on the card index are in following status 
#	And User submits 'Create intelligence report task' card 
#	And Event record selected in workload tab 
#	And Event status will be set to "REQUIRES ASSESSMENT" 
#	And Task history entry "Create Intelligence Report" will be created 
#	Then Logout from an application and close the browser
#	
##Scenario 2
#@run @REGQA1 @DEVINT2 @REGQA2 @FUNCQA1 @TestCaseKey=CCI-T55791
#Scenario: Create Intelligence record with all the static object linked 
#	Given User is on Card Index screen for a 'Create intelligence report' 
#	When User read the test data sheet "IntelProdWF12" from file "SmokeTestData" 
#	And User read the test data for cards on sheet "IntelProdWF12_Cards" from file "SmokeTestData" 
#	#
#	When User clicks on "Basic details" card with Link Reason "" 
#	And User has completed all the fields on 'Basic Details' card 
#	And User saves "Basic details" card 
#	#
#	When User clicks on "Source" card with Link Reason "" 
#	And User has completed all the fields on "Source details" form on "Source" card with Link Reason "" 
#	And User saves "Source" card 
#	#
#	#Submission > Handling code = P
#	When User clicks on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Submission" form on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Provenance" form on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Risk factors" form on "Submission" card with Link Reason "" 
#	And User saves "Submission" card 
#	#
#	#Link a new person object
#	When User clicks on "Person" card with Link Reason "Subject of" 
#	And User has completed all the fields on the "Person" card with Link Reason "Subject of" 
#	And User saves "Person" card with Link Reason "Subject of" 
#	#
	#Link a new Location object
#    When User clicks on "Location" card with Link Reason "Subject of" 
#	And User has completed all the fields on the "Location" card with Link Reason "Subject of" 
#	And User saves "Location" card with Link Reason "Subject of" 
#	#
#	#Link a new Vehicle object
#	When User clicks on "Vehicle" card with Link Reason "Subject of" 
#	And User has completed all the fields on the "Vehicle" card with Link Reason "Subject of" 
#	And User has completed all the fields on "Main details" form on "Vehicle" card with Link Reason "Subject of" 
#	And User saves "Vehicle" card with Link Reason "Subject of" 
#	#
#	#Link a new Organisation object
#	When User clicks on "Organisation" card with Link Reason "Subject of" 
#	And User has completed all the fields on the "Organisation" card with Link Reason "Subject of" 
#	And User saves "Organisation" card with Link Reason "Subject of" 
#	#
#	And All the cards on the card index are in following status 
#	#--All will be in completed status
#	#
#	And User submits 'Create intelligence report task' card 
#	#
#	And Event record selected in workload tab 
#	And Event status will be set to "REQUIRES ASSESSMENT" 
#	And Task history entry "Create Intelligence Report" will be created 
#	Then Logout from an application and close the browser
#
#
##Scenario 3
#@run @DEVINT2
#Scenario: Create an Intel and perform task 'Assess Intelligence Report' so that report can be Returned for deletion 
#	Given User is on Card Index screen for a 'Create intelligence report' 
#	When User read the test data sheet "Intel_ST" from file "SmokeTestData" 
#	And User read the test data for cards on sheet "Intel_ST_Cards" from file "SmokeTestData" 
#	
#	When User clicks on "Basic details" card with Link Reason "" 
#	And User has completed all the fields on 'Basic Details' card 
#	And User saves "Basic Details" card 
#	
#	When User clicks on "Source" card with Link Reason "" 
#	And User has completed all the fields on "Source details" form on "Source" card with Link Reason "" 
#	And User saves "Source" card 
#	
#	When User clicks on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Submission" form on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Provenance" form on "Submission" card with Link Reason "" 
#	And User has completed all the fields on "Risk factors" form on "Submission" card with Link Reason "" 
#	And User saves "Submission" card 
#	
#	When User sets the following card as 'Not Applicable' 
#	And All the cards on the card index are in following status 
#	And User submits 'Create intelligence report task' card 
#	And Event record selected in workload tab 
#	And Event status will be set to "REQUIRES ASSESSMENT" 
#	And Task history entry "Create Intelligence Report" will be created 
#	And "Assess intelligence report" task will be raised to 'Intel Submitter' 
#	
#	When User is on Card Index screen for a 'Assess intelligence report' 
#	And User clicks on "Assess intelligence report" card with Link Reason "" 
#	And User has completed all the mandatory fields on 'Assess Intelligence report' card 
#	And User sets the following card as 'Not Applicable' 
#	And All the cards on the card index are in following status 
#	And User submits 'Assess Intelligence Report' card 
#	
#	When User selects 'My View' tab on Workload screen 
#	And Event status will be set to "TO BE DELETED"
#	And "Acknowledge intelligence report returned or deleted" task will be raised to 'Intel Submitter' 
#	
#	When User is on Card Index screen for a 'Acknowledge Intelligence Report Returned Or Deleted' 
#	And User clicks on "Acknowledge intelligence report returned or deleted" card with Link Reason "" 
#	And User has completed all the mandatory fields on 'Acknowledge intelligence report returned or deleted' card 
#	And User saves "Acknowledge intelligence report returned or deleted" card 
#	And All the cards on the card index are in following status 
#	
#	When User submits 'Acknowledge intelligence report returned or deleted' card 
#	And Event record selected in workload tab
#	And Event status will be set to "REQUIRES ASSESSMENT" 
#	And Task history entry "Acknowledge Intelligence Report Returned Or Deleted" will be created 
#	Then Logout from an application and close the browser 