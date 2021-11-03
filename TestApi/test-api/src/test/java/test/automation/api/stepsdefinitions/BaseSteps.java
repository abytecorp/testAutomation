package test.automation.api.stepsdefinitions;
import io.cucumber.java.en.Given;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BaseSteps {
    @Given("^(.*) is a Test User$")

    public void defineActorName(String name) {
        theActorCalled(name);
    }
}
