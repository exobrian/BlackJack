FROM openjdk:17
MAINTAINER briantran
COPY target/BlackJack-1.0-SNAPSHOT.jar blackjack.jar
ENTRYPOINT ["java", "-jar", "/blackjack.jar"]