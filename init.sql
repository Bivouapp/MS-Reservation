-- Create Users table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    is_host BOOLEAN NOT NULL DEFAULT FALSE,
    is_admin BOOLEAN NOT NULL DEFAULT FALSE
);

-- Create Bivouacs table
CREATE TABLE bivouacs (
    bivouac_id SERIAL PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    price NUMERIC(18, 2) NOT NULL,
    location_type VARCHAR(50),
    field_type VARCHAR(50),
    user_id_host INTEGER REFERENCES users(user_id),
    address_id INTEGER
);

-- Create Addresses table
CREATE TABLE addresses (
    address_id SERIAL PRIMARY KEY,
    number VARCHAR(10),
    street VARCHAR(100),
    city VARCHAR(50),
    postal_code VARCHAR(10),
    latitude NUMERIC(10, 8),
    longitude NUMERIC(11, 8)
);

-- Create Equipments table
CREATE TABLE equipments (
    equipment_id SERIAL PRIMARY KEY,
    label VARCHAR(30) NOT NULL
);

-- Create BivouacEquipments table (junction table)
CREATE TABLE bivouac_equipments (
    bivouac_id INTEGER NOT NULL REFERENCES bivouacs(bivouac_id),
    equipment_id INTEGER NOT NULL REFERENCES equipments(equipment_id),
    PRIMARY KEY (bivouac_id, equipment_id)
);

-- Create Disponibility table
CREATE TABLE disponibility (
    disponibility_id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    bivouac_id INTEGER NOT NULL REFERENCES bivouacs(bivouac_id)
);

-- Create Reservations table
CREATE TABLE reservations (
    reservation_id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    nb_bivouaker INTEGER NOT NULL,
    price NUMERIC(18, 2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    user_id INTEGER REFERENCES users(user_id),
    bivouac_id INTEGER REFERENCES bivouacs(bivouac_id),
    review_id INTEGER
);

-- Create Reviews table
CREATE TABLE reviews (
    review_id SERIAL PRIMARY KEY,
    rating INTEGER CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    date DATE NOT NULL
);

-- Create Photos table
CREATE TABLE photos (
    photo_id SERIAL PRIMARY KEY,
    ordre INTEGER NOT NULL,
    url VARCHAR(255) NOT NULL,
    description VARCHAR(200),
    bivouac_id INTEGER REFERENCES bivouacs(bivouac_id)
);

-- Create FavoriteBivouacs table
CREATE TABLE favorite_bivouacs (
    user_id INTEGER NOT NULL REFERENCES users(user_id),
    bivouac_id INTEGER NOT NULL REFERENCES bivouacs(bivouac_id),
    PRIMARY KEY (user_id, bivouac_id)
);

INSERT INTO bivouacs(description, price, location_type, field_type, user_id_host, address_id) 
VALUES ('Beautiful spot in the forest', 34.00, 'forest', 'camping', NULL, NULL);

INSERT INTO equipments(label) 
VALUES ('Shower'), ('Toilet'), ('Fireplace');

INSERT INTO disponibility(start_date, end_date, bivouac_id) 
VALUES ('2024-01-01', '2024-01-10', 1),
       ('2024-02-01', '2024-02-15', 1);

INSERT INTO reviews(rating, comment, date) 
VALUES (5, 'Amazing experience!', '2024-01-05'),
       (4, 'Great place, but could use more facilities.', '2024-02-20');

INSERT INTO reservations(start_date, end_date, nb_bivouaker, price, status, user_id, bivouac_id, review_id) 
VALUES ('2024-01-01', '2024-01-05', 3, 102.00, 'confirmed', NULL, 1, 1),
       ('2024-02-01', '2024-02-10', 2, 85.00, 'pending', NULL, 1, 2);