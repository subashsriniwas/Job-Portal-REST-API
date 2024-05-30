# Job Posting REST API

This REST API provides functionality for managing job postings. It allows users to create, read, update, and delete job posts, search for job posts by keywords, and filter job posts by salary. Below are the details of the endpoints available in this API.

## Table of Contents
1. [Endpoints](#endpoints)
    - [Create Job Post](#create-job-post)
    - [Get Job Post by ID](#get-job-post-by-id)
    - [Get All Job Posts](#get-all-job-posts)
    - [Update Job Post](#update-job-post)
    - [Delete Job Post](#delete-job-post)
    - [Search Job Posts by Keyword](#search-job-posts-by-keyword)
    - [Filter Job Posts by Salary](#filter-job-posts-by-salary)
2. [Setup and Configuration](#setup-and-configuration)
3. [Dependencies](#dependencies)
4. [Usage](#usage)

## Endpoints

### Create Job Post

- **URL:** `/save`
- **Method:** `POST`
- **Request Body:** JSON representation of a `JobPost` object
- **Response:** 
  - Status: `200 OK`
  - Body: `"Saved"`

**Example Request:**
```json
{
    "title": "Software Engineer",
    "description": "Develop and maintain software applications.",
    "location": "San Francisco, CA",
    "salary": 120000
}
```

**Example Response:**
```json
"Saved"
```

### Get Job Post by ID

- **URL:** `/jobs/{postId}`
- **Method:** `GET`
- **Path Variable:**
  - `postId`: Integer ID of the job post
- **Response:** JSON representation of the `JobPost` object or `null` if not found

**Example Response:**
```json
{
    "postId": 1,
    "title": "Software Engineer",
    "description": "Develop and maintain software applications.",
    "location": "San Francisco, CA",
    "salary": 120000
}
```

### Get All Job Posts

- **URL:** `/jobs`
- **Method:** `GET`
- **Response:** List of `JobPost` objects in JSON format

**Example Response:**
```json
[
    {
        "postId": 1,
        "title": "Software Engineer",
        "description": "Develop and maintain software applications.",
        "location": "San Francisco, CA",
        "salary": 120000
    },
    {
        "postId": 2,
        "title": "Data Scientist",
        "description": "Analyze and interpret complex data.",
        "location": "New York, NY",
        "salary": 130000
    }
]
```

### Update Job Post

- **URL:** `/update`
- **Method:** `PUT`
- **Request Body:** JSON representation of a `JobPost` object
- **Response:** 
  - Status: `200 OK`
  - Body: `"Updated"`

**Example Request:**
```json
{
    "postId": 1,
    "title": "Senior Software Engineer",
    "description": "Develop and maintain software applications, lead a team.",
    "location": "San Francisco, CA",
    "salary": 150000
}
```

**Example Response:**
```json
"Updated"
```

### Delete Job Post

- **URL:** `/delete/{postId}`
- **Method:** `DELETE`
- **Path Variable:**
  - `postId`: Integer ID of the job post
- **Response:**
  - Status: `200 OK`
  - Body: `"deleted"`

**Example Response:**
```json
"deleted"
```

### Search Job Posts by Keyword

- **URL:** `/jobs/search/{keyword}`
- **Method:** `GET`
- **Path Variable:**
  - `keyword`: String keyword to search in job posts
- **Response:** List of `JobPost` objects in JSON format that match the keyword

**Example Response:**
```json
[
    {
        "postId": 1,
        "title": "Software Engineer",
        "description": "Develop and maintain software applications.",
        "location": "San Francisco, CA",
        "salary": 120000
    }
]
```

### Filter Job Posts by Salary

- **URL:** `/jobs/salary/{salary}`
- **Method:** `GET`
- **Path Variable:**
  - `salary`: Long salary to filter job posts by
- **Response:** List of `JobPost` objects in JSON format that match the salary

**Example Response:**
```json
[
    {
        "postId": 1,
        "title": "Software Engineer",
        "description": "Develop and maintain software applications.",
        "location": "San Francisco, CA",
        "salary": 120000
    }
]
```

## Setup and Configuration

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Build the project:**
   ```sh
   mvn clean install
   ```

3. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

## Dependencies

- **Spring Boot:** Framework for building Java-based web applications.
- **Spring Web:** Module for creating RESTful web services.
- **Spring Data JPA:** Module for database operations using JPA.
- **H2 Database:** In-memory database for testing purposes.

## Usage

After starting the application, you can use tools like Postman or curl to interact with the endpoints. Below are some example curl commands:

- **Create Job Post:**
  ```sh
  curl -X POST -H "Content-Type: application/json" -d '{"title":"Software Engineer","description":"Develop and maintain software applications.","location":"San Francisco, CA","salary":120000}' http://localhost:8080/save
  ```

- **Get Job Post by ID:**
  ```sh
  curl -X GET http://localhost:8080/jobs/1
  ```

- **Get All Job Posts:**
  ```sh
  curl -X GET http://localhost:8080/jobs
  ```

- **Update Job Post:**
  ```sh
  curl -X PUT -H "Content-Type: application/json" -d '{"postId":1,"title":"Senior Software Engineer","description":"Develop and maintain software applications, lead a team.","location":"San Francisco, CA","salary":150000}' http://localhost:8080/update
  ```

- **Delete Job Post:**
  ```sh
  curl -X DELETE http://localhost:8080/delete/1
  ```

- **Search Job Posts by Keyword:**
  ```sh
  curl -X GET http://localhost:8080/jobs/search/Engineer
  ```

- **Filter Job Posts by Salary:**
  ```sh
  curl -X GET http://localhost:8080/jobs/salary/120000
  ```
