package com.clinic.dentistry.service;

import com.clinic.dentistry.repo.AppointmentRepository;
import com.clinic.dentistry.repo.CheckLineRepository;
import com.clinic.dentistry.repo.CheckRepository;
import com.clinic.dentistry.repo.GoodRepository;
import com.clinic.dentistry.service.impl.CheckServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckServiceTest {
    @Mock
    private GoodRepository goodRepository;
    @Mock
    private CheckRepository checkRepository;
    @Mock
    private CheckLineRepository checkLineRepository;
    @Mock
    private AppointmentRepository appointmentRepository;
    @InjectMocks
    private CheckServiceImpl checkService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("CheckService#createCheckFromForm test")
    public void testCreateCheckFromForm() {}

    @Test
    @DisplayName("CheckService#addConclusion test")
    public void testAddConclusion() {}

    @Test
    @DisplayName("CheckService#findCheck test")
    public void testFindCheck() {}

    @Test
    @DisplayName("CheckService#findCheckLines test")
    public void testFindCheckLines() {}
}
