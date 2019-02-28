@LoginFunctionality
Feature: PHP login feature

Background:
Given User navigate to Php webpage
And title is php.com

Scenario Outline: PHP valid login test scenario
Then user click on My Account icon and select Login option
Then user enter Username as "<username>" and Password as "<password>" and click login button

Then user is on homepage
Examples:
|username|password|
|aka@hotmail.com|akaeby|
|nloksfg@gmail.com|123qwer|


Scenario Outline: Php invalid Login test scenario
Then user click on My Account icon and select Login option
Then user enter Username as "<username>" and Password as "<password>" and click login button


Then error message is thrown
Examples:
|username|password|
|aka@hotmail.com|akaeby|
|nloksfg@gmail.com|123qwer|

 