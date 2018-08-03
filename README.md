# Guest Messaging
An API providing a customizable message template for hotels to send guests upon arrival or departure from multiple data files.

## Dependencies
- NetBeans (or Java IDE of your choice)
- Spring Boot
- Gson
- Postman

## Getting Started
1. Pull this `guest-messaging` repository to your local directory.
2. Import the project `src/guest-messaging` into NetBeans or a Java IDE of your choice.
3. Run the API in NetBeans or a Java IDE of your choice. 
4. Use Postman to test the API to `GET` or `POST` JSON data. 

## Overview of Decisions
#### Language/Framework Choice:
I decided to use Spring Boot framework as it allowed me to quickly build and create an application without having to manually configure the beans and dependencies. I decided to go with the Gson library for parsing my Json data as I found from my research that Gson was quickest with parsing smaller files in comparison to Jackson or JSON.simple. I chose to stick with Java as it's the language that I have the most experience in currently. I'm trying to gain more experience and a solid understanding of how Java and it's different frameworks work before moving onto other object oriented programming languages. 

#### Design Choice:
I split the application up into three different layers for each different model/object. The model layer includes all of the objects that were to be passed through. The DAO for each model to access the data from the JSON files and pass it to the controller. A controller was also created for each different model to handle the request mapping and http requests.   

#### Process for Verification:
I used Postman to verify whether the correct JSON data was being retreived or created. Postman was also used to determine whether the input of the company & guest data were being updated accurately instead of the placeholders. 

## Improvements to make
When initially starting on the project, I was planning to add all the CRUD (create, read, update and delete) functionality for the companies, guests, and messages json files, however, it took me longer than expected to have the get the JSON data parsed correctly to a Java pojo. Additionally, with the added functionality, I think it would be important to also then add some security to only allow an admin access to create, update and delete the JSON data. Once all these features are added, I would also like to add a GUI to make the process easier for a user to create, update or delete the data using Thymeleaf. 
