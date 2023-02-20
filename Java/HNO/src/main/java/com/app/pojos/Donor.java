package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="signup_donor")
//Lombok annotations
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "donorPassword")
public class Donor extends BaseEntity{
	@Column(length=20, nullable = false)
	private String donorName;
	@Column(length=100, nullable = false)
	private String donorAddress;
	@Column(length = 30, unique = true, nullable = false)
	private String donorEmailId;
	@Column(length = 20, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String donorPassword;
	@Column(length=10, nullable = false)
	private boolean donorStatus;
}
