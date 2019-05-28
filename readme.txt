mysql> CREATE DATABASE testwork;
mysql> GRANT ALL PRIVILEGES ON testwork.* TO spring@localhost IDENTIFIED BY 'p-123456789';

mvn package
mvn tomcat8:run



