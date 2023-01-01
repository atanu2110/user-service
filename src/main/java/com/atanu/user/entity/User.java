package com.atanu.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_name")
	@NotNull(message = "userName cannot be empty")
	private String userName;

	@Column(name = "password")
	@NotNull(message = "password cannot be empty")
	private String password;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "email")
	@Email(message = "not valid email")
	private String email;

}
