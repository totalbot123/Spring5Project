package com.Rasadnici.Rasadnici.Security.Service;

import java.util.Optional;

import com.Rasadnici.Rasadnici.Security.Data.User;

public interface UserService {

    public User findUser(String username);

    public Optional<User> findUserById(Long id);

    public void saveUser(User user);

    public void updateUser(Long id, User farmer);

    public void deleteUser(Long id);

    public void approveUser(Long id);

    public void declineUser(Long id);

}