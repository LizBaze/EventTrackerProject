package com.skilldistillery.books.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private String title;
	
	private String synopsis;
	
	@Column(name="cover_art")
	private String coverArt;
	
	@Column(name="date_created")
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@Column(name="date_updated")
	@UpdateTimestamp
	private LocalDateTime dateUpdated;
	
	
	
	public Review() { }



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
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



	public LocalDateTime getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}



	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}



	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
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
		return "Review [id=" + id + ", description=" + description + ", title=" + title + ", synopsis=" + synopsis
				+ ", coverArt=" + coverArt + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}


}