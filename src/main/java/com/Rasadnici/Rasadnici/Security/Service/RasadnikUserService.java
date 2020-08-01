package com.Rasadnici.Rasadnici.Security.Service;

import static com.Rasadnici.Rasadnici.Constants.NUMBER_OF_DRIVERS;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.Rasadnici.Rasadnici.Company.CompanyData.Company;
import com.Rasadnici.Rasadnici.Company.Driver.DriverDAO.DriverRepository;
import com.Rasadnici.Rasadnici.Security.DAO.UserRepository;
import com.Rasadnici.Rasadnici.Security.Data.User;
import com.Rasadnici.Rasadnici.Company.Driver.DriverData.Driver;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RasadnikUserService implements UserService {

    private UserRepository userRepository;
    private DriverRepository driverRepository;

    public RasadnikUserService(UserRepository userRepository, DriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    public User findUser(String username) {
        Optional<User> optUser = userRepository.findByUsername(username);
        User user = optUser.orElseThrow(() -> new UsernameNotFoundException(username + "is not valid username!"));
        return user;
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
        addDriversToCompany(user);
    }

    private void addDriversToCompany(User user) {
        if (!(user instanceof Company)) {
            return;
        }
        Set<Driver> drivers = new HashSet<Driver>();
        for (int i = 0; i < NUMBER_OF_DRIVERS; ++i) {
            drivers.add(new Driver(true, (Company) user));
        }
        driverRepository.saveAll(drivers);
    }

}
