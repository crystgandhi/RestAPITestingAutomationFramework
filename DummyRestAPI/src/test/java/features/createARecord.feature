Feature: Create employee data in the database
Scenario: Validate creation of emloyee data
Given create employee data  
When   user calls "AllEmployeeDataAPI" with "Get" http request
Then   the API call got success with status code 200
And "status" in response body is "success"

Scenario: Attempt to retrieve employee data with invalid HTTP method
Given create employee data
When the user calls the "AllEmployeeDataAPI" with a "POST" HTTP request
Then the API call fails with an appropriate error status code
And the response body contains an error message indicating that the HTTP method is invalid

Scenario: Attempt to retrieve employee data with incorrect endpoint
Given create employee data
When the user calls an incorrect endpoint with a "GET" HTTP request
Then the API call fails with an appropriate error status code
And the response body contains an error message indicating that the endpoint is not found

Scenario: Attempt to retrieve employee data with missing authentication
Given create employee data
When the user calls the "AllEmployeeDataAPI" with a "GET" HTTP request without authentication
Then the API call fails with an appropriate error status code
And the response body contains an error message indicating that authentication is required

Scenario: Validate creation of emloyee data
Given create employee data  
When   user calls "CreateNewEmployeeDataAPI" with "Get" http request
Then   the API call got success with status code 200
And "status" in response body is "success"

Scenario: Attempt to create employee data without required parameters
Given no employee data is provided
When the user calls the "CreateNewEmployeeDataAPI" with a "POST" HTTP request
Then the API call fails with an appropriate error status code
And the response body contains an error message indicating that required parameters are missing

Scenario: Attempt to create employee data with invalid data format
Given invalid employee data is provided
When the user calls the "CreateNewEmployeeDataAPI" with a "POST" HTTP request
Then the API call fails with an appropriate error status code
And the response body contains an error message indicating that the data format is invalid

Scenario: Attempt to create employee data with insufficient permissions
Given the user lacks the necessary permissions to create employee data
When the user calls the "CreateNewEmployeeDataAPI" with a "POST" HTTP request
Then the API call fails with an appropriate error status code
And the response body contains an error message indicating insufficient permissions