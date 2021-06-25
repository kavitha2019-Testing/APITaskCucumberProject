Feature: Post tests
  Scenario: Create a Post
    Given I have details of a Post
    When I create a Post
    Then Post should be created


  Scenario: Get a Post
    When I request details of all Posts
    Then the details of all Posts should be returned









