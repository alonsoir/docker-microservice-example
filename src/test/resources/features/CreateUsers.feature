Feature: API Rest for users management

  As an API consumer, I want to use a Rest API to manage users in the system

  Scenario: Creating users
    When the client requests for creating Ismael user
    Then the response is OK
    And the user has the following attributes:
      | attribute | type   | value  |
      | name      | String | Ismael |

