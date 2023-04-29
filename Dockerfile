# Use the official JDK 11 image as a parent image

FROM ubuntu:20.04

RUN apt update
RUN apt install default-jdk -y
COPY . .
RUN javac Main.java
 CMD ["java", "Main"]
