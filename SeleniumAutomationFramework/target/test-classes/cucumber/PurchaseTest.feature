@tag
Feature: Purchase the Order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on the login page
  

  @tag1
  Scenario Outline: Positive Test for Purchasing the Order
    When I logged in with userName <name> and password <password>
    When add product <productname> to cart
    And checkout <productname> and submit the order
    Then select the country and click on ok

    Examples: 
      | name  										| password	| productname |
      | rahulshetty1467@gmail.com |Vamshi@123	|	ZARA COAT 3 |							
