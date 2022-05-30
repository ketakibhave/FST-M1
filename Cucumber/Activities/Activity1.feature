@activity1
  Feature: Google Search

    Scenario: Performing a Google Search for Cheese
      Given User is on Google Home Page
      When User types in Cheese and hits Enter
      Then Show how many searches were shown
      And Close the browser