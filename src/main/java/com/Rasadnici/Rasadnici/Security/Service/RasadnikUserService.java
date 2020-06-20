package com.Rasadnici.Rasadnici.Security.Service;

import java.util.Optional;

import com.Rasadnici.Rasadnici.Security.DAO.UserRepository;
import com.Rasadnici.Rasadnici.Security.Data.User;

import org.springframework.stereotype.Service;

@Service
public class RasadnikUserService implements UserService {

    private UserRepository userRepository;

    public RasadnikUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long id, User farmer) {
        userRepository.save(farmer);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void approveUser(Long id) {
        setUserStatus(id, true);
    }

    public void declineUser(Long id) {
        userRepository.deleteById(id);
    }

    private void setUserStatus(Long id, boolean status) {
        User user = findUserById(id).get();
        user.setActive(status);
        userRepository.save(user);
    }

}
