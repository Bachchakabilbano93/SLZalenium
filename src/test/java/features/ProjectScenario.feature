Feature: TestAutomasi Search

Scenario Outline: Check the Search functionality for TestAutomasi

Given The user is on TestAutomasi Home Page
When The user clicks on E-Learning
When The user searches for <Courses>
Then Verify the correct Course is displayed
When The user clicks on View More
Then Verify that the correct Course page is opened

Examples:
|Courses|
|Jmeter|
|Selenium|
|Appium|