package test.automation.api.support;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ActorStarted {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}