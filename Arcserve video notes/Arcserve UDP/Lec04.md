**1. UDP Console is Powered by 4 Major Components**

&#x20;  ---------------------------------------------



&#x20;  1) Apache HTTPD (Webserver)

&#x20;     - Handles web requests and provides web interface access.

&#x20;  2) Apache Tomcat (Application Server)

&#x20;     - Runs Java-based UDP console applications and services.

&#x20;  3) Apache WSO2 Identity Server

&#x20;     - Manages authentication, identity, and user access control.

&#x20;  4) MS SQL Database

&#x20;     - Stores configuration data, job details, and management information.

**2. Other Tools Used in Arcserve UDP Console**

&#x20;  -----------------------------------------

&#x20;  a) OpenSSL

&#x20;     - Used for encryption and secure communication.

&#x20;  b) Keytool

&#x20;     - Java utility used for certificate and key management.

&#x20;  c) JRE (Java Runtime Environment)

&#x20;     - Required to run Java-based Arcserve components.

&#x20;  d) SQLite

&#x20;     - Lightweight database used for certain internal operations.



**3.UDP Console / Control Flow**

**==========================**



1\. Control Flow of UDP Console

&#x20;  ----------------------------

&#x20;  - Shows the startup sequence of services required for Arcserve UDP Console.



2\. Start → Start/Restart Arcserve UDP

&#x20;  -----------------------------------

&#x20;  - Arcserve UDP services are started or restarted.



3\. Apache HTTPD

&#x20;  --------------

&#x20;  - Web server starts first.

&#x20;  - Handles incoming web requests from users.



4\. Apache Tomcat

&#x20;  ---------------

&#x20;  - Application server starts after HTTPD.

&#x20;  - Runs UDP console applications and backend services.



5\. WSO2 Identity Server

&#x20;  ----------------------

&#x20;  - Starts identity and authentication services.

&#x20;  - Handles login and access management.



6\. MS SQL Server

&#x20;  ---------------

&#x20;  - Database service becomes available.

&#x20;  - Stores console configurations, jobs, and backup information.



7\. UDP Console (Ready to use)

&#x20;  ---------------------------

&#x20;  - After all required services start successfully,

&#x20;    the Arcserve UDP Console becomes operational and accessible.



8\. Key Idea

&#x20;  ----------

&#x20;  - Arcserve UDP Console depends on multiple services starting

&#x20;    in proper sequence before the console becomes ready for use.





**4. Important Files and Directories of Apache Web Server**

**====================================================**



1\. Directory:

&#x20;  ------------

&#x20;  C:\\Program Files\\Arcserve\\Unified Data Protection\\Common\\Apache\\conf



&#x20;  Files:

&#x20;  -------

&#x20;  • httpd-console.conf

&#x20;  • httpd-rps.conf



2\. Directory:

&#x20;  ------------

&#x20;  C:\\Program Files\\Arcserve\\Unified Data Protection\\Common\\Apache\\conf\\extra



&#x20;  Files:

&#x20;  -------

&#x20;  • console.conf

&#x20;  • console-ssl.conf

&#x20;  • rps.conf

&#x20;  • rps-ssl.conf

&#x20;  • udp.crt

&#x20;  • udp.pem



3\. Directory:

&#x20;  ------------

&#x20;  C:\\Program Files\\Arcserve\\Unified Data Protection\\Common\\Apache\\logs



&#x20;  Files:

&#x20;  -------

&#x20;  • console-error.log

&#x20;  • console-ssl-error.2019-07-02-14\_23\_53.log

&#x20;  • rps-error.log

&#x20;  • rps-ssl-error.2019-07-01-22\_53\_39.log





**5.Apache Tomcat \[App Server]**

==========================



1\. Apache Tomcat

&#x20;  ---------------

&#x20;  - Apache Tomcat is an Application Server.

&#x20;  - Also referred to as Java Servlet Containers.



2\. Major Task of Application Server

&#x20;  ---------------------------------

&#x20;  - Runs business logic.

&#x20;  - Responds to client requests.



3\. Apache Tomcat Development

&#x20;  --------------------------

&#x20;  - Developed and maintained by an open community of developers.

&#x20;  - Open-source cross-platform web server software.



4\. Usage in Arcserve UDP

&#x20;  ----------------------

&#x20;  - Apache Tomcat is used in:

&#x20;    • UDP Console

&#x20;    • Gateway

&#x20;    • Agent

&#x20;    • RPS Server





**6.Apache WSO2 \[Identity Server]**

**=============================**



• Apache wso2 is an open source identity and access management software.



• WSO2 Identity Server allows enterprises to achieve single sign-on/sign-out (SSO), identity federation, strong authentication, identity administration, account management, identity provisioning, fine-grained access control, API security, monitoring, reporting, and auditing.



• In our UDP setup we are using the Apache wso2 identity server for SSO (single sign-on) which is also known as IWA (integrated web authentication), Maintaining the User store and audit purpose.



• WSO2 will comes into the picture when we install Arcserve UDP Console.



• We also have a dedicated WSO2 database in Arcserve\_APP instance of MS SQL from UDP 7.0 onwards.







**7. Tought to add multiple nodes to the console with the	plan**







