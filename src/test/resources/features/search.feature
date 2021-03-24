Feature: Search A Product Feature

Scenario: Search a mobile device

Given user is already logged in
|username|password|
|mishrask637@gmail.com|637Mishra|
And user can navigate to signout button
When user enters "Mobile Phone" in search field
And user clicks on Go button
Then user clicks on first available product
And user navigates back to home page
Then user clicks on logout