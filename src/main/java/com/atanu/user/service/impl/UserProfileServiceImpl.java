package com.atanu.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.atanu.user.entity.UserProfile;
import com.atanu.user.exception.UserNotFoundException;
import com.atanu.user.repository.UserProfileRepository;
import com.atanu.user.service.UserProfileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserProfileServiceImpl implements UserProfileService {
	private static final Logger LOG = LoggerFactory.getLogger(UserProfileServiceImpl.class);

	private final UserProfileRepository userProfileRepository;

	@Override
	public UserProfile createUser(UserProfile userProfile) {
		LOG.info("Creating new user with email {}", userProfile.getUserLogin().getEmail());

		// Encrypt the password with Bcrypt Hash
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userProfile.getUserLogin().setPassword(passwordEncoder.encode(userProfile.getUserLogin().getPassword()));
		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile updateUser(UserProfile userProfile) {
		LOG.info("Updating user id:  {}", userProfile.getId());
		UserProfile userProfileInDB = userProfileRepository.findById(userProfile.getId())
				.orElseThrow(() -> new UserNotFoundException("User not found ::" + userProfile.getId()));

		userProfileInDB.setFirstName(userProfile.getFirstName());
		userProfileInDB.setLastName(userProfile.getLastName());
		userProfileInDB.setGender(userProfile.getGender());
		userProfileInDB.setShippingAddress(userProfile.getShippingAddress());
		userProfileInDB.setBillingAddress(userProfile.getBillingAddress());
		userProfileInDB.setUserLogin(userProfile.getUserLogin());

		return userProfileRepository.save(userProfileInDB);
	}

	@Override
	public UserProfile getUser(Long userProfileId) {
		UserProfile userProfile = userProfileRepository.findById(userProfileId)
				.orElseThrow(() -> new UserNotFoundException("User not found ::" + userProfileId));
		return userProfile;
	}

	@Override
	public void deleteUser(Long userProfileId) {
		LOG.info("Deleting user id:  {}", userProfileId);

		UserProfile userProfile = userProfileRepository.findById(userProfileId)
				.orElseThrow(() -> new UserNotFoundException("User not found ::" + userProfileId));

		userProfileRepository.delete(userProfile);
	}

}
