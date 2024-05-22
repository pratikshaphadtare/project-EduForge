package com.rating.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//Rating.java

@Setter
@Getter
@Entity
@Table(name="rating_data")
public class Rating {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private int rating;
 private String message;
 private String courseName;


}
