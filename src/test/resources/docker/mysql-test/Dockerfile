# This Dockerfile uses multi-stage builds to limit the size of the resultant image
FROM docker.io/mysql:5.7
WORKDIR /tmp/sql
COPY maven/sql/mysqljdbc.sql /tmp/sql/mysqljdbc.sql

RUN apt-get update && apt-get install -y vim
RUN apt-get update && apt-get install -y less

COPY my.cnf /tmp/
RUN cat /tmp/my.cnf >> /etc/mysql/my.cnf && rm -f /tmp/my.cnf && ulimit -d 256000

FROM docker.io/mysql:5.7
COPY --from=0 /tmp/sql/*.sql /docker-entrypoint-initdb.d/

EXPOSE 3306
