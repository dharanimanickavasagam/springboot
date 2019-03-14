package com.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

// Creating Domain Object
// Domain objects are the objects that represents the database rows 

// @Entity
// Entity is something that is to be saved in the database 

// @Table 
// Sql table to be interacted with 

@Entity
@Table(name = "status_update")
public class StatusUpdate {

	// @Id is used to denote the primary key of the table
	// @Column is optional
	// @Column(name="id") id must match with SQL column
	// @GeneratedValue generates id via auto increment
	// @@NotNull - not null

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "text")
	@Size(min = 5, max = 255, message = "{addstatus.text.size}")
	private String text;

	@Column(name = "added")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date added;

	// @PrePersist
	// calls the method to be run before objects are saved to the database
	//

	@PrePersist
	protected void onCreate() {
		if (added == null) {
			added = new Date();
		}
	}

	public StatusUpdate(String text, Date added) {
		this.text = text;
		this.added = added;
	}

	public StatusUpdate() {

	}

	public StatusUpdate(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Date getAdded() {
		return added;
	}

	// getters and setters

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((added == null) ? 0 : added.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusUpdate other = (StatusUpdate) obj;
		if (added == null) {
			if (other.added != null)
				return false;
		} else if (!added.equals(other.added))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StatusUpdate [id=" + id + ", text=" + text + ", added=" + added
				+ "]";
	}

}
