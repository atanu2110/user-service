package com.atanu.user.service;

import com.atanu.user.entity.UserProfile;

public interface UserProfileService {

	UserProfile createUser(UserProfile userProfile);

	UserProfile updateUser(UserProfile userProfile);

	UserProfile getUser(Long userProfileId);

	void deleteUser(Long userProfileId);
	
}
