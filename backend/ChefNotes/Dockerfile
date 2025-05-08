FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . /app

# Adiciona permissão de execução ao Maven Wrapper
RUN chmod +x mvnw

# Compila a aplicação sem rodar os testes
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-Xmx256m", "-Xms128m", "-jar", "target/backend-pi-0.0.1-SNAPSHOT.jar"]
