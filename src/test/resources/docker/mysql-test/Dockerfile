# The mysql.version is a property in pom.xml
FROM docker.io/mysql:@mysql.version@

# Install vim to make debugging easier
#RUN apt-get update && apt-get install -y vim

# Copy DB init scripts to the place where they will be picked up during the start of the container
COPY maven/sql/*.sql /docker-entrypoint-initdb.d/

# Change mysql configs
COPY my.cnf /tmp/
RUN cat /tmp/my.cnf >> /etc/mysql/my.cnf && rm -f /tmp/my.cnf && ulimit -d 256000

EXPOSE 3306
