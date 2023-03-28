  #Author: vikasbalal@gmail.com
  #Keywords Summary : McPizza is one of the AI Agent developed on Avaamo platform for testing and assignment purpose. 

Feature: 
  
  This feature enables different types of pizza ordering facility using McPizza agent chatbot with basic details 
  like
  name and email address.

Test Data:
    -Url: https://c6.avaamo.com/web_channels/c767654d-6709-43f6-bb0c-ce1d2c559f6a/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up
    - User Name: Test User
    - Email Id: test@mcpizza.com
  
Scenario: McPizza chatbot icon, GIF arrow and pop up window should be present on the Avaamo AI Agent website.
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  Then I should see GIF image with down arrow point at McPizza chatbot icon
  And I should also see McPizza chatbot icon poping up along with  pop up window with close button containing Welcome to pizza shoppe message on it.

Scenario: McPizza chatbot icon should contain the pizza image.
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  Then I should see pizza image on the McPizza chatbot icon

Scenario: Click on McPizza agent chatbot Icon pop up window close button should produce an alert sound with Getstarted button on the chat window
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot Icon pop up window close button
  Then I should hear the chat alert sound and the pop up should be closed


Scenario: Click on McPizza agent chatbot should produce an alert sound with Getstarted button on the chat window
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  Then I should hear the chat alert sound with GetStarted button on the chat window


Scenario: Clicking Getstarted button on the chatbot chat window should take me to login page
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  Then I should land on login page


Scenario: Login to the McPizza chatbot using a valid username and passowrd should take me to welcomepage 
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  Then I should land on welcomepage with a <'welcomemessage'>
  And I sould see an image with text saying Welcome To Make My Assignments


Scenario: Login to the McPizza chatbot using a username and invalid email address format should not allow login
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and invalid <'emailAddress'>
  Then I should not be allowed to login and a message about invalid email address should be displayed

Scenario: Click on McPizza agent chatbot close button should minimize the chat window
  When I click on McPizza agent chatbot icon
  And I click on Getstarted button 
  And I provide valid <'userName'> and valid <'emailAddress'>
  And I ask a question <'I want to Order Pizza'>
  And I select pizza type as <'veg'>
  And I click chatwindow close button at the bottom or on the chatbox top right corner
  Then Chat window should be minimized
  When I click on McPizza agent chatbot icon
  Then Chat window should open with all the previous conversation


Scenario: Login to the McPizza chatbot Order a veg pizza with different combinations
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a question <'I want to Order Pizza'>
  And I select pizza type as <'veg'>
  And I select the pizza <'toppings'>
  And I select the pizza <'base'>
  And I select the pizza <'size'>
  And I confirm the order details
  Then I should see a order successfully placed message
  Examples:
    |toppings|base|size|
    |becon|thin crust|small|
    |becon|thin crust|meduim|
    |becon|thin crust|large|
    |becon|thik crust|small|
    |becon|thik crust|meduim|
    |becon|thik crust|large|
    |tomato|thin crust|small|
    |tomato|thin crust|meduim|
    |tomato|thin crust|large|
    |tomato|thik crust|small|
    |tomato|thik crust|meduim|
    |tomato|thik crust|large|

Scenario: Login to the McPizza chatbot Order a veg pizza and provide thumbs-up feedback for all the three ratings
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a question <'I want to Order Pizza'>
  And I select pizza type as <'veg'>
  And I select the pizza <'toppings'>
  And I select the pizza <'base'>
  And I select the pizza <'size'>
  And I confirm the order details
  And I provide the feedback based on <'taste'>
  Then I should see a thank you for your feedback message.
  Examples:
    |toppings|base|size|feedback|
    |becon|thin crust|small|Bad|
    |tomato|thin crust|large|Average|
    |tomato|thik crust|large|Good|

Scenario: Login to the McPizza chatbot Order a veg pizza and provide thumbs-down feedback
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a question <'I want to Order Pizza'>
  And I select pizza type as <'veg'>
  And I select the pizza <'toppings'>
  And I select the pizza <'base'>
  And I select the pizza <'size'>
  And I confirm the order details
  And I provide the thumbs-down feedbac
  Then I should see a thank you for your feedback message.
  Examples:
    |toppings|base|size|
    |becon|thin crust|small|


Scenario: Login to the McPizza chatbot Order a non-veg pizza with different combinations
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a question <'I want to Order Pizza'>
  And I select pizza type as <'non-veg'>
  And I select the pizza <'toppings'>
  And I select the pizza <'base'>
  And I select the pizza <'size'>
  And I confirm the order details
  Then I should see a order successfully placed message
  Examples:
    |toppings|base|size|
    |chicken|thin crust|small|
    |chicken|thin crust|meduim|
    |chicken|thin crust|large|
    |chicken|thik crust|small|
    |chicken|thik crust|meduim|
    |chicken|thik crust|large|
    |prawns|thin crust|small|
    |prawns|thin crust|meduim|
    |prawns|thin crust|large|
    |prawns|thik crust|small|
    |prawns|thik crust|meduim|
    |prawns|thik crust|large|


Scenario: Login to the McPizza chatbot Order a non-veg pizza and provide thumbs-up feedback for all the three ratings
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a question <'I want to Order Pizza'>
  And I select pizza type as <'non-veg'>
  And I select the pizza <'toppings'>
  And I select the pizza <'base'>
  And I select the pizza <'size'>
  And I confirm the order details
  And I successfully place the order
  And I provide the feedback based on <'taste'>
  Then I should see a thank you for your feedback message.

  Examples:
    |toppings|base|size|
    |chicken|thin crust|small|
    |chicken|thin crust|large|
    |prawns|thik crust|large|

Scenario: Login to the McPizza chatbot Order a non-veg pizza and provide thumbs-down feedback
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a question <'I want to Order Pizza'>
  And I select pizza type as <'non-veg'>
  And I select the pizza <'toppings'>
  And I select the pizza <'base'>
  And I select the pizza <'size'>
  And I confirm the order details
  And I provide the thumbs-down feedbac
  Then I should see a thank you for your feedback message.
  Examples:
    |toppings|base|size|
    |chicken|thin crust|small|


Scenario: Login to the McPizza chatbot and ask the same question repeatedly several times and validate the answer
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a same <'question'> repeatedly
  Then I should see the chatbot giving the same <'answer'> repeatedly
  Examples:
    |question|answer|
    |how old are you?|I do not know|
    |how old are you?|I do not know|
    |how old are you?|I do not know|
    |how old are you?|I do not know|
    |how old are you?|I do not know|
    |how old are you?|I do not know|
    |how old are you?|I do not know|


Scenario: Login to the McPizza chatbot and ask smaltalk questions and validate the answers
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a smaltalk <'question'>
  Then I should see the chatbot giving the <'answer'> related to the question asked
  Examples:
    |question|answer|
    |how old are you?|I don't know. My maker hasn't told me.|
    |Where did you come from?|I was developed in Silicon Valley but now I roam the internet unless I'm being summoned.|
    |Where did you get your name?|I am sorry. I don't have an answer for that.|
    |Are you a robot?|Yes I am! Did I have you fooled?|
    |where do you live?|I live in cyberspace, for now.|

Scenario: Login to the McPizza chatbot and ask few meaning less questions and validate the answers
  Given Navigating to Avaamo Ai Agent website using the Url <'Url'>
  When I click on McPizza agent chatbot 
  And I click on Getstarted button 
  And I provide valid <'userName'> and <'emailAddress'>
  And I ask a smaltalk <'question'>
  Then I should see the chatbot giving the <'answer'> related to the question asked
  Examples:
    |question|answer|
    |how far is the earth from sky?|I am sorry. I don't have an answer for that.|
    |Do you speak local language?|It should give me options to chat with a live agent and No, that's not it cancellation|

