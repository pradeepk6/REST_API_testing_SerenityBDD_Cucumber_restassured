Feature: Get country details by fullname

  Scenario Outline:call webservice with fullname of a country to get all details of that country
    When a user retrieves a <country> by fullname
    Then all details of that country should match
    Examples:
    | country |
    | United Kingdom of Great Britain and Northern Ireland |
    | India                                                |

