package net.serenitybdd.restcountries.features.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.when;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GetAllCountryNamesSteps {

    private List<String> expectedCountryNamesList;

    @Before
    public void setUp() throws IOException{
        //test data setup
        expectedCountryNamesList = Files.readAllLines(
                Paths.get("src/test/resources/testdata/CountryNames.txt"));
    }

    @When("^a user retrieves all country names$")
    public void a_user_retrieves_all_country_names() throws Exception {
        //gets only country names because of the filter : field=name
        when().get("https://restcountries.eu/rest/v2/all?fields=name");
    }

    @Then("^names and total number of countries should match$")
    public void names_and_total_number_of_countries_should_match() throws Exception {
        then().
        statusCode(200).
        contentType(JSON).
        body("name", allOf(hasSize(250), containsInAnyOrder(expectedCountryNamesList.toArray())));

    }
}
