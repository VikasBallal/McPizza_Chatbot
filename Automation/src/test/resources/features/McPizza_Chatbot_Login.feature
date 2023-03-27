#Author: vikasbalal@gmail.com
#Keywords Summary :
Feature: Login McPizza agent chatbot
  
  McPizza is one of the AI Agent developed on Avaamo platform for testing and assignment purpose.
  
  This feature enables login facility to McPizza agent chatbot with basic details like name and email address for ordering pizza's.

  @Login
  Scenario Outline: Validate login functionality of McPizza agent chatbot
    Given Navigating to Avaamo chatbot website for a given browser
      | browserType   |
      | <browserType> |
    And I click on McPizza agent chatbot and start the chat
    When I login to McPizza agent with <'Test User'> and <'test@mcpizza.com'>
    Then I sould land on welcome page with welcome message <'Welcome to McPizza Booking Journey'>

    Examples: 
      | browserType |
      | chrome      |
      | firefox     |
