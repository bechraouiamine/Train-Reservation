package com.arolla.train.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingRefServiceTest {

    @Test
    void should_return_7_character_string() {
        // Given
        BookingRefService bookingRefService = new BookingRefService();

        // When
        String generatedRef = bookingRefService.generateRef();

        // Then
        assertEquals(7, generatedRef.length());
    }

    @Test
    void should_return_different_string() {
        // Given
        BookingRefService bookingRefService = new BookingRefService();

        // When
        String firstGeneratedRef = bookingRefService.generateRef();
        String secondGeneratedRef = bookingRefService.generateRef();

        // Then
        assertNotEquals(firstGeneratedRef, secondGeneratedRef);
    }
}