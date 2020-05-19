# Movies App
This is the application used to recommend movies to customer based on his interest.

# How to run 
java -jar target/movies-app-0.0.1-SNAPSHOT.jar
docker run -p 8081:8081 santoshdocker1986/movies-app:0.0.1-SNAPSHOT

# API URL  
http://localhost:8081/api/movies-app/v1/movie/suggestion/customer/id/1001

# API documentation 
Run the application and launch " http://localhost:8081/swagger-ui.html#/"

#Improvements :
1) Write data validation service  which will validate data before inserting data  in DB
2) Data loading can be implemented using Spring Batch because of following reasons 
    a) Data loading should be independent and should be batch job
    b) In case of huge data Spring Batch can be handy
3) Decouple this application into microservices architecture
    a) Data Loader service : can be schedule job which can be run daily/weekly/monthly
    b) Movie recommendation service : 
4) Write more Junits 
   

#Note :
This is implemented by 2 approaches 
1) All data processing is done in Java (movieRecommendationService -> retrieveMovieRecommendation()
2) All data processing is done using JPA - Specification and Criteria Builder (movieRecommendationService->   getMovieRecommendation()
3) This is sample data so I have used jackson to read the file , can be improved by using spring batch .
