package com.skilldistillery.books.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String  title;
	
	private String author;
	
	private String synopsis;
	
	@Column(name="cover_art")
	private String coverArt;
	
	
	
	public Book() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getSynopsis() {
		return synopsis;
	}



	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}



	public String getCoverArt() {
		return coverArt;
	}



	public void setCoverArt(String coverArt) {
		this.coverArt = coverArt;
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
		Book other = (Book) obj;
		return id == other.id;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", synopsis=" + synopsis + ", coverArt="
				+ coverArt + "]";
	}


}
