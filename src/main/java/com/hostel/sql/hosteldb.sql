/* Create database */
CREATE DATABASE hostel_db; /* name database 'hostel_db' */
USE hostel_db;

/* Create these 5 sql tables */
/* Stores student user info */
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(10)
);

/* Stores admin user info */
CREATE TABLE admins (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(20) DEFAULT 'ADMIN'
);

/* Stores hostel room info */
CREATE TABLE rooms (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    gender VARCHAR(10),
    price DOUBLE,
    available BOOLEAN DEFAULT TRUE
);

/* Stores booking records */
CREATE TABLE bookings (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'PENDING',
    student_id BIGINT,
    room_id BIGINT,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
);

/* Stores messages to students */
CREATE TABLE notifications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT,
    seen BOOLEAN DEFAULT FALSE,
    student_id BIGINT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);


/* Tables are auto-mapped using your @Entity model classes */