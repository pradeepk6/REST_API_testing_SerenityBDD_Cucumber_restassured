Feature: Get all country names
As a user
I want to be able to see all countries in the world
So that I can then choose which country to see further details about

  Scenario: user calls webservice to get all country names
    When a user retrieves all country names
    Then names and total number of countries should match
