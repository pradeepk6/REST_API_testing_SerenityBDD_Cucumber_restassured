package net.serenitybdd.restcountries.features.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;

public class GetCountryByFullNameSteps {

    private JsonNode multipleCountryDetails_jsonNode;
    private String countryName;

    @Before
    public void setUp() throws IOException {
        //test data setup
        String content = new String(
                Files.readAllBytes(Paths.get("src/test/resources/testdata/MultipleCountryDetails.json")));
        ObjectMapper mapper = new ObjectMapper();
        multipleCountryDetails_jsonNode =  mapper.readTree(content);
    }

    @When("^a user retrieves a (.*) by fullname$")
    public void a_user_retrieves_by_fullname(String name) {
        countryName = name;
        when().get("https://restcountries.eu/rest/v2/name/{name}?fullText=true",name);
    }

    @Then("^all details of that country should match$")
    public void all_details_of_that_country_should_match() {
        then().
                statusCode(200).
                contentType(JSON).
                extract().body().as(JsonNode.class).
                equals(multipleCountryDetails_jsonNode.get(countryName));
    }
}
