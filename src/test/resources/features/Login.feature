Feature: Amazon Login Feature

Scenario: Amazon login scenario

Given User is on amazon landing page
And user clicks on signin tab
When user enters username
|Mishrask637@gmail.com|
And user clicks on signin button
And user enters password
|637Mishra|
And user clicks on signinsubmit button
#Then user navigates to home page and title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"