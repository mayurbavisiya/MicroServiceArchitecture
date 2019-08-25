package com.microservice.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 *
 */
@RestController
public class ProfileController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProfileController.class);

	@Autowired
	ProfileRepository profileRepository;

	@RequestMapping("/profiles")
	public Profile[] all() {

		List<Profile> profiles = profileRepository.findAll();
		logger.info("/profiles callesd from producer");
		return profiles.toArray(new Profile[profiles.size()]);
	}

	@RequestMapping("/profiles/{id}")
	public Profile byId(@PathVariable("id") String userId) {
		Profile profile = profileRepository.findById(Long.valueOf(userId));
		logger.info("/profiles/{id} callesd from producer");
		return profile;
	}

	@PostMapping("/saveProfile")
	public Profile save(@Valid @RequestBody Profile profile) {
		logger.info("/saveProfile callesd from producer");
		return profileRepository.save(profile);
	}
}