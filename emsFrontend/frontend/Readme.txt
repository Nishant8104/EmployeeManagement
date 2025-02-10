first--> create a database in mysql {ems}

\sql 
\connect root@localhost:3306

mysql> create database ems;
check database created successfully
show database ;
use ems;
********************************************************************************************
second-->
run = Backend spring API

Implement endpoints:

GET /api/employees

GET /api/employees?depno={id}

Enable CORS for frontend access by adding @CrossOrigin(origins = "http://localhost:5500")
to controller

***********************************************************************************************
--> make your frontend live with Go live server

**********************************************************************************************

Access the applications:

Employee Listing: http://localhost:5500/frontend/index.html

Add Employee Form: http://localhost:5500/frontend/add-employee.html

