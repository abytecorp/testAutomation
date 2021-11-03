package test.api.interactions.Login;

import net.serenitybdd.screenplay.Performable;
import test.api.interactions.PostLbApi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import test.api.dtos.Login.SendLoginDTO;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostSendLogin implements Task {
    private static final String STORE_AUTH = "/auths/vivo-login";
    private final SendLoginDTO loginInfo;

    public PostSendLogin(SendLoginDTO loginInfo) {
        this.loginInfo = loginInfo;
    }

    @Override
    @Step("{0} requests a login")
    public void performAs(Actor actor){
        actor.attemptsTo(
                PostLbApi.withBody(loginInfo, STORE_AUTH)
        );
    }

    public static Performable withInfo(SendLoginDTO loginInfo) { return instrumented(PostSendLogin.class, loginInfo); }
}
