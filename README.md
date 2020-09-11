# SpringBootMicroservice
Learned about Microservice and Spring config Server and implemented three microservices Limit microservices which will get two properties from git repository using config server and Two other microservices Currency-conversion and currency-exchange to convert  one form (USD) to other(INR) 

Currency conversion Microservice will communicate to  currency exchange microservice using feign client. And ribbon client to distribute load among the microservcies


Zuul gateway has been implemented which is single gate way for all the request coming from user and zuul uses eureka client server to find the address of the microservice based on the particular request
