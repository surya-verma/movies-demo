INSERT INTO student (id, name) VALUES (1, 'Alice Johnson');
INSERT INTO student (id, name) VALUES (2, 'Bob Smith');
INSERT INTO student (id, name) VALUES (3, 'Charlie Brown');

INSERT INTO student_order (id, student_id, order_date, truck_id) VALUES (1, 1, '2024-10-01', 101);
INSERT INTO student_order (id, student_id, order_date, truck_id) VALUES (2, 2, '2024-10-05', 102);
INSERT INTO student_order (id, student_id, order_date, truck_id) VALUES (3, 3, '2024-10-10', 102);

INSERT INTO flavor (id, order_id, name) VALUES (1, 1, 'Vanilla');
INSERT INTO flavor (id, order_id, name) VALUES (2, 1, 'Chocolate');
INSERT INTO flavor (id, order_id, name) VALUES (3, 2, 'Strawberry');
INSERT INTO flavor (id, order_id, name) VALUES (4, 3, 'Mint');
INSERT INTO flavor (id, order_id, name) VALUES (5, 3, 'Mint');

