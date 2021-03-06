# Integration testing using Docker containers
A example project that demonstrates how to use the [docker-maven-plugin](https://dmp.fabric8.io/) and [maven-failsafe-plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/) to run integration tests.

This repository accompanies [this blog post](https://horiaconstantin.com/?p=36)

# File overview
* mysqljdbc.sql - will be copied into /docker-entrypoint-initdb.d/ during docker image creation
* assembly.xml - determines what classpath resources are made available to the Dockerfile
* my.cnf - contains the mysqld configuration that gets copied into the docker image
* Dockerfile - docker-maven-plugin uses this to create the MySQL image. There are two ways to put files in the image: from the classpath (via assembly.xml) and from the same directory as the Dockerfile
* docker-compose.yml - docker-maven-plugin uses this to launch the MySQL container. You can easily add more containers to this file. Don't forget to update the wait tag from the image run configuration in the pom.xml
* DatabaseTestUtilities - small utilities for interacting with the DB
* DatabaseIntegrationTest - the maven-failsafe-plugin looks for integration tests using the pattern **IntegrationTest.java

# Running the project
```bash
./build.sh int-test
```
