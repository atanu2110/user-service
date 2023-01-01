CREATE TABLE users(
id BIGINT AUTO_INCREMENT not null PRIMARY KEY,
user_name VARCHAR(20) not null,
password VARCHAR(100) not null,
is_active BOOLEAN not null,
email VARCHAR(50)
);


CREATE TABLE user_profile(
id BIGINT AUTO_INCREMENT not null,
gender VARCHAR(6),
first_name VARCHAR(30),
last_name VARCHAR(30),
billing_address VARCHAR(100),
shipping_address VARCHAR(100),
user_login_Id BIGINT,
CONSTRAINT profile_pk PRIMARY KEY (id),
FOREIGN KEY (user_login_Id) REFERENCES users(id)
);
