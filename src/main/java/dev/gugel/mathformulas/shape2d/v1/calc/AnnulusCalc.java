package dev.gugel.mathformulas.shape2d.v1.calc;

import dev.gugel.mathformulas.common.Formulas;
import dev.gugel.mathformulas.shape2d.common.Shape2Dcalc;
import dev.gugel.mathformulas.shape2d.v1.input.AnnulusInput;
import dev.gugel.mathformulas.shape2d.v1.output.Shape2Doutput;

public class AnnulusCalc implements Shape2Dcalc {

    private final AnnulusInput annulusInput;

    public AnnulusCalc(AnnulusInput annulusInput ) {
        this.annulusInput = annulusInput;
    }

    private AnnulusInput getAnnulusInput() {
        return annulusInput;
    }

    @Override
    public Shape2Doutput calculateAllValues() {
        return new Shape2Doutput( calculateArea().area(), calculatePerimeter().perimeter(), null );
    }

    @Override
    public Shape2Doutput calculateArea() {
        return new Shape2Doutput( Formulas.calculateAnnulusArea( getAnnulusInput().a(),
                getAnnulusInput().b() ),null,null );
    }

    @Override
    public Shape2Doutput calculatePerimeter() {
        return new Shape2Doutput(null, Formulas.calculateAnnulusPerimeter( getAnnulusInput().a(),
                getAnnulusInput().b() ),null );
    }
}
