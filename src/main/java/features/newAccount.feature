@FunctionalTest
Feature: PHP Account creation feature
Background:
Given User navigate to Php webpage
And title is php.com


@negativeScenario
Scenario: Account creation
Then user click on My Account icon and select Sign up option
Then User land on Registration page
Then User enters invalid Credentials to create account

|First_Name|Last_Name|Mobile_Number|Email|Password|confirm_Password|
|Iknoqw|righgt|1456336| |asdfgh|asdfgh|
| aaron213|meand|12345|aaron123|aaron123|aaron123|
|_wakll|ask54|1246313456|123@you.net|qwoqwo|qwaqwo|
|meg|125akso|1.24379E+11|meg@you.com|en123|en123|

Then Account creation is not  successfull



 @positiveScenario
Scenario: Account creation
Then user click on My Account icon and select Sign up option
Then User land on Registration page
Then User enters Valid Credentials to create account

|First_Name|Last_Name|Mobile_Number|Email|Password|confirm_Password|
|year|weorot|1223444455|wqor@qwe.com|qwerty|qwerty|

Then Account creation is successfull

 
