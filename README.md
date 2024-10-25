This is the implementation of a webfront of the last assignment, where we developed a CRUD API to be used in web applications. Now, in this assignment,
it comes full circle as we add the webside of things, with all of our HTML pages and references to our database.

Below is a full set of intructions on parsing the webpage. REMEMBER! I coded this on a MAC. THEREFORE I am on port 3307, and NOT 3306. Thanks!



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
