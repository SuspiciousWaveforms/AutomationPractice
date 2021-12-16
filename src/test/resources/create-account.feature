@selenium
  Feature: Create account

    As a user, I want to create an account so that I can sign in to purchase items.

  Scenario: Successfully creates an account
    Given the user is on the 'Sign in' page
    When the user creates an account
    Then the user should be on the 'My account' page




#  test@testersonsfdsfs.com
#  password