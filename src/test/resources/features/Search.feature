@smoke
Feature: To check the search functionality

  Background:Navigation to the url
    Given User navigates to the application url

  @regression
  Scenario:  User is able to search the Application
    When User enters "restaurants" in search text box
    And User clicks search button
    Then User is able to see search result related to "restaurants"

  Scenario:  User is able to see the drop down when he keys in the text in the search box
    When User enters "resta" in search text box
    Then User is able to see the drop down under search text box with all the items with text "resta"