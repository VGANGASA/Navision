#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Create a script to enter 5 rows into Navision from a datasheet, using Java, JS or Python


  @tag1
  Scenario: Enter 5 rows into Navision from a datasheet
    Given user navigate to the URL https://talent.capgemini.com/uk
    And user should see the home page
    When user should navigate to the Navision page
    And user should see the Navision page
    Then user should able to enter the data into rows
    
   

 