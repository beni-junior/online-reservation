#!/bin/bash

# Sourcecode available on " https://github.com/beni-junior/online-reservation.git"
# TODO must be at main directory of sourcecode and run the script.

# License: Beni The F.
# Author Beni-junior.

## Sample webapp could be developed by others.

log(){
  echo "$(date)----INFO--------$1"
}



log "This will be make all dependencies and make project up. guidance will be appeared if needed!"
log "Hint: webapp on port 8080, DB on 3306"
log "GL"
if [ ! `command -v docker` ]; then
    log "Docker is not installed."
    exit 1;
fi
docker pull mysql:8.4.3
docker pull openjdk:17-jdk-slim-buster
log "Docker dependencies got pulled"

log "Creating jar file."
mvn clean package -DskipTests
cp ./target/online-reservation-0.0.1-SNAPSHOT.jar ./docker/webapp.jar

log "Creating docker image."
cd docker || exit 1;
docker build -t online-reservation .

log "About to make webapp up."
if [ `command -v docker-compose` ]; then
    docker-compose up -d;
else
    docker compose up -d;
fi

docker logs -f webapp;





