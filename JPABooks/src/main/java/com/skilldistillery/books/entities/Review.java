package com.skilldistillery.books.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="public")
	private boolean visibile;
	
	private String description;
	
	
	
	public Review() { }



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public boolean isVisibile() {
		return visibile;
	}



	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", book=" + book + ", user=" + user + ", visibile=" + visibile + ", description="
				+ description + "]";
	}
	
	
	
	
	

}
