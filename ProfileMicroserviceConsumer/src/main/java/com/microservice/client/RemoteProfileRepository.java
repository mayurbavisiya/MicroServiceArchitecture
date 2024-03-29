package com.microservice.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.microservice.client.Profile;

/**
 * @author Administrator
 *
 */
public class RemoteProfileRepository implements ProfileRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteProfileRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}

	@Override
	public List<Profile> getAllProfiles() {
		Profile[] profiles = restTemplate.getForObject(
				serviceUrl + "/profiles", Profile[].class);
		return Arrays.asList(profiles);
	}

	@Override
	public Profile getProfileById(String userId) {
		return restTemplate.getForObject(serviceUrl + "/profiles/{id}",
				Profile.class, userId);
	}

	@Override
	public Profile save(Profile profile) {
		return restTemplate.postForObject(serviceUrl + "/saveProfile", profile,
				Profile.class);

	}

}
