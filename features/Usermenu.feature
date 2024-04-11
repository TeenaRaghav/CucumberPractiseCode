Feature: Click on Usermenu

Scenario: click on Usermenu button
Given User is on Salesforce application Login page
When user enters the valid username "teena@raghav.com"
And user enters the valid password
Then Clicks on login button
When user clicks on usermenu button
Then the usermenu dropdown should displayed
And Browser Should be Closed
 