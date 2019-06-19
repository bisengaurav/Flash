package com.kone.cplan.jpa.repository;

import com.kone.cplan.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This repository works with the User entity.
 * 
 * @author Gennadiy Pervukhin
 * @created 30-05-2019
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findBySfId(String sfId);

	User findFirstByFederationIdentifier(String federationId);
}