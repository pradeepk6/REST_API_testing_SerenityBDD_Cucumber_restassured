package net.serenitybdd.restcountries.features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {""},
        features={"src/test/resources/features/fullname/fullname.feature",
                  "src/test/resources/features/regionalbloc/regionalbloc.feature"}
                  )
public class RetrieveByFullName {
}
