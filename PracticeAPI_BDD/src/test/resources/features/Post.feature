Feature: Validating Place API's

Scenario: verify if Place is being Successfully added using AddplaceAPI
Given AddPlace Payload
When user calls "AddplaceAPI" with post https request
Then the Api call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"