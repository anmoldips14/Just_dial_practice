Feature: To check the sign_up function

Background:Navigation to the url
  Given User navigates to the application url
@1

  Scenario:  User is able to Sign up in the application
    #Given User navigates to the application url
    When User clicks on Sign up link at the top right corner of the application
    And User enters name as "Akash" and Phone number as "9730486281" and clicks on Submit Button
    Then User is displayed with the message as "OTP is sent on number"

  Scenario:  User receives an error message when tries to enter incorrect mobile number in the Login pop up
    #Given User navigates to the application url
    When User clicks on Login-in link at the top right corner of the application
    And User enters name as "Akash" and Phone number as "1234567890" and clicks on Submit Button
    Then User gets error message as "Please Enter valid Mobile number!"

  Scenario:  User receives an error message when tries to enter incorrect name in the Login pop up
    #Given User navigates to the application url
    When User clicks on Login-in link at the top right corner of the application
    And User do not enter any name and phone number but clicks on Submit Button
    Then User gets error message as "Please enter a valid name !!"


  Scenario: 4. User is able to enter only 10 digits in the Mobile Text box
    #Given User navigates to the application url
    When User clicks on Login-in link at the top right corner of the application
    Then User is able to enter only "10" digits in the Mobile text field
