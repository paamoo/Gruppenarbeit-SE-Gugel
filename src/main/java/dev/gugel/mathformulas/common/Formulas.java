package dev.gugel.mathformulas.common;


public final class Formulas {

    private Formulas() {
        // This class should not be instantiated
    }

    // --- Rectangle ---
    /**
     *
     * @param a length
     * @param b width
     * @return area of a rectangle
     */
    public static Double calculateRectangleArea( Double a, Double b ) {
        if( a == null ) return null;
        if( b == null ) return null;

        return a * b;
    }

    /**
     *
     * @param a length
     * @param b width
     * @return perimeter of a rectangle
     */
    public static Double calculateRectanglePerimeter( Double a, Double b ) {
        if( a == null ) return null;
        if( b == null ) return null;

        return 2 * a + 2 * b;
    }

    // --- annulus ---
    /**
     *
     * @param a radiusA
     * @param b radiusB
     * @return area of an annulus
     */
    public static Double calculateAnnulusArea( Double a, Double b ) {
        if( a == null ) return null;
        if( b == null ) return null;
        if ( a > b ) {
            return Math.PI * ((a*a) - (b*b));
        }
        else {
            return Math.PI * ((b*b) - (a*a));
        }
    }

    /**
     *
     * @param a radiusA
     * @param b radiusB
     * @return perimeter of an annulus
     */
    public static Double calculateAnnulusPerimeter( Double a, Double b ) {
        if( a == null ) return null;
        if( b == null ) return null;

        return 2 * Math.PI * a + 2 * Math.PI * b;
    }
}
