#Author: vikasbalal@gmail.com
#Keywords Summary :
Feature: Order different types of non-veg pizzas through McPizza agent chatbot
  
  McPizza is one of the AI Agent developed on Avaamo platform for testing and assignment purpose.
  
  This feature enables different types of non-veg pizza ordering facility using McPizza agent chatbot with basic details like name and email address.

  Background: Navigate and login to McPizza chatb
    Given Navigating to Avaamo chatbot website
    And I click on McPizza agent chatbot and start the chat
    When I login to McPizza agent with <'Test User'> and <'test@mcpizza.com'>
    Then I sould land on welcome page with welcome message <'Welcome to McPizza Booking Journey'>

  @OrderNonVegPizza @OrderNonVegPizza_NoQuickReplies
  Scenario Outline: Order different types of non-veg pizza and validate the order creation without using quick replies in the chatbot
    Given I enter a message and click on send
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
      | size   |
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
      | question              | pizzaType | toppings  | base        | size  |
      | I want to order pizza | non-veg   | Pepperoni | Thick Crust | Large |

  @OrderNonVegPizza @OrderNonVegPizza_QuickReplies
  Scenario Outline: Order different types of non-veg pizza and validate the order creation using the quick replies in the chatbot
    Given I ask a question <'I want to order pizza'> to the chat bot
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
      | pizzaType | toppings | base        | size  |
      | non-veg   | bacon    | Thick Crust | Small |

  @OrderNonVegPizza @OrderNonVegPizza_ThumbsDownFeedback
  Scenario Outline: Order different types of non-veg pizza and provide thumbs down feedback
    Given I ask a question <'I want to order pizza'> to the chat bot
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
    And I click on thumbs down feedback button
    And I enter feedback improvement message <'Needs improvemet over taste'>
    And I click on submit
    Then I sould see <'Thank You for Your Valuable Feedback'> feedback message

    Examples: 
      | pizzaType | toppings  | base        | size   |
      | non-veg   | Pepperoni | Thick Crust | Medium |
