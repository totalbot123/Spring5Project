package com.Rasadnici.Rasadnici.SecurityTest.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.Rasadnici.Rasadnici.Security.DAO.UserRepository;
import com.Rasadnici.Rasadnici.Security.Data.Farmer;
import com.Rasadnici.Rasadnici.Security.Data.User;
import com.Rasadnici.Rasadnici.Security.Service.RasadnikUserService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@TestInstance(Lifecycle.PER_CLASS)
class RasadnikUserServiceTest {

    RasadnikUserService rasadnikUserService;

    @Mock
    UserRepository userRepository;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        rasadnikUserService = new RasadnikUserService(userRepository, null);
    }

    @Test
    public void testFindUser() {
        User user = new User();
        when(rasadnikUserService.findUser("admin")).thenReturn(user);
        User testUser = rasadnikUserService.findUser("admin");
        assertEquals(user, testUser);

        verify(userRepository, atLeastOnce());
    }

    @Test
    public void testSaveUser() {
        when(rasadnikUserService.findUser("user")).thenReturn(null);
        User user = userRepository.findByUsername("user");
        assertEquals(user, null);

        User farmer = new Farmer();
        when(rasadnikUserService.findUser("user")).thenReturn(farmer);
        User isFarmer = userRepository.findByUsername("user");
        assertEquals(farmer, isFarmer);
    }

    @Test
    public void testUpdateUser() {
        User user = new Farmer();
        user.setId((long) 1);
        user.setEmail("test@test.com");
        when(rasadnikUserService.findUserById((long) 1)).thenReturn(Optional.of(user));
        Optional<User> optUser = rasadnikUserService.findUserById((long) 1);
        User testUser = optUser.get();
        assertEquals("test@test.com", testUser.getEmail());

        testUser.setEmail("verify@verify.com");
        assertEquals("verify@verify.com", testUser.getEmail());
    }

    @Test
    public void testDeleteUser() {
        testDeleteDecline();
    }

    @Test
    public void testApproveUser() {
        User farmer = new Farmer();
        farmer.setId((long) 1);
        farmer.setActive(false);
        assertEquals(false, farmer.getActive());

        when(rasadnikUserService.findUserById((long) 1)).thenReturn(Optional.of(farmer));
        Optional<User> optUser = rasadnikUserService.findUserById((long) 1);
        User user = optUser.get();
        assertEquals(false, user.getActive());
        user.setActive(true);
        assertEquals(true, user.getActive());
    }

    @Test
    public void testDeclineUser() {
        testDeleteDecline();
    }

    private void testDeleteDecline() {
        User farmer = new Farmer();
        farmer.setId((long) 1);
        farmer.setActive(false);
        assertEquals(false, farmer.getActive());

        when(rasadnikUserService.findUserById((long) 1)).thenReturn(Optional.empty());
        boolean userTest = rasadnikUserService.findUserById((long) 1).isPresent();
        assertEquals(false, userTest);
    }

}
