Feature: API Rest for users management

  As an API consumer, I want to use a Rest API to manage users in the system

  Scenario: Creating users
    When the client requests for creating Ismael user
    Then the user is created
    And the user has the following attributes:
      | attribute | type   | value  |
      | name      | String | Ismael |

  Scenario: Getting a given user by identifier
    Given the system knows about Beatríz user
    When the client requests for getting his information
    Then the user is got
    And the user has the following attributes:
      | attribute | type   | value  |
      | name      | String | Beatríz |

  Scenario: Updating a given user
    Given the system knows about David user
    When the client request for updating his name to Davicillo
    Then the user is updated
    And the user has the following attributes:
      | attribute | type   | value     |
      | name      | String | Davicillo |