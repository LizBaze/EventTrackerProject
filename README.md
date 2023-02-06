# BookWorm

### Description

This project is meant to allow users to log what books they've read recently and record their thoughts and takeaways in the process.

The front end was made with angular. Full CRUD is enabled of reviews.

### Route Mappings

| Return Type     | Route                 | Functionality            | Request Body | Response Body |
|-----------------|-----------------------|--------------------------| ------------ | ------------- |
| `List<Review>`    | `GET api/reviews` | Gets all reviews| | Collection of representations of Review objects |
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
- Typescript
