# MicroServiceArchitecture


Steps to run

1) git clone https://github.com/mayurbavisiya/MicroServiceArchitecture.git

2) Import into IDE

3) Run DiscoveryMicroserviceServerApplication.java file from MicroserviceDiscoveryServer project to run Eureka server.(you can check dashboard using http://localhost:1111)

4) Run ProfileMicroserviceServerApplication.java from ProfileMicroserviceProducer project to run eureka client that service you can check on http://localhost:2222. You can recheck Eureka dashboard and see that service is up on port 2222. 

5) Run ProfileMicroserviceClientApplication.java from ProfileMicroserviceConsumer to use producers services. Swagger is enabled for this projet so you can directly access the services from swagger ui. (http://localhost:8080/swagger-ui.html).
 If you have any other producer which is integrated in eureka server that you can consume from this prject.
 
 Note : Spring security is enabled in ProfileMicroserviceConsumer. There are two user for it.
 1) USER (username : user , password : user) has access for only GET requests
 1) ADMIN (username : admin , password : admin) has access for all requests.
 
 
 6) Docker file is already there, To create docker image just run
     docker build -t imagename:latest
   
 
