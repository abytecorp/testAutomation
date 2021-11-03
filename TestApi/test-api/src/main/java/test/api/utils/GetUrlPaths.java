package test.api.utils;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class GetUrlPaths implements Question<String> {
    private final String propertyKey;

    public GetUrlPaths(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    @SneakyThrows
    @Override
    @Step ("{0} solicita cuerpos del sistema solar al endpoint")
    public String answeredBy(Actor actor) {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        return environmentVariables.getProperty(propertyKey);
    }

    public static GetUrlPaths byProperty(String propertyKey) {
        return new GetUrlPaths(propertyKey);
    }
}