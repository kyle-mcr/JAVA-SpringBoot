package com.kyle.web.JavaPlate.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 @Size(min=2, max=255, message="-First Name must be between 2 and 255 characters")
 private String firstName;
 @Size(min=2, max=255, message="-Last Name must be between 2 and 255 characters")
 private String lastName;
 @Size(min=2, max=255, message="-Email must be valid")
 private String email;
 @Size(min=8, max=255, message="-Password must be greater than 5 characters")
 private String password;
 @Transient
 private String passwordConfirmation;
 
 @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
 private List<Movie> movies;
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
		 name="users_movies",
		 joinColumns = @JoinColumn(name="user_id"),
		 inverseJoinColumns = @JoinColumn(name="movie_id")
		 )
 private List<Movie> likedMovies;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 
 public User() {
 }
 
 
 

public Long getId() {
	return id;
}




public void setId(Long id) {
	this.id = id;
}




public String getFirstName() {
	return firstName;
}




public void setFirstName(String firstName) {
	this.firstName = firstName;
}




public String getLastName() {
	return lastName;
}




public void setLastName(String lastName) {
	this.lastName = lastName;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




public String getPasswordConfirmation() {
	return passwordConfirmation;
}




public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
}




public List<Movie> getMovies() {
	return movies;
}




public void setMovies(List<Movie> movies) {
	this.movies = movies;
}




public List<Movie> getLikedMovies() {
	return likedMovies;
}




public void setLikedMovies(List<Movie> likedMovies) {
	this.likedMovies = likedMovies;
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




@PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
 @PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
}