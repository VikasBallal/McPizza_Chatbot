#Author: test@mcpizza.com
#Keywords Summary :
Feature: Order different types of veg pizzas through McPizza agent chatbot
  
  McPizza is one of the AI Agent developed on Avaamo platform for testing and assignment purpose.
  
  This feature enables different types of non-veg pizza ordering facility using McPizza agent chatbot with basic details like name and email address.

  @OrderVegPizza @OrderVegPizza_NoQuickReplies
  Scenario Outline: Order different types of veg pizza and validate the order creation without using quick replies in the chatbot
    Given Navigating to Avaamo chatbot website for a given browser
      | browserType   |
      | <browserType> |
    And I click on McPizza agent chatbot and start the chat
    When I login to McPizza agent with <'Test User'> and <'test@mcpizza.com'>
    And I enter a message and click on send
      | question   |
      | <question> |
    Then I should see selections for veg and non-veg pizza
    When I enter a message and click on send
      | pizzaType   |
      | <pizzaType> |
    And I enter a message and click on send
      | toppings   |
      | <toppings> |
    And I enter a message and click on send
      | base   |
      | <base> |
    And I enter a message and click on send
      | base   |
      | <size> |
    Then I should see the order details are matching with selections
      | pizzaDetails |
      | <pizzaType>  |
      | <toppings>   |
      | <base>       |
      | <size>       |
    And I confirm the order details as <'Yes'>
    Then I should see the order getting created successfully <'CONGRATS ! ORDER PLACED .'>

    Examples: 
      | browserType | question              | pizzaType | toppings | base        | size  |
      | chrome      | I want to order pizza | veg       | Cheese   | Thick Crust | Small |

  @OrderVegPizza @OrderVegPizza_QuickReplies
  Scenario Outline: Order different types of veg pizza and validate the order creation using the quick replies in the chatbot
    Given Navigating to Avaamo chatbot website for a given browser
      | browserType   |
      | <browserType> |
    And I click on McPizza agent chatbot and start the chat
    When I login to McPizza agent with <'Test User'> and <'test@mcpizza.com'>
    And I ask a question <'I want to order pizza'> to the chat bot
    Then I should see selections for veg and non-veg pizza
    When I choose pizza type
      | pizzaType   |
      | <pizzaType> |
    And I choose pizza toppings as
      | toppings   |
      | <toppings> |
    And I click on submit
    And I choose pizza base as
      | base   |
      | <base> |
    And I choose pizza size as
      | base   |
      | <size> |
    Then I should see the order details are matching with selections
      | pizzaDetails |
      | <pizzaType>  |
      | <toppings>   |
      | <base>       |
      | <size>       |
    And I confirm the order details as <'Yes'>
    Then I should see the order getting created successfully <'CONGRATS ! ORDER PLACED .'>

    Examples: 
      | browserType | pizzaType | toppings | base       | size  |
      | chrome      | veg       | Cheese   | Thin Crust | Small |
      | firefox     | veg       | Cheese   | Thin Crust | Large |

  @OrderVegPizza @OrderVegPizza_ThumbsUpFeedback
  Scenario Outline: Order different types of veg pizza and provide thumbs up feedback
    Given Navigating to Avaamo chatbot website for a given browser
      | browserType   |
      | <browserType> |
    And I click on McPizza agent chatbot and start the chat
    When I login to McPizza agent with <'Test User'> and <'test@mcpizza.com'>
    And I ask a question <'I want to order pizza'> to the chat bot
    Then I should see selections for veg and non-veg pizza
    When I choose pizza type
      | pizzaType   |
      | <pizzaType> |
    And I choose pizza toppings as
      | toppings   |
      | <toppings> |
    And I click on submit
    And I choose pizza base as
      | base   |
      | <base> |
    And I choose pizza size as
      | base   |
      | <size> |
    And I confirm the order details as <'Yes'>
    And I click on thumbs up feedback button
    And I select the feedback type
      | feedback   |
      | <feedback> |
    And I click on submit
    Then I sould see <'Thank You for Your Support'> feedback message

    Examples: 
      | browserType | pizzaType | toppings | base        | size   | feedback |
      | chrome      | veg       | tomato   | Thick Crust | Medium | Good     |
