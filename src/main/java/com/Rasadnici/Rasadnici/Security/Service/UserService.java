package com.Rasadnici.Rasadnici.Security.Service;

import com.Rasadnici.Rasadnici.Security.DAO.UserRepository;
import com.Rasadnici.Rasadnici.Security.Data.Farmer;
import com.Rasadnici.Rasadnici.Security.Data.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(String id, User farmer) {
        userRepository.deleteById(Long.parseLong(id));
        userRepository.save(farmer);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(Long.parseLong(id));
    }

	public void approveUser(String id) {
	}

	public void declineUser(String id) {
	}


}
