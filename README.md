# Management of purchases module
Airline Client project winter semester 2019/2020


## Introduction
Management of purchases is the module in the Airline client project realised in terms of the Software Engineering course. The main purpose of this module is to provide the user with a flexible module managing the purchases of the chosen flight seats, update the state of available seats in the Airline database and send an e-mail with a ticket it generates.

## Guidelines
The guidelines of the module are as follows:
>
- Shopping basket - essentially a list of chosen seats, which are yet to be bought. Shopping basket supports actions such as deleting and adding the item within the list.
- Checkout - purchasing the items in the shopping basket, supporting the dual mode: purchasing the seats for the registered and the non-registered user.
- Ticket service - collection of the required data that generates the ticket for a given flight, which is sent to the user with the means of an e-mail.
- E-mail service - sending the generated ticket to the user e-mail either existing in the user profile or the one provided by the user in case of a non-registered user purchase.
- Payment method - the choice of committing the transactions with the means of either credit card or the transfer, to be implemented in future with the support of services such as PayPal etc.

## Requirements
### Functional Requirements
>
- Adding and deleting elements in the shopping cart
- Purchasing the seats that are in shopping cart
- Updating the database regarding availability flights and user information
- Sending tickets via email
### Non-Functional Requirements
>
- Retrieving and updating the data in database using SQL queries
- Java language for backend purposes
- Use of pre-made libraries and APIs
