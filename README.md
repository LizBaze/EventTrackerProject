# EventTrackerProject

### Description

This project is meant to allow users to log what books they've read recently and record their thoughts and takeaways in the process. A stretch goal is to allow users to see other users' reviews of books as well. 

### Route Mappings

| Return Type     | Route                 | Functionality            |
|-----------------|-----------------------|--------------------------|
| `List<User>`    |`GET api/users` | Gets all users|
| `User` | `GET api/users/{id}` | Gets a specific user |
| `User` | `POST` api/users | Creates a new user |
| `User` | `PUT` api/users/{id} | Updates a user |
| `void` | `DELETE` api/users/{id} | Deletes a user |
| `List<Book>`    |`GET api/books` | Gets all books|
| `Book` | `GET api/book/{id}` | Gets a specific book |
| `Book` | `POST` api/books | Creates a new book |
| `Book` | `PUT` api/books/{id} | Updates a book |
| `void` | `DELETE` api/books/{id} | Deletes a book |
| `List<Review>`    |`GET api/reviews` | Gets all reviews|
| `Review` | `GET api/reviews/{id}` | Gets a specific review |
| `Review` | `POST` api/reviews | Creates a new review |
| `Review` | `PUT` api/reviews/{id} | Updates a review |
| `void` | `DELETE` api/reviews/{id} | Deletes a review |


### Technologies Used
- Java
- Spring Data JPA
- SpringBoot
- RESTful APIs

### Database Schema
The project makes use of a relatively simple database schema of four tables; User, Book, Review, and follower. The review table not only holds users' reviews of books but serves as a join table between User and Book.
![Screen Shot 2023-01-22 at 11 53 57 AM](https://user-images.githubusercontent.com/112978206/213931846-ae91130f-4444-4d72-bf2c-fde1729f0505.png)
