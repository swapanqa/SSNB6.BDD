#Author: Iftekhar Ivaan
#Keywords Summary : Login
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
#@tag
Feature: Spree login functionality
  This explain how verious login functionality will work

  Background:
  	Given Not a validated user
	  When User browse to the site
	  Then Spree home page should display
	  When User click login link
	  Then Browser display Login page
	  
  @Aceptance
  Scenario: 1.Valid user with valid password
	  When User enter user email as "shiftqa1@gmail.com"
	  And User enter password as "shiftedtech"
	  And User click login button
	  Then Home page should display
	  And Login success message display

  @Functional 
  Scenario: 2.Invalid user with valid password
	  When User enter user email as "invalid@gmail.com"
	  And User enter password as "shiftedtech"
	  And User click login button
	  Then Browser display Login page
	  And Login not success message "Invalid email or password." display
	
	@Smoke @Functional 
	Scenario Outline: 3.Valid user with valid password Data Driven
	  When User enter user email as "<EmailAddress>"
	  And User enter password as "<Password>"
	  And User click login button
	  Then Home page should display
	  And Login success message display
	 Examples:
      |EmailAddress        |Password    |
      |shiftqa1@gmail.com	 |shiftedtech |
      |arifurkh64@yahoo.com|iq9006564		|
	  