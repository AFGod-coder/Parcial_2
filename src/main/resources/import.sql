-- Usar la base de datos
USE dbparcial;

-- Insertar datos en la tabla 'role'
INSERT INTO role (role_name) VALUES
                                 ('Admin'),
                                 ('User '),
                                 ('Manager');

-- Insertar datos en la tabla 'user'
INSERT INTO user (username, password, email) VALUES
                                                 ('admin_user', 'admin123', 'admin@example.com'),
                                                 ('regular_user', 'user123', 'user@example.com'),
                                                 ('manager_user', 'manager123', 'manager@example.com');

-- Insertar datos en la tabla 'vehicle_types'
INSERT INTO vehicle_types (type_name) VALUES
                                          ('Carro'),
                                          ('Moto'),
                                          ('Camión');

-- Insertar datos en la tabla 'vehicles'
INSERT INTO vehicles (license_plate, entry_time, exit_time, location, vehicle_type_id) VALUES
                                                                                           ('ABC123', '2023-10-01 08:00:00', NULL, 'A1', 1),  -- Carro
                                                                                           ('XYZ456', '2023-10-01 09:00:00', NULL, 'B2', 2),  -- Moto
                                                                                           ('LMN789', '2023-10-01 10:00:00', NULL, 'C3', 3);  -- Camión

-- Insertar datos en la tabla 'user_roles'
INSERT INTO user_roles (user_id, role_id, granted_date) VALUES
                                                            (1, 1, '2023-10-01 08:00:00'),  -- Admin
                                                            (2, 2, '2023-10-01 09:00:00'),  -- Regular User
                                                            (3, 3, '2023-10-01 10:00:00');  -- Manager