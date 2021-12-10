FROM java:8  
ADD ./DockerConnectMySql.java /
ADD ./mysql-connector-java-5.1.25.jar /
COPY . /
WORKDIR / 
RUN javac DockerConnectMySql.java
CMD ["java","-classpath",".:mysql-connector-java-5.1.25.jar","DockerConnectMySql"]
