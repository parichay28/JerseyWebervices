# JerseyWebervices

## Import Project
1. Import this project in Eclipse.
2. Run the project on Apache Tomcat Server and use postman for testing the services.

## Postman Setup
1. Set Accept and Content-Type in header to application/json
2. In the body write the corresponding data in JSON format.


The services are:

### Register User

1. URL: http://localhost:8080/rest/userservices/register

2. Request type: POST

3. Example:

Body:
{
    "email": "useremail",
    "name": "username",
    "password": "userpassword"
}

Response:
(If user is not already registered)
{
    "message": "Registration Successful",
    "status": true
}

### Login User
1. URL: http://localhost:8080/rest/userservices/login

2. Request type: POST

3. Example:

Body:
{
   "email": "useremail",
   "password": "userpassword"
}

Response:
(If user is not logged in)
{
    "message": "User successfully logged in",
    "status": true
}

### Add Comment
1. URL: http://localhost:8080/rest/userservices/addcomment

2. Request type: POST

3. Example:

Body:
{
   "email": "useremail",
   "comment": "user_comment"
}

Response:
(If user is logged in )
{
    "message": "User comment added successfully",
    "status": true
}


### Show Details By User
1. URL: http://localhost:8080/rest/userservices/user's_email_id_here/showusercomments

2. Request type: GET

3. Example:

Response:
{
    "comments": [
        "user_comment"
    ],
    "email": "useremail",
    "name": "username",
    "password": "userpassword"
}

### Show Details Of All Users
1. URL: http://localhost:8080/rest/userservices/showallcomments

2. Request type: GET

3. Example:

Response:
[
    {
        "comments": [
            "user_1_comment"
        ],
        "email": "user1email",
        "name": "user1name",
        "password": "user1password"
    },
    {
        "comments": [
            "user_2_comment"
        ],
        "email": "user2email",
        "name": "user2name",
        "password": "user2password"
    }
    ....
]

