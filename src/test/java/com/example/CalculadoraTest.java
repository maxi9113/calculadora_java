package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calc = new Calculadora();

    @ParameterizedTest(name = "sumaRecursiva({0}) = {1}")
    @CsvSource({
        "0, 0",
        "1, 1",
        "2, 3",
        "3, 6",
        "5, 15",
        "10, 55",
        "20, 210",
        "7, 28"
    })
    @DisplayName("Pruebas parametrizadas de sumaRecursiva con @CsvSource")
    void testSumaRecursivaCsvSource(int input, int expected) {
        assertEquals(expected, calc.sumaRecursiva(input));
    }


    @Test
    @DisplayName("Prueba para un caso grande")
    void testSumaRecursivaConValorGrande() {
        assertEquals(465, calc.sumaRecursiva(30));
    }

    @Test
    @DisplayName("Prueba de excepción para un valor negativo")
    void testSumaRecursivaConValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> calc.sumaRecursiva(-1));
    }

    @Test
    @DisplayName("Prueba para un valor positivo adicional (4)")
    void testSumaRecursivaConValorCuatro() {
        assertEquals(10, calc.sumaRecursiva(4));
    }

    @Test
    @DisplayName("Prueba para un valor positivo adicional (9)")
    void testSumaRecursivaConValorNueve() {
        assertEquals(45, calc.sumaRecursiva(9));
    }
    
    @Test
    @DisplayName("Prueba de excepción para otro valor negativo")
    void testSumaRecursivaConOtroValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> calc.sumaRecursiva(-100));
    }
}