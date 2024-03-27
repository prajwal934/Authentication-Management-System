In this project i do authentication for a user and admin
Passing some endpoints
First : I am doing the validation by using Oauth2.0 
A user can login through the GitHub and the Google account 
Give the access for the admin and user , createting a Public and Private account for the user.
Implement authorization checks to allow admin users to access both public and private profiles 
USER : /api/v1/roles/user/users/register
ADMIN : /api/v1/roles/admin/users/register

Generate the annotation and handel all the exception.
The Hirarchy of this project is : 
      1.User can't give the same emailId , if they give then an exception will be thrown 
      2. OidcUser it can mannualy create the userId , UserName  by which a user can register 
      3. If the User is not registerd then an Message passed "Login First"
      "Please Registerd Your Account"
      4. User can fillup his details through by the google account by through we can access it in our database.
      
      5. Also creating the Roles for -ADMIN , USER
      

Authentication: Use Spring Security to handle user authentication and authorization.
Profile Management: Implement CRUD operations for user profiles, including the option to set profiles as public or private.
Database: Use a relational database like MySQL or PostgreSQL to store user data.
API Endpoints: Define RESTful API endpoints for user registration, login, profile management, and admin functionalities.
Error Handling: Implement global exception handling to provide meaningful error messages to users.
Validation: Validate user input to ensure data integrity and security.
Security Measures: Use encryption for sensitive user data like passwords, and implement measures to prevent common security vulnerabilities like SQL injection and XSS attacks.
