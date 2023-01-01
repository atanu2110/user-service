package com.atanu.user.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atanu.user.entity.UserProfile;
import com.atanu.user.service.UserProfileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserProfileController {

	private final UserProfileService userProfileService;

	/**
	 * Service to create new user profile
	 * 
	 * @param user profile
	 * @return create user profile
	 */
	@PostMapping("/users")
	public ResponseEntity<UserProfile> createUser(@Valid @RequestBody UserProfile userProfile) {
		return new ResponseEntity<>(userProfileService.createUser(userProfile), HttpStatus.CREATED);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<UserProfile> getUserById(@PathVariable(value = "id") Long userProfileId) {
		return new ResponseEntity<>(userProfileService.getUser(userProfileId), HttpStatus.OK);
	}

	@PutMapping("/users")
	public ResponseEntity<UserProfile> updateUser(@Valid @RequestBody UserProfile userProfile) {
		return new ResponseEntity<>(userProfileService.updateUser(userProfile), HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userProfileId) {
		userProfileService.deleteUser(userProfileId);
		return new ResponseEntity<>("User deleted successfully !!", HttpStatus.OK);
	}

}
