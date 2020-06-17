package com.Rasadnici.Rasadnici.Security.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Rasadnici.Rasadnici.Security.Data.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);

}
