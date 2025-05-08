# Etapa de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia o projeto inteiro
COPY . .

# Compila sem rodar os testes
RUN mvn clean package -DskipTests

# Etapa final (runtime)
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o JAR gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Comando para rodar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
