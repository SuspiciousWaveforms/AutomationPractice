@selenium
  Feature: Search for items

    As a user, I want to search for Summer dresses, so that I can look at what dresses are in stock

  Scenario:
    Given the user is on the 'My account' page
    When the user searches for 'Summer dress'
    Then the user should see items that are summer dresses