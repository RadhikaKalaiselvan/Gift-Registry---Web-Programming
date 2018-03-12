Gift Registry functionalities:

i. Login

ii. Logout

iii. User profile information display and editing

iv. Forgot password functionality

v. Ability to create a registry

vi. Ability to search for items that you would like to add into registry

vii. Ability to add/remove items from a registry

viii. Ability to share registry to particular user or make it public



The user will be able to search for any gift and the results will be displayed in table, user can also filter the results by price,user review,color, etc.

The app. supports 3 users: 
Admin, registered user, unregistered user.

Database: MySQL
Cache: Memcache
Used twilio apis to send one time password.
Used JSP,Java Servlet, jQuery, Bootstrap,HTML5

GiftRegistryWebServices1 - the first  app server where user request lands, the web server uses the API of Webservice2

GiftRegistryWebServices2- Contacts web service 3 and gets the data and also performs validation logic and returns the status to web service 1.

GiftRegistryWebServices3- This is a micro service which communicates with the DB. Developed the Rest APIs which will be used by web service2.


The web application should support the following functionalities via a web service API:
1. New regular user registration
2. User profile information access and modification
3. Ability to create a registry
4. Ability to search for items in the inventory
5. Ability to add/remove items from a registry
6. Ability to share registry to particular user or make it public
7. Self-assign an item on another user’s registry
8. Add/remove items into/from inventory
9. Display the items in the inventory

