CREATE TABLE student
(
    id   INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE student_order (
                         id INT PRIMARY KEY,
                         student_id INT,
                         order_date DATE,
                         truck_id INT,
                         FOREIGN KEY (student_id) REFERENCES student(id)
    );

CREATE TABLE flavor
(
    id       INT PRIMARY KEY,
    order_id INT,
    name     VARCHAR(50) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES  student_order (id)
);