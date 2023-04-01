# UsersApiTutorial
An example backend REST service for creating, reading, updating, and deleting Users.

**As this project was meant to demonstrate the basics of REST APIs, it is not using an actual database and is instead storing the users in memory.**

In order to run this project, pull it down locally and run the following:
- mvn package
- java -jar target/Users-1.0-SNAPSHOT.jar server UsersService.yaml

If you aren't familiar with Maven, check out the docs [here](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
