Feature: Get countries by region
  @pending
  Scenario Outline: user calls webservice to get details of all countries in a regional bloc
    When a user retrieves all details of all countries in regionalbloc <regionalbloc>
    Then <totalnumber> of countries and details should match
    Examples:
    |regionalbloc|totalnumber|
    |  eu        |    32     |
    | saarc      |    7      |