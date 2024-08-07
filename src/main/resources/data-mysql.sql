INSERT INTO gestion.puesto (id, nombre)VALUES(1, "CEO");
INSERT INTO gestion.puesto (id, nombre)VALUES(2, "MANAGER");
INSERT INTO gestion.puesto (id, nombre)VALUES(3, "OPERACIONES");
INSERT INTO gestion.puesto (id, nombre)VALUES(4, "DISENIO");
INSERT INTO gestion.puesto (id, nombre)VALUES(5, "VENTAS");
INSERT INTO gestion.puesto (id, nombre)VALUES(6, "COMUNICACION");
INSERT INTO gestion.puesto (id, nombre)VALUES(7, "EMPLOYEE");


INSERT INTO direccion (id, calle, colonia, estado, municipio, no_exterior, no_interior, pais) VALUES(1, 'Av. Siempre Viva', 'Centro', 'Edomex', 'Ecatepec', '742', 'A', 'México');
INSERT INTO direccion (id, calle, colonia, estado, municipio, no_exterior, no_interior, pais) VALUES(2, 'Av. Siempre Viva', 'Centro', 'Edomex', 'Ecatepec', '742', 'A', 'México');
INSERT INTO direccion (id, calle, colonia, estado, municipio, no_exterior, no_interior, pais) VALUES(3, 'Av. Siempre Viva', 'Centro', 'Edomex', 'Ecatepec', '742', NULL, 'México');
INSERT INTO direccion (id, calle, colonia, estado, municipio, no_exterior, no_interior, pais) VALUES(4, 'Av. Siempre Viva', 'Centro', 'Edomex', 'Ecatepec', '742', NULL, 'México');
INSERT INTO direccion (id, calle, colonia, estado, municipio, no_exterior, no_interior, pais) VALUES(5, 'Av. Siempre Viva', 'Centro', 'Edomex', 'Ecatepec', '742', 'A', 'México');


INSERT INTO empleado (direccion_id, id, jefe_id, puesto_id, apellidos, curp, nombre) VALUES(1, 1, NULL, 1, 'X', 'PEPJ800101HDFNNN08', 'Yolanda');
INSERT INTO empleado (direccion_id, id, jefe_id, puesto_id, apellidos, curp, nombre) VALUES(2, 2, 1, 2, 'X', 'PEPJ800101HDFNNN08', 'Daniel');
INSERT INTO empleado (direccion_id, id, jefe_id, puesto_id, apellidos, curp, nombre) VALUES(3, 3, 2, 3, 'X', 'PEPJ800101HDFNNN08', 'Rocio');
INSERT INTO empleado (direccion_id, id, jefe_id, puesto_id, apellidos, curp, nombre) VALUES(4, 4, 3, 7, 'X', 'PEPJ800101HDFNNN08', 'Claudia');
INSERT INTO empleado (direccion_id, id, jefe_id, puesto_id, apellidos, curp, nombre) VALUES(5, 5, 3, 7, 'X', 'PEPJ800101HDFNNN08', 'Hector');