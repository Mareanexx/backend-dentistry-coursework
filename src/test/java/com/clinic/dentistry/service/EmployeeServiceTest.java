package com.clinic.dentistry.service;

import com.clinic.dentistry.dto.ApiResponse;
import com.clinic.dentistry.dto.EmployeeDto;
import com.clinic.dentistry.models.Employee;
import com.clinic.dentistry.repo.EmployeeRepository;
import com.clinic.dentistry.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("EmployeeService#getEmployeeList test")
    public void testGetEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        when(employeeRepository.findAll()).thenReturn(employees);

        assertEquals(employees, employeeService.findAllEmployees());
    }

    @Test
    @DisplayName("EmployeeService#getEmployeeByID test")
    public void testGetEmployeeById() {
        // Arrange
        Long employeeID = 1L;
        Employee employee = new Employee();
        when(employeeRepository.findEmployeeById(employeeID)).thenReturn(employee);

        // Act
        HashMap<String, Object> model = employeeService.getEmpl(1L);
        Employee employeeExpected = (Employee) model.get("employee");

        // Assert
        assertEquals(employeeExpected, employee);
    }

    @Test
    @DisplayName("EmployeeService#Failed_to_getEmployeeByID test")
    public void testFailedToGetEmployeeById() {
        // Arrange
        Long employeeId = 1L;
        when(employeeRepository.findEmployeeById(employeeId)).thenReturn(null);

        // Act & Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            employeeService.getEmpl(employeeId);
        });
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
    }

    @Test
    @DisplayName("EmployeeService#saveEmployee test")
    public void testSaveEmployee() {
        // Arrange
        EmployeeDto dto = new EmployeeDto("test", "test", null, null, null, 10);

        ApiResponse expectedResponse = ApiResponse.builder()
                .status(HttpStatus.CREATED)
                .message("Сотрудник успешно создан!")
                .build();

        // Act
        ApiResponse response = employeeService.saveEmployee(dto);

        // Assert
        assertEquals(expectedResponse.getStatus(), response.getStatus());
    }

    @Test
    @DisplayName("EmployeeService#editEmployee test")
    public void testEditEmployee() {
        // Arrange
        Long employeeId = 1L;
        EmployeeDto dto = new EmployeeDto();
        dto.setFullName("test");

        Employee existingEmployee = new Employee();
        existingEmployee.setId(employeeId);
        existingEmployee.setFullName("test new");

        when(employeeRepository.findEmployeeById(employeeId)).thenReturn(existingEmployee);

        ApiResponse expectedResponse = ApiResponse.builder()
                .status(HttpStatus.OK)
                .message("Данные о сотруднике успешно обновлены!")
                .build();

        ApiResponse response = employeeService.editEmployee(employeeId, dto);

        assertEquals(expectedResponse.getMessage(), response.getMessage());
        assertEquals(dto.getFullName(), existingEmployee.getFullName());
    }


    @Test
    @DisplayName("EmployeeService#editEmployeeButNotFound test")
    public void testEditEmployeeButNotFound() {
        // Arrange
        Long employeeId = 1L;
        EmployeeDto dto = new EmployeeDto();
        dto.setFullName("test");

        when(employeeRepository.findEmployeeById(employeeId)).thenReturn(null);

        ApiResponse expectedResponse = ApiResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Не найден сотрудник с ID " + employeeId)
                .build();

        // Act
        ApiResponse response = employeeService.editEmployee(employeeId, dto);

        // Assert
        assertEquals(expectedResponse.getMessage(), response.getMessage());
    }
}

