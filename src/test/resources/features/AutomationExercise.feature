Feature: To use Automation-Exercise web application

  Scenario Outline: To add product
    Given User is on home page
    Then selects product "<productname>"
    Then clicks on cart button and verify the product

    Examples:
      | productname |  |
      | Jeans       |  |