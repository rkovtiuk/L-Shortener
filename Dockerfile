FROM java:8-jre
MAINTAINER Robert Kovtiuk <robertkovtiuk@gmail.com>
ADD ./targer/shortener.jar /app/
CMD ["java", "-jar", "app/shortener.jar"]
EXPOSE 8080
