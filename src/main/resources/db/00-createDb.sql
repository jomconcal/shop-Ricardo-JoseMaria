create database if not exists coffeeshop;
CREATE USER if NOT EXISTS 'admin'@localhost IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON coffeeshop.* TO 'admin'@localhost;
CREATE USER if NOT EXISTS 'richard'@localhost IDENTIFIED BY 'richard';
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE ON coffeeshop.* TO 'richard'@localhost;
FLUSH PRIVILEGES;