package com.Rasadnici.Rasadnici.Security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public String findPasswordByUsername(String username);
	
}
