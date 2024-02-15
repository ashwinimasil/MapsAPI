Feature: To validate the CRUD operations

Scenario: To create a new request for maps
Given Enter the end point url
And Send the body
Then validate the statuscode as 200

Scenario: To update a new request for maps
Given Send the body for update
Then validate the statuscode as 200

Scenario: To delete a new request for maps
Given Send the body for delete
Then validate the statuscode as 200

Scenario: To get a new request for maps
Given Send the body for get locations
Then validate the statuscode as 200
