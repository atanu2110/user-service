package com.atanu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atanu.user.entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}
