FROM maven:3.9.8-eclipse-temurin-21 as build

WORKDIR /build
COPY . .
RUN mvn -f pom.xml clean package -DskipTests

FROM eclipse-temurin:21

WORKDIR /app
COPY --from=build ./build/target/*.jar ./app.jar
ENTRYPOINT ["java","-jar","./app.jar"]