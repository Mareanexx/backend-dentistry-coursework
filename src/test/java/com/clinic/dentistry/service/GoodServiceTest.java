package com.clinic.dentistry.service;

import com.clinic.dentistry.dto.ApiResponse;
import com.clinic.dentistry.models.Good;
import com.clinic.dentistry.repo.GoodRepository;
import com.clinic.dentistry.service.impl.GoodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GoodServiceTest {

    @InjectMocks
    private GoodServiceImpl goodService;

    @Mock
    private GoodRepository goodRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("GoodService#getGoodList test")
    void testGetGoodList() {
        when(goodRepository.findAllByActiveTrueOrActiveFalseOrderById()).thenReturn(Arrays.asList(new Good(1L, true, "test", 10), new Good(2L, true, "test2", 10000)));

        HashMap<String, Object> model = goodService.getGoodList();

        assertEquals(2, ((Iterable) model.get("goods")).spliterator().getExactSizeIfKnown());
    }

    @Test
    @DisplayName("GoodService#getGoodByID test")
    void testGoodGet() {
        Long goodId = 1L;
        Good mockGood = new Good();
        when(goodRepository.findGoodById(goodId)).thenReturn(mockGood);

        HashMap<String, Object> model = goodService.goodGet(goodId);

        assertEquals(mockGood, model.get("good"));
    }

    @Test
    @DisplayName("GoodService#goodSave test")
    void testGoodSave() {
        Good good = new Good();
        when(goodRepository.save(any(Good.class))).thenReturn(good);

        ApiResponse response = goodService.goodSave(good);

        verify(goodRepository, Mockito.times(1)).save(any(Good.class));
        assertEquals(HttpStatus.CREATED, response.getStatus());
    }

    @Test
    @DisplayName("GoodService#getGoodEdit test")
    void testGoodEdit() {
        Long goodId = 1L;
        Good existingGood = new Good();
        Good newGoodData = new Good();
        when(goodRepository.findById(goodId)).thenReturn(Optional.of(existingGood));

        ApiResponse response = goodService.goodEdit(goodId, newGoodData);

        verify(goodRepository, Mockito.times(1)).save(existingGood);
        assertEquals(HttpStatus.OK, response.getStatus());
    }
}

