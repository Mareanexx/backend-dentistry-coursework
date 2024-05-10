package com.clinic.dentistry.service;

import com.clinic.dentistry.repo.AppointmentRepository;
import com.clinic.dentistry.repo.EmployeeRepository;
import com.clinic.dentistry.repo.UserRepository;
import com.clinic.dentistry.service.impl.AppointmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AppointmentServiceTest {
    @Mock
    private AppointmentRepository appointmentRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeService employeeService;
    @Mock
    private GoodService goodService;
    @Mock
    private CheckService checkService;
    @InjectMocks
    private AppointmentServiceImpl appointmentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("AppointmentService#getClientList test")
    public void testGetClientList() {}

    @Test
    @DisplayName("AppointmentService#getDoctorList test")
    public void testGetDoctorList() {}

    @Test
    @DisplayName("AppointmentService#appointmentsAddForm test")
    public void testAppointmentsAddForm() {}

    @Test
    @DisplayName("AppointmentService#appointmentsAdd test")
    public void testAppointmentsAdd() {}

    @Test
    @DisplayName("AppointmentService#getAppointment test")
    public void testGetAppointment() {}

    @Test
    @DisplayName("AppointmentService#editAppointment test")
    public void testEditAppointment() {}

    @Test
    @DisplayName("AppointmentService#appointmentsCancel test")
    public void testAppointmentsCancel() {}
}
