package test.api.abilities;

import test.api.database.DatabaseConnectionInfo;
import test.api.database.persistence.manager.JpaEntityManagerFactory;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import javax.persistence.EntityManager;

public class InteractWithDb implements Ability {

    private final EntityManager entityManager;

    public EntityManager getManager() {
        return entityManager;
    }

    public InteractWithDb(DatabaseConnectionInfo databaseConnectionInfo) {
        this.entityManager =
                new JpaEntityManagerFactory(databaseConnectionInfo).getEntityManager();
    }

    public static InteractWithDb using(DatabaseConnectionInfo databaseConnectionInfo) {
        return new InteractWithDb(databaseConnectionInfo);
    }

    public static InteractWithDb as(Actor actor) {
        return actor.abilityTo(InteractWithDb.class);
    }
}