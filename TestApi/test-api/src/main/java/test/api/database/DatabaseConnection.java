package test.api.database;

import test.api.abilities.InteractWithDb;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DatabaseConnection {

    public static void connect() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        String mySQLUser = "qa";
        String mySQLServer = "jdbc:mysql://staging2.cyj8phdymyxq.us-east-2.rds.amazonaws.com";
        String mySQLPassword = "dfd809fSDF54d";
        String mySQLDatabase = "chiper";

        DatabaseConnectionInfo connectionInfo = DatabaseConnectionInfo
                .builder()
                .username(mySQLUser)
                .databaseType(DatabaseType.MYSQL)
                .url(String.format("%s/%s", mySQLServer, mySQLDatabase))
                .password(mySQLPassword)
                .build();

        theActorInTheSpotlight().can(InteractWithDb.using(connectionInfo));
        EntityManager entityManager = InteractWithDb.as(theActorInTheSpotlight()).getManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        theActorInTheSpotlight().remember("EntityManager", entityManager);
        theActorInTheSpotlight().remember("CriteriaBuilder", criteriaBuilder);
    }
}

