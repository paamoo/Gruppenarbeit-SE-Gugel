package dev.gugel.mathformulas.shape2d.v1.resources;

import dev.gugel.mathformulas.shape2d.v1.input.AnnulusInput;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
class AnnulusResourcesTest {

    private AnnulusInput annulusInput;

    private final String user = "restUser";
    private final String pw = "changeit";

    private final String urlAllValues = "/v1/annulus";

    private final String urlDoc = "/v1/annulus/doc";

    private final String urlArea = "/v1/annulus/area";
    private final String outputKeyArea = "area";

    private final String urlPerimeter = "/v1/annulus/perimeter";
    private final String outputKeyPerimeter = "perimeter";

    @BeforeEach
    void setUp() {
        annulusInput = new AnnulusInput( 10.0, 5.0 );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllValuesUnauthorized() {
        given()
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlAllValues ).then()
                .statusCode( 401 );
    }

    @Test
    void getAllValues() {
        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlAllValues ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( 235.61944901923448f ) )
                .body( outputKeyPerimeter, equalTo( 94.24777960769379f ) );
    }

    @Test
    void getAllValuesFailedByNull() {
        annulusInput = new AnnulusInput( null, 5.0 );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlAllValues ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( null ) )
                .body( outputKeyPerimeter, equalTo( null ) );
    }

    @Test
    void getAllValuesFailedByNegative() {
        annulusInput = new AnnulusInput( 10.0, -5.0 );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlAllValues ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( null ) )
                .body( outputKeyPerimeter, equalTo( null ) );
    }

    @Test
    void getArea() {
        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlArea ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( 235.61945f ) );
    }

    @Test
    void getAreaFailedByNull() {
        annulusInput = new AnnulusInput( null, 5.0 );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlArea ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( null ) );
    }

    @Test
    void getPerimeter() {
        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlPerimeter ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyPerimeter, equalTo( 94.24778f ) );
    }

    @Test
    void getPerimeterFailedByNull() {
        annulusInput = new AnnulusInput( 10.0, -5.0 );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body(annulusInput)
                .when().post( urlPerimeter ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyPerimeter, equalTo( null ) );
    }

    @Test
    void getDocumentation() {
        given().auth().basic( user, pw )
                .when().get( urlDoc ).then()
                .statusCode( 200 )
                .contentType( ContentType.TEXT );
    }
}