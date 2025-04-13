Feature: Login to Mobile Application

  Scenario: Successful login with valid credentials
    Given User Click Login button on Sidebar
    When User enters valid username and password
    And User taps the login button
    Then User should be redirected to the Home Page
