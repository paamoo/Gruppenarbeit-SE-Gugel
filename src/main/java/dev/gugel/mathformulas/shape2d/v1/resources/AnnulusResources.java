package dev.gugel.mathformulas.shape2d.v1.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.gugel.mathformulas.shape2d.common.Shape2Dcalc;
import dev.gugel.mathformulas.shape2d.common.Shape2DinputValidation;
import dev.gugel.mathformulas.shape2d.common.Shape2Dresources;
import dev.gugel.mathformulas.shape2d.v1.calc.AnnulusCalc;
import dev.gugel.mathformulas.shape2d.v1.input.AnnulusInput;
import dev.gugel.mathformulas.shape2d.v1.input.validation.AnnulusInputValidation;
import dev.gugel.mathformulas.shape2d.v1.output.Shape2Doutput;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path( "/v1" )
public class AnnulusResources implements Shape2Dresources<AnnulusInput, Shape2Doutput>{

    @RolesAllowed( "restUser" )
    @Path( "/annulus" )
    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Override
    public Shape2Doutput getAllValues(AnnulusInput inputSI )
    {
        Shape2DinputValidation annulusInputValidation = new AnnulusInputValidation( inputSI );
        annulusInputValidation.validateInputAllValues();
        if( annulusInputValidation.isValid() ) {
            Shape2Dcalc annulusCalc = new AnnulusCalc( inputSI );
            return annulusCalc.calculateAllValues();
        } else {
            return new Shape2Doutput(null,null, annulusInputValidation.getMessageOutputList() );
        }
    }

    @RolesAllowed( "restUser" )
    @Path( "/annulus/area" )
    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Override
    public Shape2Doutput getArea(AnnulusInput inputSI )
    {
        Shape2DinputValidation annulusInputValidation = new AnnulusInputValidation( inputSI );
        annulusInputValidation.validateInputArea();
        if( annulusInputValidation.isValid() ) {
            Shape2Dcalc annulusCalc = new AnnulusCalc( inputSI );
            return annulusCalc.calculateArea();
        } else {
            return new Shape2Doutput(null,null, annulusInputValidation.getMessageOutputList() );
        }
    }

    @RolesAllowed( "restUser" )
    @Path( "/annulus/perimeter" )
    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Override
    public Shape2Doutput getPerimeter(AnnulusInput inputSI )
    {
        Shape2DinputValidation annulusInputValidation = new AnnulusInputValidation( inputSI );
        annulusInputValidation.validateInputPerimeter();
        if( annulusInputValidation.isValid() ) {
            Shape2Dcalc annulusCalc = new AnnulusCalc( inputSI );
            return annulusCalc.calculatePerimeter();
        } else {
            return new Shape2Doutput(null,null, annulusInputValidation.getMessageOutputList() );
        }
    }

    @RolesAllowed( "restUser" )
    @Path( "/annulus/doc" )
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Override
    public String getDocumentation()
    {
        AnnulusInput annulusInput = getInputDummy();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson( annulusInput );

        return """
                ########################
                Annulus Input
                ########################

                REST
                'Content-Type: application/json'
                'Basic: cmVzdFVzZXI6Y2hhbmdlaXQ='
                
                ########################

                Input parameters as SI units:

                <description>   <formula symbol> : <unit>   (<abbreviation>)   as <data type>

                Radius a          a                : metre    (m)                as Double
                Radius b          b                : metre    (m)                as Double

                ########################

                Input JSON Objekt:

                """ + jsonString;
    }

    @Override
    public AnnulusInput getInputDummy()
    {
        return new AnnulusInput( 10.0, 5.0 );
    }
}
