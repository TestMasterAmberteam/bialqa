import io.restassured.config.LogConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.config.LogConfig.logConfig;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@DisplayName("Testy training-controller")
public class TrainingTest {

    final static String API_VERSION = "/v1";

    @BeforeEach
    void setup() {

        baseURI = "http://localhost";
        port = 9999;
        basePath = "/api/rest" + API_VERSION;
    }

    @Test
    @DisplayName("Sprawdź czy pobierane są szkolenia")
    void getAllTrainings() {
        given()
                .when().get("/trainings/all")
                .then().statusCode(200).body("id", notNullValue());
    }

    @Test
    @DisplayName("Sprawdź czy tworzysię nowe szkolenie")
    void addTraining() {


        TrainingModel payloadPojo = new TrainingModel().setMaxParticipants(55).setName("RestAssuredPOJO").setPlace("BiałQA").setPrice(0).setTrainer("Gumiś");
        String trainingId = given().config(config().logConfig(logConfig().blacklistHeader("Content-Type")))
                .header("Content-type", "application/json")
                .log().headers()
                .body(payloadPojo)
                .log().body()
                .post("/training")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo(payloadPojo.getName()))
                .extract().response().jsonPath().get("id").toString();

        given()
                .when()
                .pathParam("id", trainingId)
                .get("/training/{id}")

                .then()
                .body("name", equalTo(payloadPojo.getName()))
                .log().all()
                .statusCode(200);

    }
}
