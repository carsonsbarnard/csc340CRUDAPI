CRUD API

NOTE ---- THIS WAS CODED ON A MAC. That means the port I am using in my project is 3307 and NOT 3306. Please make sure you note this when testing.

The REST API performs CRUD operations on Animal objects as described below.

Installation

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
API Endpoints

Use POSTMAN to try the following endpoints:

Get all animals

Request

`GET /api/animals`

`http://localhost:8080/students/all`
Response

    {
        "animalId": 1,
        "description": "A large mammal with a long trunk",
        "habitat": "Savannah",
        "name": "African Elephant",
        "scientificName": "Loxodonta africana",
        "species": "Elephant"
    },
    {
        "animalId": 2,
        "description": "A small domesticated carnivorous mammal",
        "habitat": "Household",
        "name": "Domestic Cat",
        "scientificName": "Felis catus",
        "species": "Cat"
    },
    {
        "animalId": 3,
        "description": "A flightless bird",
        "habitat": "Forests",
        "name": "Ostrich",
        "scientificName": "Struthio camelus",
        "species": "Bird"
    },
    {
        "animalId": 5,
        "description": "A beautiful blue bird.",
        "habitat": "Forests",
        "name": "Blue Jay",
        "scientificName": "Cyanocitta cristata",
        "species": "Bird"
    }
    
Get a specific animal

Request

`GET /api/animals/{id}`

`http://localhost:8080/api/animals/{id}`

Response

    {
        "animalId": 1,
         "description": "A large mammal with a long trunk",
        "habitat": "Savannah",
         "name": "African Elephant",
        "scientificName": "Loxodonta africana",
        "species": "Elephant"
    } 

Create a new animal

Request

`POST /api/animals`

`http://localhost:8080/api/animals` --data '{ "name": "species", "description": "habitat", "scientificName"}'

Response

    {
        "animalId": 1,
        "description": "A large mammal with a long trunk",
        "habitat": "Savannah",
        "name": "African Elephant",
        "scientificName": "Loxodonta africana",
        "species": "Elephant"
    }

Get animals by species

Request

`GET /api/animals/species/{species}`

`http://localhost:8080/api/animals/species{species}`

Response

    
    {
        "id": 1,
        "name": "Russian Blue Cat",
        "species": "cat",
        "description": "A gentle, quiet cat.",
        "habitat": "Domestic",
        "scientificName": "Felis catus"
    },
    {
        "id": 2,
        "name": "Persian Cat",
        "species": "cat",
        "description": "A long-haired, elegant cat.",
        "habitat": "Domestic",
        "scientificName": "Felis catus"
    }

Get animals by searching a certain string in their name

Request

`GET /api/animals/search?name={query}`

`http://localhost:8080/api/animals/search?name={query}`
Response

    
    {
        "id": 1,
        "name": "Grizzly Bear",
        "species": "bear",
        "description": "Large brown bear found in North America.",
        "habitat": "Forests",
        "scientificName": "Ursus arctos horribilis"
    },
    {
        "id": 2,
        "name": "Polar Bear",
        "species": "bear",
        "description": "A bear species found in the Arctic.",
        "habitat": "Arctic",
        "scientificName": "Ursus maritimus"
    },
    {
        "id": 3,
        "name": "Sun Bear",
        "species": "bear",
        "description": "A small bear found in Southeast Asia.",
        "habitat": "Tropical Rainforests",
        "scientificName": "Helarctos malayanus"
    }

Update an existing animal

Request

`PUT /api/animals/{id}`

`http://localhost:8080/api/animals/{id}` --data '{ "name": "species", "description": "habitat", "scientificName"}'

Response

    {
        "id": 2,
         "name": "Siamese Cat",
        "species": "Cat",
        "description": "A sleek, short-haired cat with striking blue eyes.",
        "habitat": "Domestic",
        "scientificName": "Felis catus"
    }

Delete an existing animal

Request

`DELETE /api/animals/{id}`

`http://localhost:8080/api/animals/{id}`

Response

    HTTP/1.1 204 No Content
    then
    HTTP/1.1 404 Not Found
