@Test
Feature: F01_Search | Validating search results between pages on Bing

  Background: The browser is opened and URL is navigated

  Scenario Outline:
    When user searches for "<SearchQuery>" on Bing
    And user scroll down and click on the second page of search
    And the second page results are counted
    And user moves to the third page
    Then the number of search results on the second page should be equal to the number on the third page
    Examples:
      |  SearchQuery  |
      |   Vodafone    |
