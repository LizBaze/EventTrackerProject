# BookWorm

### Description

This project is meant to allow users to log what books they've read recently and record their thoughts and takeaways in the process.

The front end was made with angular. Full CRUD is enabled of reviews.

### Route Mappings

| Return Type     | Route                 | Functionality            | Request Body | Response Body |
|-----------------|-----------------------|--------------------------| ------------ | ------------- |

| `List<Review>`    |`GET api/reviews` | Gets all reviews| | Collection of representations of Review objects |
| `Review` | `GET api/reviews/{id}` | Gets a specific review | | Representation of review {id} |
| `Review` | `POST` api/reviews | Creates a new review* | Representation of a new review object | Representation of the created review object or an error message |
| `Review` | `PUT` api/reviews/{id} | Updates a review | Representation of new version of review {id} | Representation of the changed review object or an error message |
| `void` | `DELETE` api/reviews/{id} | Deletes a review | | |


### Technologies Used
- Java
- Spring Data JPA
- SpringBoot
- RESTful APIs
- Javascript
- Angular


### Database Schema
The project makes use of a simple, single table database.

![Screen Shot 2023-01-22 at 11 53 57 AM](https://user-images.githubusercontent.com/112978206/213931846-ae91130f-4444-4d72-bf2c-fde1729f0505.png)
