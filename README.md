In this project, I am implementing authentication and authorization for users and admins using OAuth 2.0, allowing logins through GitHub and Google accounts. The system supports both public and private accounts for users, with authorization checks to permit admin access to all profiles.

Key Features
1. User Registration and Validation:

   (i). Prevent duplicate email registration; an exception is thrown if attempted.
   (ii). Users can register with manually created user IDs and usernames.
   (iii). Unregistered users receive messages prompting registration.
   (iv). User details can be populated via Google account information.
   (v). Roles are created for ADMIN and USER.
2. Authentication and Authorization:
   
   (i)Spring Security is used to manage authentication and authorization processes.
   (ii)Admins can access both public and private user profiles.
3. Profile Management:

   CRUD operations are implemented for user profiles.
   Users can set profiles as public or private.
4. Database:

   A relational database (MySQL or PostgreSQL) is used to store user data.
5. API Endpoints:

    RESTful API endpoints are defined for
      user registration (/api/v1/roles/user/users/register),
      admin registration (/api/v1/roles/admin/users/register), login, profile management, and admin functionalities.
6. Error Handling:

     Global exception handling provides meaningful error messages to users.
7. Validation:
  User input is validated to ensure data integrity and security.
This project ensures secure, efficient user and admin management with robust authentication, authorization, and error handling mechanisms.







