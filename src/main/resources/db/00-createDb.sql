create database if not exists coffeeshop;
CREATE USER if NOT EXISTS 'admin' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON coffeeshop.* TO 'admin'@localhost WITH GRANT OPTION;
CREATE USER if NOT EXISTS 'richard' IDENTIFIED BY 'richard';
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE ON coffeeshop.* TO 'richard'@localhost WITH GRANT OPTION;
FLUSH PRIVILEGES;