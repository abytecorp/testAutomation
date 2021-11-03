package test.automation.api.support;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty"},
        snippets = CAMELCASE,
        glue = {"/test/automation/api/stepsdefinitions", "test/automation/api/support"},
        tags = "not @TODO"
)

public class TestRunner {
}
