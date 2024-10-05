# Bước 1: Xây dựng ứng dụng
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

# Bước 2: Chạy ứng dụng
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/nvdung-0.0.1-SNAPSHOT.war /app/app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.war"]
