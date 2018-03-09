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


@DeliveryModule
Feature: Look for the open roles in the delivery module

  @OpenRole
  Scenario: Title of your scenario
    Given user navigate to the url
    And verify the homepage title
    And user able click on the BUs
    And user able click on the SogetiUK
    When user clicked on the Sogeti UK should see BUSINESS UNITS
    And user should able to click delivery
    And  user should able to click open roles
    Then user should see Open Roles
    And user able to click on here
    Then user should able to see Open Roles in new window
    Then user should able to find the suitable role
    
   
