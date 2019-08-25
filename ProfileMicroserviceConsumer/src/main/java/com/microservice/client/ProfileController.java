package com.microservice.client;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api")
@Validated
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	
	@Autowired
	ProfileRepository profileRepository;
	
	

	@ApiOperation(value = "Get all Users")
	@GetMapping("/userProfiles")
	public Map<String, Object> getAllUserProfiles() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Profile> profiles = profileRepository.getAllProfiles();
			map.put("response", profiles);
			map.put("responseCode", 1);
		} catch (Exception e) {
			map.put("Response", e.getMessage());
			map.put("ResponseCode", 0);
			logger.error("Exception occured : " , e);
		}
		logger.info("userProfiles has been called");
		return map;
	}

	@ApiOperation(value = "Save User")
	@PostMapping("/saveUserProfile")
	public Map<String, Object> save(@Valid @RequestBody ProfileDTO profileDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Profile profile = new Profile();
			profile.setName(profileDTO.getName());
			Profile entity = profileRepository.save(profile);
			map.put("response", entity);
			map.put("responseCode", 1);
		} catch (Exception e) {
			map.put("Response", e.getMessage());
			map.put("ResponseCode", 0);
			logger.error("Exception occured : " , e);
		}
		logger.info("saveUserProfile has been called");
		return map;
	}

	@ApiOperation(value = "Get an user by userId")
	@GetMapping("/userProfilesById/{id}")
	public Map<String, Object> getEmployeeById(
			@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable(value = "id") String id)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Profile profile = profileRepository.getProfileById(id);
			if (profile != null) {
				map.put("response", profile);
			} else {
				map.put("response", "User not exist with id : " + id);
			}
			map.put("responseCode", 1);
		} catch (Exception e) {
			map.put("Response", e.getMessage());
			map.put("ResponseCode", 0);
			logger.error("Exception occured : " , e);
		}
		logger.info("userProfilesById/{id} has been called");
		return map;
	}
}
