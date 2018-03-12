The web application should support the following functionalities via a web browser based
Graphical User Interface (i.e. webpages):
1. New regular user registration
2. Regular User
i. Login
ii. Logout
iii. User profile information display and editing
iv. Forgot password functionality
v. Ability to create a registry
vi. Ability to search for items that you would like to add into registry
1. Table display:
a. Results (with at least four properties) should be displayed
in a sortable table (i.e. allowing resulting to be sorted on
any column)
2. Search results filtering capabilities on at least four result item
properties
vii. Ability to add/remove items from a registry
viii. Ability to share registry to particular user or make it public
ix. Self-assign an item on another user’s registry
3. Accessible any unavailable page should retrieve a pretty and generic 404 page
4. Admin User:
i. Login
ii. Logout
iii. Add/remove items into/from inventory
iv. Display the items in the inventory
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
D. Database: It is mandatory that your project use a database to store all data. There is no
restriction on what type of database to use. Any NoSQL database or RDBMS is fine.
The database SQL or ORM request and response information should be available in
the Web-Service web/app server logs for the TA to review the implementation of
this feature. In addition, the TA might inspect the database’s content getting
updated via a database SQL console.
E. Web Services: On you web site, a Web Service call should be made for any user
operation that requires database access (i.e. to retrieve information or add/update
information in the database). These Web Services should be hosted as a different web
application and on a different web/application server than the web/application server
containing the web site. However, the two different web/application servers can reside on
the same machine. For this project, Web Services are platform/programming-language
independent, unassociated, loosely coupled units of functionalities that are self-contained
and implemented via SOAP/WSDL or RESTful methodologies. All Web Services
should require authentication/authorization to allow only a valid user to
access/modify his/her data.
The Web Services request and response information should be available in the both
the Website and Web Services web/app server logs for the TA to review the
implementation of this feature. The implementation of RESTful Web Services and
its authentication/authorization feature can also be shown to the TA via browserbased
REST clients such as Postman.
F. Microservices: Each Web Service’s functionality should be supported and implemented
by one or more Microservices. Only the Microservices should run data
access/modification operations. For this project, Microservices are self-contained
modules implemented using RESTful methodologies. Also, for this project, all the
Microservices can be hosted as part of the Web Service web application, and on the same
web/application server and machine. All Microservices should require
authentication/authorization to allow only a valid user to access/modify his/her data.
The Microservices request, database query, and response information should be
available in the Web Service web/app server logs for the TA to review the
implementation of this feature.
G. Other Required Features: Your web site/application implementation should also
include the following four (4) features:
1. High Performance: perform distributed caching. Memcached is a good option for
implementing a distributed caching mechanism.
Cache miss and cache hit information should be available in the web/app server
logs for the TA to review the implementation of this feature.
2. Client-Server Communication Encryption: encrypt the communication channel
between the client (i.e. browser), web site server, Web Services, and Microservices
server using TLS/SSL.
The TA will check the implementation of this feature on the Website web/app
server by checking if the URL in the browser address bar contains the HTTPS
protocol.
The TA will check the implementation of this feature on the Web-
Services/Microservices web/app server by:
· Examining the web/app server logs for the Web Services and
Microservices request calls being requested and responded to with the
HTTPS protocol
OR
· Making HTTPS calls to the RESTful WebServices and Microservices
using browser-based REST clients such as Postman
OR
· Examining the capture logs of packet analyzers such as Wireshark
3. Request/Response Compression: perform compression (e.g. gzip) of:
a. web site server’s response to the client
The TA will check the implementation of this feature by looking at the
“Content-Encoding” HTTP response header field either in the browser
debug console (a.k.a. inspect element console) or in the Website’s
web/app server log file
b. web site server’s request to the Web Service server
Optional: The TA will check the implementation of this feature by
looking for the “Content-Encoding” HTTP request header field in the
Web-Service’s web/app server log file
c. Web Service server’s response to the web site’s server
The TA will check the implementation of this feature by:
o looking for the “Content-Encoding” HTTP response header field
in the Web-Service’s web/app server log file
OR
o looking for the “Content-Encoding” HTTP response header field
in the RESTful WebServices call made using browser-based REST
clients such as Postman
# Gift-Registry---Web-Programming
