DB config
mysql> CREATE DATABASE testwork;
mysql> GRANT ALL PRIVILEGES ON testwork.* TO spring@localhost IDENTIFIED BY 'p-123456789';

from project dir
mvn package
mvn spring-boot:run
