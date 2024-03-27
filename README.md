In this project, I do authentication for a user and admin, Passing some endpoints
1: I am doing the validation by using Oauth2.0 
A user can log in through the GitHub and the Google account 
Give access to the admin and user, creating a Public and Private account for the user.
Implement authorization checks to allow admin users to access both public and private profiles 
            USER: /api/v1/roles/user/users/register
            ADMIN: /api/v1/roles/admin/users/register

Generate the annotation and handle all the exceptions.
The Hierarchy of this project is : 
      1. The user can't give the same email, if they give then an exception will be thrown 
      2. OidcUser can manually create the userId, UserName  by which a user can register 
      3. If the User is not registered then a Message passed "Login First", "Please Register Your Account"
      4. The user can fill up his details through the Google account so we can access it in our database.
      
      5. Also creating the Roles for -ADMIN, USER
      

Authentication: Use Spring Security to handle user authentication and authorization.

Profile Management: Implement CRUD operations for user profiles, including the option to set profiles as public or private.

Database: Use a relational database like MySQL or PostgreSQL to store user data.

API Endpoints: Define RESTful API endpoints for user registration, login, profile management, and admin functionalities.

Error Handling: Implement global exception handling to provide meaningful error messages to users.

Validation: Validate user input to ensure data integrity and security.

Security Measures: Use encryption for sensitive user data like passwords, and implement measures to prevent common security vulnerabilities like SQL injection and XSS attacks.
