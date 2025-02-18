Feature: OrangeHRM Login

Background:
Given User opens OrangeHRM login page

  Scenario: Successful Login with valid credentials
  Then User should able to see the OrangeHRM logo on the Login page
  When User enters username as "Admin" and password as "admin123"
  And User clicks on login button
  Then User should be redirected to the dashboard



 
    
    