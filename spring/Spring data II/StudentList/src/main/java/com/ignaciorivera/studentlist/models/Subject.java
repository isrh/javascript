package com.ignaciorivera.studentlist.models;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="subjects")
public class Subject {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	@Size(min=2, max=100)
	 private String name;
	 
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "subjects_students", 
	     joinColumns = @JoinColumn(name = "subject_id"), 
	     inverseJoinColumns = @JoinColumn(name = "student_id")
	 )     
	 private List<Student> students;

	public Subject() {
	
	}

	public Subject(String name, List<Student> students) {
		
		this.name = name;
		this.students = students;
	}
	
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
	
	
	
}
