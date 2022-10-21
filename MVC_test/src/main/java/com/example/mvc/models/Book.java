package com.example.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //represents an entity model for our application

@Table(name = "books") //sets this as a table in the database

public class Book {
	
	//Validation Annotations for table in our schema
	
	@Id //sets this as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //sets this as an auto-incrementing value
	private Long id;
	
	@NotNull (message = "Must not be blank")
	@Size(min = 5, max = 200, message = "Must be at least 5 characters") //adds validation that the column must be in the specified range
	private String title; // column name
	
	@NotNull //adds validation that the column must be null
	@Size(min = 5, max = 200, message = "Must be at least 5 characters")
	private String description; // column name
	
	@NotNull (message = "Must not be blank")
	@Size(min = 3, max = 40, message = "Must be at least 3 characters")
	private String language; // column name
	
	@NotNull (message = "Must not be blank")
	@Min(value=100, message = "Must be at least 100 pages") //adds validation that the column must be at least the specified value
	private Integer numberOfPages; // column name
	
	
	// This will not allow the createdAt column to be updated after creation
	
	
	@Column(updatable = false)
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	
	// ------ Constructors ------
    
    public Book() {
    	
    }
	
	public Book(String title, String description, String language, Integer numberOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}
	
	
	
	// other getters and setters removed for brevity
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    
    
    // ----- Getter & Setters -----
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

	
	
}
