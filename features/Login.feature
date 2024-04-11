Feature: Login page Automation of Salesforce application
Background: This is to launch application
Given User has opened the application url
And Navigated to login page

Scenario: Login with valid credentials
When User enters the valid username "teena@raghav.com"
And User enters the valid password
And Click on login button
Then User should be able to successfully login
And Close the browser

Scenario: Login with invalid credentials
When User enters the invalid username "tea@raghav.com"
And User enters the valid password
And Click on login button
Then User should not able to successfully login
And Get a proper warning message

 
