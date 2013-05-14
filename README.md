This is a subversion user self service web tool

Run following command to generate self runnable war:

    mvn clean package

And run:
    java -jar target/shaun-1.0-SNAPSHOT.war <path to htpasswd file>