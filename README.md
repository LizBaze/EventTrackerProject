# BookWorm

### Description

This project is meant to allow users to log what books they've read recently and record their thoughts and takeaways in the process. A stretch goal is to allow users to see other users' reviews of books as well.

There is a rudimentary javascript front end that handles all network requests through the use of XMLHttpRequest objects. Full CRUD is enabled of book objects. There will be a more well-developed Angular front end next week, at which time I hope to enable full CRUD of User and Review objects as well. 

### Route Mappings

| Return Type     | Route                 | Functionality            | Request Body | Response Body |
|-----------------|-----------------------|--------------------------| ------------ | ------------- |
| `List<User>`    |`GET api/users` | Gets all users| | Collection of representations of User objects
| `User` | `GET api/users/{id}` | Gets a specific user | | Representation of user {id} |
| `User` | `POST` api/users | Creates a new user | Representation of a new user object | Representation of the created user object or an error message |
| `User` | `PUT` api/users/{id} | Updates a user | Representation of new version of user {id} | Representation of the changed user object or an error message |
| `void` | `DELETE` api/users/{id} | Deletes a user | | |
| `List<Book>`    |`GET api/books` | Gets all books| | Collection of representations of Book objects |
| `Book` | `GET api/book/{id}` | Gets a specific book | | Representation of book {id} |
| `Book` | `POST` api/books | Creates a new book | Representaiton of a new book object | Representation of the created book object or an error message |
| `Book` | `PUT` api/books/{id} | Updates a book | Representation of new version of book {id} | Representation of the changed book object or an error message |
| `void` | `DELETE` api/books/{id} | Deletes a book | | |
| `List<Review>`    |`GET api/reviews` | Gets all reviews| | Collection of representations of Review objects |
| `Review` | `GET api/reviews/{id}` | Gets a specific review | | Representation of review {id} |
| `Review` | `POST` api/reviews | Creates a new review* | Represenation of a new review object | Representation of the created review object or an error message |
| `Review` | `PUT` api/reviews/{id} | Updates a review | Representation of new version of review {id} | Representation of the changed review object or an error message |
| `void` | `DELETE` api/reviews/{id} | Deletes a review | | |

*Please note that a user may only have one review for each book. This means that the combination of user_id and book_id must be unique for each review


### Technologies Used
- Java
- Spring Data JPA
- SpringBoot
- RESTful APIs
- Javascript

### Database Schema
The project makes use of a relatively simple database schema of four tables; User, Book, Review, and follower. The review table not only holds users' reviews of books but serves as a join table between User and Book.

![Screen Shot 2023-01-22 at 11 53 57 AM](https://user-images.githubusercontent.com/112978206/213931846-ae91130f-4444-4d72-bf2c-fde1729f0505.png)
