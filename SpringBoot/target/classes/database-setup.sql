CREATE USER 'Roman'@'%' IDENTIFIED VIA mysql_native_password USING '***';
GRANT ALL PRIVILEGES ON *.* TO 'Roman'@'%' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
CREATE DATABASE IF NOT EXISTS `Roman`;
GRANT ALL PRIVILEGES ON `Roman`.* TO 'Roman'@'%'; 