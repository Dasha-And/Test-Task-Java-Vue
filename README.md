# Test-Task-Java-Vue

Backend setup:
1. Create local database and add credentials and database url to application-private.properties
2. Run "mvn -Dflyway.user=databaseUser -Dflyway.password=databasePassword -Dflyway.schemas=schemaName" to run flyway migrations
3. Run the application

Frontend:
1. Run npm intall
2. Run npm run serve
3. Make sure that the same port that the app has launhed on is mentioned in CORS configuration in Application.java file in backend
