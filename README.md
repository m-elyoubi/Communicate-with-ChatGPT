# Communicate-with-ChatGPT
To run my appication called chat-with-ChatGPT just following these steps:
## Prerequisites
    1-Install Java 17 on your machine, if not already installed.
    2- Install Docker on your machine, if not already installed.
    3- Download and install Postman.
## Running the Application Locally
    
    1- Clone this repository to your local machine.
    2- Open the project in your favorite IDE (such as IntelliJ IDEA).
    3- Open application.properties file,then you want to change value of openai.apiKey="here your apikey" by your apikey
    3- Build the project using Maven. You can do this from within your IDE or from the command line using mvn clean install.
    4- Run the Spring Boot application by running the Application.java file or using the spring-boot:run Maven goal.
    5- The application will be accessible at http://localhost:8080.

## Running the Application on Docker
   
    1- Clone this repository to your local machine. #git clone path
    2- Navigate to the root directory of the project.
    3- Build the Docker image using the following command: docker build -t <image-name> .
    Replace <image-name> with the name you want to give to your Docker image.
    4- Once the image is built, run the Docker container using the following command: docker run -p 8080:8080 -v <local-path>:<container-path> <image-name>
    Replace <image-name> with the name you gave to the Docker image in step 3.
    Replace <local-path> with the path to a local directory you want to map to the container.
    Replace <container-path> with the path to the directory inside the container where you want to map the local directory.
    5- This will start the container and map port 8080 inside the container to port 8080 on your machine.
    6- The application will be accessible at http://localhost:8080
  
## Testing the Application with Postman
   
    1- Open Postman and create a new request.
    2-Set the request method to POST.
    3- Enter the URL http://localhost:8080/question to test a specific endpoint of the application.
    4- Go to headers of postman give the key Content-Type and value application/json
    5- then click body add this file json like this {
                                                         "question": "here write a question that you want to ask chatGPT AI ?"
                                                    }
    6- Click Send to send the request and see the response.
    7- You should now see the response from the application in Postman.
    8- Then you should now see the question and response save in csv file .
  
  
