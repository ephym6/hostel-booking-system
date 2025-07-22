# Hostel Management System

A modern and robust hostel booking and management system built with Spring Boot 3.x, designed to streamline hostel administration and booking processes.

## 🚀 Features

- User authentication and authorization (Spring Security)
- Hostel room booking management
- Database persistence with JPA
- Web-based user interface with Thymeleaf
- RESTful API endpoints

## 🛠️ Technologies

- **Java**: JDK 24 (with preview features enabled)
- **Framework**: Spring Boot 3.4.6
- **Security**: Spring Security
- **Database**: MySQL/MariaDB
- **ORM**: Spring Data JPA
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven

## ⚙️ Prerequisites

- JDK 24
- MySQL or MariaDB database

## 🔧 Installation & Setup

1. Clone the repository:
2. Navigate to the project directory:
   
   cd hostel-booking-system

3. Configure the database:
   - Create a new database
   - Update `application.properties` with your database credentials
     
4. Run the application:
- Open the project in your IDE
- Navigate to `com.hostel.HostelBookingSystemApplication`
- Run the main method

The application will be available at `http://localhost:8080`

## 🏗️ Project Structure

src/ 
  ├── main/ │ 
    ├── java/ │ 
      │ └── com/hostel/ │ 
        │ 
        ├── config 
        |
        ├── controller/ │ 
        │ 
        ├── dto 
        |
        ├── model/ │ 
        │ 
        ├── repository/ │ 
        │ 
        ├── security/
        │
        ├── service/ 
        |
        ├── sql/ 
        |
        ├── HostelBookingSystemApplication
    ├──resources/ 
        │ ├── static/ 
        │ ├── templates/ 
        │ └── application.properties

## ✨ Acknowledgments

- Spring Boot team for the excellent framework
- All contributors and users of this project


