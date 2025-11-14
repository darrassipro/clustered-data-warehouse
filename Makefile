run:
	mvn spring-boot:run

test:
	mvn test

build:
	mvn clean package

docker-up:
	docker-compose up --build
