package com.microservice.producer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


/**
 * @author Administrator
 *
 */
public interface ProfileRepository extends CrudRepository<Profile, Long> {

	Profile findById(Long userId);

	List<Profile> findAll();

}
