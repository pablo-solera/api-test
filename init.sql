-- Script de inicialización de datos de prueba
-- Este script se ejecuta automáticamente cuando se crea el contenedor de PostgreSQL

-- Insertar categorías
    INSERT INTO categories (id, name, description) VALUES
    (1, 'Electrónica', 'Productos electrónicos y gadgets'),
    (2, 'Ropa', 'Ropa y accesorios de moda'),
    (3, 'Hogar', 'Artículos para el hogar y decoración'),
    (4, 'Deportes', 'Equipamiento deportivo y fitness'),
    (5, 'Libros', 'Libros y material de lectura');

-- Insertar productos
INSERT INTO products (id, name, description, price, category_id)
VALUES
-- Productos de Electrónica
(1, 'Laptop HP 15', 'Laptop con procesador Intel i5, 8GB RAM, 256GB SSD', 699.99, 1),
(2, 'Mouse Logitech MX', 'Mouse inalámbrico ergonómico', 79.99, 1),
(3, 'Teclado Mecánico', 'Teclado mecánico RGB con switches azules', 129.99, 1),
(4, 'Auriculares Sony', 'Auriculares con cancelación de ruido', 299.99, 1),
(5, 'Webcam HD', 'Webcam 1080p para videoconferencias', 49.99, 1),

-- Productos de Ropa
(6, 'Camiseta Nike', 'Camiseta deportiva de algodón', 29.99, 2),
(7, 'Jeans Levis 501', 'Jeans clásicos de corte recto', 89.99, 2),
(8, 'Zapatillas Adidas', 'Zapatillas running ultraboost', 179.99, 2),
(9, 'Chaqueta North Face', 'Chaqueta impermeable para montaña', 249.99, 2),
(10, 'Gorra New Era', 'Gorra ajustable de béisbol', 34.99, 2),

-- Productos de Hogar
(11, 'Cafetera Nespresso', 'Cafetera de cápsulas automática', 199.99, 3),
(12, 'Aspiradora Dyson', 'Aspiradora sin cable V11', 499.99, 3),
(13, 'Lámpara LED', 'Lámpara de escritorio regulable', 39.99, 3),
(14, 'Set de Sartenes', 'Set de 3 sartenes antiadherentes', 79.99, 3),
(15, 'Almohada Memory Foam', 'Almohada viscoelástica ergonómica', 59.99, 3),

-- Productos de Deportes
(16, 'Balón de Fútbol', 'Balón oficial tamaño 5', 29.99, 4),
(17, 'Pesas Ajustables', 'Set de pesas de 5-25kg', 199.99, 4),
(18, 'Esterilla Yoga', 'Esterilla antideslizante 6mm', 34.99, 4),
(19, 'Bicicleta Estática', 'Bicicleta para entrenamiento en casa', 399.99, 4),
(20, 'Cuerda de Saltar', 'Cuerda profesional para crossfit', 19.99, 4),

-- Productos de Libros
(21, 'Clean Code', 'Libro sobre buenas prácticas de programación', 39.99, 5),
(22, 'El Principito', 'Clásico de la literatura francesa', 12.99, 5),
(23, 'Sapiens', 'De animales a dioses: breve historia de la humanidad', 24.99, 5),
(24, '1984', 'Novela distópica de George Orwell', 14.99, 5),
(25, 'Atomic Habits', 'Guía para crear buenos hábitos', 19.99, 5);

-- Resetear las secuencias (para que los siguientes inserts empiecen desde el ID correcto)
SELECT setval('categories_id_seq', (SELECT MAX(id) FROM categories));
SELECT setval('products_id_seq', (SELECT MAX(id) FROM products));