package com.microservice.client;

import java.util.List;

import com.microservice.client.Profile;

/**
 * @author Administrator
 *
 */
public interface ProfileRepository {
	List<Profile> getAllProfiles();

	Profile getProfileById(String userId);

	Profile save(Profile profile);
}