package dev.gugel.mathformulas.shape2d.v1.input.validation;

import dev.gugel.mathformulas.shape2d.common.Shape2DinputValidation;
import dev.gugel.mathformulas.shape2d.v1.input.AnnulusInput;

public class AnnulusInputValidation extends Shape2DinputValidation {

    private final AnnulusInput annulusInput;

    public AnnulusInputValidation( AnnulusInput annulusInput ) {
        super();
        this.annulusInput = annulusInput;
    }

    public AnnulusInput getAnnulusInput() {
        return annulusInput;
    }

    @Override
    public void validateInputArea() {
        validateValueNotNullOrNegative( getAnnulusInput().a(),AnnulusInput.class.getSimpleName() + ".a" );
        validateValueNotNullOrNegative( getAnnulusInput().b(),AnnulusInput.class.getSimpleName() + ".b" );
    }

    @Override
    public void validateInputPerimeter() {
        validateValueNotNullOrNegative( getAnnulusInput().a(),AnnulusInput.class.getSimpleName() + ".a" );
        validateValueNotNullOrNegative( getAnnulusInput().b(),AnnulusInput.class.getSimpleName() + ".b" );
    }
}

