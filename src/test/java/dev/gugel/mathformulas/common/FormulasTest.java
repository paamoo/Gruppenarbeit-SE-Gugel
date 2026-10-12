package dev.gugel.mathformulas.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulasTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateRectangleArea() {
        assertEquals( 12.0, Formulas.calculateRectangleArea( 3.0, 4.0 ) );
    }

    @Test
    void calculateRectangleAreaFailed() {
        assertAll(
                () -> assertNull( Formulas.calculateRectangleArea( null, 4.0) ),
                () -> assertNull( Formulas.calculateRectangleArea( 3.0, null) )
        );
    }

    @Test
    void calculateRectanglePerimeter() {
        assertEquals( 14.0, Formulas.calculateRectanglePerimeter( 3.0, 4.0 ) );
    }

    @Test
    void calculateRectanglePerimeterFailed() {
        assertAll(
                () -> assertNull( Formulas.calculateRectanglePerimeter( null, 4.0 ) ),
                () -> assertNull( Formulas.calculateRectanglePerimeter( 3.0, null ) )
        );
    }

    @Test
    void calculateAnnulusArea() {
        assertEquals( 21.991148575128552, Formulas.calculateAnnulusArea( 3.0, 4.0 ) );
    }

    @Test
    void calculateAnnulusAreaFailed() {
        assertAll(
                () -> assertNull( Formulas.calculateAnnulusArea( null, 4.0) ),
                () -> assertNull( Formulas.calculateAnnulusArea( 3.0, null) )
        );
    }

    @Test
    void calculateAnnulusPerimeter() {
        assertEquals( 43.982297150257104, Formulas.calculateAnnulusPerimeter( 3.0, 4.0 ) );
    }

    @Test
    void calculateAnnulusPerimeterFailed() {
        assertAll(
                () -> assertNull( Formulas.calculateAnnulusPerimeter( null, 4.0 ) ),
                () -> assertNull( Formulas.calculateAnnulusPerimeter( 3.0, null ) )
        );
    }
}