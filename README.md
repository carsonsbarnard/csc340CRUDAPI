FULL STACK WEB APP

This is the implementation of a webfront of the last assignment, where we developed a CRUD API to be used in web applications. Now, in this assignment,
it comes full circle as we add the webside of things, with all of our HTML pages and references to our database.

Below is a full set of intructions on parsing the webpage. REMEMBER! I coded this on a MAC. THEREFORE I am on port 3307, and NOT 3306. Thanks!

Installation (make sure you are in branch feature-mvc)

Get the project
clone

git clone https://github.com/carsonsbarnard/csc340CRUDAPI.git

Download the zip file

Open the project in IntelliJ.
/src/main/resources/application.properties file is the configuration for the MySQL database on your localhost.
the database name is on the datasource.url property between the last / and the ?.
You MUST have the database up and running before running the project!
Open your XAMPP Control Panel.
Start the Apache server.
Start MySQL.
Click on MySQL "Admin" to open up the DBMS.
Ensure the database that you need is available.

You can:

Method: GET
Endpoint: /animals/all
Example: http://localhost:8080/animals/all

Get all animals

Method: GET
Endpoint: /animals/{id}
Example: http://localhost:8080/animals/{id}

Search for a specific animal by id

Method: GET
Endpoint: /animals/search
Example: http://localhost:8080/animals/search?name=blue

Search for animals that contain a string

Method: POST
Endpoint: /animals/new
Example: http://localhost:8080/animals/new

Create a new animal

Method: POST
Endpoint: /animals/update/{id}
Example: http://localhost:8080/animals/update/1

Update an existing animal

Method: DELETE
Endpoint: /animals/delete/{id}
Example: http://localhost:8080/animals/delete/1

Delete an existing animal
