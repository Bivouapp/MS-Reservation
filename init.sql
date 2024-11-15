-- Create Disponibility table
CREATE TABLE disponibility (
    disponibility_id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    bivouac_id INTEGER NOT NULL
);

-- Create Reservations table
CREATE TABLE reservations (
    reservation_id SERIAL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    nb_bivouaker INTEGER NOT NULL,
    price NUMERIC(18, 2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    user_id INTEGER NOT NULL,
    bivouac_id INTEGER NOT NULL,
    review_id INTEGER NOT NULL
);

-- Create Reviews table
CREATE TABLE reviews (
    review_id SERIAL PRIMARY KEY,
    rating INTEGER CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    date DATE NOT NULL
);


INSERT INTO disponibility(start_date, end_date, bivouac_id) 
VALUES ('2024-01-01', '2024-01-10', 1),
       ('2024-02-01', '2024-02-15', 1);

INSERT INTO reviews(rating, comment, date) 
VALUES (5, 'Amazing experience!', '2024-01-05'),
       (4, 'Great place, but could use more facilities.', '2024-02-20');

INSERT INTO reservations(start_date, end_date, nb_bivouaker, price, status, user_id, bivouac_id, review_id) 
VALUES ('2024-01-01', '2024-01-05', 3, 102.00, 'confirmed', 1, 1, 1),
       ('2024-02-01', '2024-02-10', 2, 85.00, 'pending', 4, 1, 2);