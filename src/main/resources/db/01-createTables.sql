-- Crear la tabla de categorías
CREATE TABLE IF NOT EXISTS categories (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(255) NOT NULL,
                                          description TEXT,
                                          imageUrl VARCHAR(255)
);

-- Crear la tabla de productos
CREATE TABLE IF NOT EXISTS products (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        category_id BIGINT NOT NULL,
                                        name VARCHAR(255) NOT NULL,
                                        description TEXT,
                                        productDetail TEXT,
                                        stock INT DEFAULT 0 NOT NULL,
                                        price DOUBLE NOT NULL,
                                        imageUrl VARCHAR(255),
                                        FOREIGN KEY (category_id) REFERENCES categories(id)
);

create table if not exists app_users(
                                        user_id bigint primary key auto_increment,
                                        first_name varchar(200) not null,
                                        last_name varchar(200) not null,
                                        email varchar(200) not null unique,
                                        password varchar(200) not null
);

-- Crear la tabla de artículos del carrito
CREATE TABLE IF NOT EXISTS cart_item (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         quantity INT NOT NULL,
                                         addingDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                         updatingDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
                                         product_id BIGINT NOT NULL,
                                         FOREIGN KEY (product_id) REFERENCES products(id),
                                         user_id BIGINT NOT NULL,
                                         FOREIGN KEY (user_id) REFERENCES app_users(user_id),
                                         CONSTRAINT unique_user_product UNIQUE (user_id, product_id)
);

-- Crear la tabla de valoraciones
CREATE TABLE IF NOT EXISTS ratings (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       rating DOUBLE NOT NULL,
                                       userName VARCHAR(255) NOT NULL,
                                       comment TEXT,
                                       date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                       product_id BIGINT NOT NULL,
                                       FOREIGN KEY (product_id) REFERENCES products(id),
                                       CONSTRAINT UNIQUE_USER_PRODUCT UNIQUE (userName, product_id)
);
