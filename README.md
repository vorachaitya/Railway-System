# ***Railway System***
## Description
***Railway System*** is a terminal based project wherein you can book railway tickets as well as perform various opeartions on the existing railway system.  
  
  According to your eligibility,you can access any of login mentioned below: 
  * Administration Login
  * User Login
  * Agent Login
## Key Features
Given below is a short description about the features that each Login provides:  
  
**1.Administration Login**    
 * Add new coach to a train (Max : 2) (Capacity of One coach: 80 seats) 
 * Delete coach from a train (Max : 2) (Capacity of One coach: 80 seats)
 * Add new train to Railway System
 * Delete train from Railway System
  
**2.User Login**  
* Search for trains according to your Source and Destination stations
* Maximum of 6 tickets can be booked at a single time
* Available Quotas: 
  > * Senior Citizen(**SC**)
  > * Ladies(**L**)
  > * Handicapped(**HC**) 
  > * Open
* Availabe Coach Types:
  > * One-Tier AC (**1A-AC**)
  > * Two-Tier AC (**2A-AC**)
  > * Three-Tier AC (**3A-AC**)
  > * First Class (**FC**)
  > * Sleeper (**SL**)
  > * Second Seater (**2S**)
  > * General (**GEN**)  
* Payment options:
  > * Debit / Credit Card
  > * UPI ID
 
**3.Agent Login**
* It has all the features that **User Login** provides
* Additional features that it provides are:
  > * Maximum of 12 tickets can be booked at a time
  > * Extra 10% charges are to be levied on each ticket.
## Concepts Involved
This project is coded using Java language.  
The concepts involved in this project are:
* Data Structures namely:
  > * Singly Linked List
  > * Binary Search Tree
  > * Array
  > * String
* OOPs (**Object Oriented Programming**)
## Progress
- [x] Creating Administration Login
- [x]  Creating User Login
- [x]  Creating Agent Login
- [x]  Add Payment Options
- [x]  Add preffered coach type while booking
- [x]  Offering Quotas 

## Applications  
It can be used to book railway tickets via User/Agent as per their quota/coach type.  
Administrator can either add/delete or coach/train.  
## Scheme for Quota/Coach Type
Percentage discount is mentioned below corresponding to their Quota :
* Quotas:
  > * Handicapped(**HC**) (**30%**)
  > * Senior Citizen(**SC**) (**20%**)
  > * Ladies(**L**) (**10%**)
  > * Open (**0%**)

Here,Ticket Fare are mentioned in terms of origninal fare:
* Coach Type:
  > * One-Tier AC (**1A-AC**) (**2.1 times**)
  > * Two-Tier AC (**2A-AC**) (**1.85 times**)
  > * Three-Tier AC (**3A-AC**) (**1.70 times**)
  > * First Class (**FC**) (**1.22 times**)
  > * Sleeper (**SL**) (**1.30 times**)
  > * Second Seater (**2S**) (**1.10 times**)
  > * General (**GEN**) (**1.00 times**)
## Future Scopes
New features such as to search train on preffered dates,flexibility of Berth type that User/Agent wishes to apply for can be added.
