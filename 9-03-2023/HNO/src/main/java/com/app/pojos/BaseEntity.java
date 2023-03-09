package com.app.pojos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//mandatory class level anno so that hibernate will not create any table for this 
public class BaseEntity {
	// to tell the hibernate that this is the primary key
	@Id
	// to tell the hibernate that this is the primary key and auto update(increment)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//getter 
	public Long getId() {
		return id;
	}

//setter
	public void setId(Long id) {
		this.id = id;
	}

}
