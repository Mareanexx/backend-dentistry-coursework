package com.clinic.dentistry.service;

import com.clinic.dentistry.repo.EmployeeRepository;
import com.clinic.dentistry.repo.OutpatientCardRepository;
import com.clinic.dentistry.repo.UserRepository;
import com.clinic.dentistry.service.impl.RegistrationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationServiceTest {
    @Mock
    private OutpatientCardRepository outpatientCardRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRepository userRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private UserService userService;
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("RegistrationService#userRegistration test")
    public void testUserRegistration() {}

    @Test
    @DisplayName("RegistrationService#getUserList test")
    public void testGetUserList() {}

    @Test
    @DisplayName("RegistrationService#getUserByID test")
    public void testGetUserByID() {}

    @Test
    @DisplayName("RegistrationService#getMyProfile test")
    public void testGetMyProfile() {}

    @Test
    @DisplayName("RegistrationService#createUser test")
    public void testCreateUser() {}

    @Test
    @DisplayName("RegistrationService#editUser test")
    public void testEditUser() {}
}
