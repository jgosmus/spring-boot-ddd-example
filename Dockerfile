FROM gradle:jdk17-alpine
WORKDIR /ddd-example
COPY . .
RUN ./gradlew build
CMD ./gradlew bootRun
