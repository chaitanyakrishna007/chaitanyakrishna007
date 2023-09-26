@tag
Feature: Error Handling
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on the login page
    When I logged in with userName <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  										| password	| 
      | rahulshetty167@gmail.com  |Vamshi	|		