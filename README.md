MuzixService Application
Tasks Done in this application:

1. Endpoints for CRUD operations on Muzix

2. Used h2-console to view in-memory data

3. Added an endpoint to search trackByName. Understand @Query and parameter passing to@Query

4. Generated API documentation using Swagger 2

5. Created custom exceptions TrackNotFoundException, TrackAlreadyExistsException in acom.stack....exceptions package. Perform    appropriate exception handling and propagationBack.
   
6. Rnning Logic on Startup in Spring. Create seed data to pre-fill the database with trackinformation whenever the application 
   starts. Used both approaches:
      1: ApplicationListener<ContextRefreshedEvent>Approach 
      2: CommandLineRunner

7. Global exception using Controller advice

8. Removed all hard coded data from the application code to application.properties
   a)by using @Value.
   b)by using @PropertySource
   c)by using Environment
   
9. Added @Lombok
