INSERT INTO user (email, first_name, last_name, password, phone_number, role, cne, center_id, blood_type_id) VALUES
('user1@example.com', 'John', 'Doe', 'password123', '1234567890', 'USER', '123456789', 1, 1),
('user2@example.com', 'Jane', 'Smith', 'password456', '0987654321', 'USER', '987654321', 2, 2),
('admin1@example.com', 'Admin', 'One', 'adminpass1', '5551234567', 'ADMIN', NULL, NULL, NULL),
('admin2@example.com', 'Admin', 'Two', 'adminpass2', '5559876543', 'ADMIN', NULL, NULL, NULL),
('adminc1@example.com', 'Center', 'Admin', 'centerpass1', '5551112222', 'ADMINC', NULL, 1, NULL),
('adminc2@example.com', 'Center', 'Admin', 'centerpass2', '5553334444', 'ADMINC', NULL, 2, NULL);
