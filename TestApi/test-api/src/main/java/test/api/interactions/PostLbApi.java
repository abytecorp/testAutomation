package test.api.interactions;

import test.api.utils.GetUrlPaths;
import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostLbApi implements Interaction {
    protected static final String LBAPI_API_BASE_URL = theActorInTheSpotlight().asksFor(GetUrlPaths.byProperty("env.staging.api.base.url.lbapi.api"));
    private final Object body;
    private final String urlPath;

    public PostLbApi(Object body, String urlPath) {
        this.body = body;
        this.urlPath = urlPath;
    }

    @Override
    @SneakyThrows
    @Step("{0} does a request to #LBAPI_API_BASE_URL#urlPath")
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(LBAPI_API_BASE_URL));
        actor.attemptsTo(
                Post.to(urlPath)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(body))
        );
    }

    public static PostLbApi withBody(Object body, String urlPath) {
        return instrumented(PostLbApi.class, body, urlPath);
    }
}
