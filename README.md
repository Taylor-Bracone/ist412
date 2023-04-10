# IST 412
412 Semester Group Project!!


Group 1 OFO_Group 1: *Taylor Bracone, Ananya Reddy, Riley Surratt, Melisa Tasel, & Kim Winters*

## Detailed Any Usernames and Passwords Required to Log in to the App
To login in as a customer:  

● userName = Customer1  

● Password = password

To login as a restaurant owner:  

● userName = Restaurant Owner   

● Password = password

## Group Design Pattern Selections to Implement
Taylor Bracone:  
● Observer Pattern -- helps with class interaction and limit need for code alteration --> Model > Actors (Customer), Restaurant (Cuisine, Observer, Restaurant, RestaurantDataTest, RestaurantList, RestaurantListTest, Subject, etc)

● Navigation Tabs -- navigation of options and system functions alike --> View > Restaurants (SwingTabsView) it has all of the use case tabs

Ananya Reddy:  
● Builder -- avoids null errors in information input in constructors --
Found within Model --> Actors. User Builder added to User class.

● Shopping Cart -- integral to e-commerce platforms and recognizable --
Found in View folder. Shopping Cart GUI that shows all the menu items a customer added to their cart from the menu options screen

Riley Surratt:  
● Chain of Responsibility -- isolates behavior requirements to handle requests (used for NotificationChain, OrderNotifier, CustomerNotifier, DelivererNotifier, and RestaurantController)


● Notifications -- keeps users apprised and engaged (used in the adding to shopping cart function as a dialog and used in the notification of order status to customer and deliverer for bare-bones notification implementation)

Melisa Tasel:  
● Iterator Pattern -- improves efficiency of list access

● Alternating Row Colors -- practical for visual clarity

Kim Winters:  
● Composite -- tree structure of individual objects to be manipulated


● Continuous Scrolling -- allows larger amounts of data per page

## Overview of Design
● Customer


○ Can place orders


○ Update customer information


● RestaurantOwner

○ Can request to be listed on the app


○ Can update restaurant information


○ Can update menu


● RestaurantOperator

○ Manages interaction with delivery app


○ Can accept orders on behalf of the restaurant

● Deliverer

○ Can choose what delivery to accept from a list of pending deliveries in the area

● SysAdmin

○ Makes final decision about acceptance of restaurant

## Well Defined Scope
● Assists restaurants in streamlining everyday operational and management tasks and to enhance the
restaurant/ eating experience for its users/ customers


● Aimed at simplifying operations between the restaurant and the user/ customer

<img width="636" alt="Screen Shot 2023-02-04 at 1 57 25 AM" src="https://user-images.githubusercontent.com/71147213/218339574-8669321d-ea62-4cf5-885b-90675bf62324.png">

## UML Diagram
<img width="297" alt="Screen Shot 2023-04-03 at 1 47 07 PM" src="https://user-images.githubusercontent.com/71147213/229587407-fdb6cdd6-ef89-4af8-a82b-f8c4de43e5c3.png">


## User Requirements

● Functional


○ Being able to view restaurants (potentially by zip code)


○ Requesting to be added to/invalidated from the the restaurant list


○ Placing food orders for delivery


○ Updating customer information


○ Filtering restaurant search by attributes such as cuisine, price etc.


○ Accepting/declining orders for delivery

● Non-Functional


1. Security - application requires sensitive information like payment information, personal details, and address
for delivery
2. Reliability - users/ customers are spending money to place food orders that need to be delivered in a timely
manner, so the application cannot crash or commit any errors, particularly with placing orders
3. Usability - the user experience must be as seamless as possible to ensure users do not have to spend a lot
of time to place an order, or get frustrated with their experience. The application must be fault-tolerant
4. Maintainability - to ensure all location data, restaurant prices/data, and back-end performance requirements
are up to date, maintenance is very important. It will help prevent errors and malfunctions in advance
5. Scalability - the application should be able to adapt to change in case there are opportunities to upscale and
start delivering to more areas/reaching more users



## WIP: Online Food ERD Showcase Example
![OnlineFood_ERD](https://user-images.githubusercontent.com/71147213/222979770-8419ebdd-ce44-42bb-b42f-e7061ba41deb.jpg)


## Contributing, Team Work & Group Collaboration 

All members are active contributors. Pull requests are highly encourages. For major changes, please open an issue first
to discuss your thoughts pertaining to changes.

● Open and clear communication

○ Discuss ideas, expectations, and intentions


○ Ensure that all team members are up-to-date on project
requirements

● Collaboration


○ Prioritize each group member’s strengths and skills


○ Utilize online resources to work together

● Meetings


○ Working face-to-face has encouraged us to work productively
and bring different perspectives and expertise
