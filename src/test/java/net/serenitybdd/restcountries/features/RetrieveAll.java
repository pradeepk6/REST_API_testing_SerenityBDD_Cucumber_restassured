package net.serenitybdd.restcountries.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {"~@wip"},
        features={"src/test/resources/features/all/all_country_names.feature"}
        )
public class RetrieveAll {
}
