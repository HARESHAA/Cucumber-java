
Feature: Checking login page using DataProvider annotation
  
  Scenario Outline: Validating Login page using examples
    Given User has Chrome Browser
    When User mentions the mailid as "<email>" and password as "<pwd>"
    And User hits the Login
    Then User verifies the "<status>" 

    Examples: 
      | email               | pwd   | status  |
      | xyz@gmail.com       | sudhir| Invalid |
      | abc@gmail.com       | hare  | Invalid |
      | admin@yourstore.com | admin | Valid   |
