package test.api.database.persistence.manager;

import test.api.database.DatabaseConnectionInfo;
import test.api.database.DatabaseType;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class JpaEntityManagerFactory {
    private final DatabaseType databaseType;
    private final String url;
    private final String username;
    private final String password;
    private final List<String> entityNames;

    public JpaEntityManagerFactory(DatabaseConnectionInfo connectionInfo) {
        this.databaseType = connectionInfo.getDatabaseType();
        this.url = connectionInfo.getUrl();
        this.username = connectionInfo.getUsername();
        this.password = connectionInfo.getPassword();
        this.entityNames = connectionInfo.getEntityNames();
    }

    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        PersistenceUnitInfo persistenceUnitInfo = new HibernatePersistenceUnitInfo(
                getClass().getSimpleName(), getEntityClassNames(), getProperties());

        return new EntityManagerFactoryBuilderImpl(
                new PersistenceUnitInfoDescriptor(persistenceUnitInfo), new HashMap<>()).build();
    }

    protected List<String> getEntityClassNames() {
        return entityNames;
    }

    protected Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", this.databaseType.getDialect());
        properties.put("hibernate.id.new_generator_mappings", false);
        properties.put("hibernate.connection.url", url);
        properties.put("hibernate.connection.username", username);
        properties.put("hibernate.connection.password", password);

        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");



        return properties;
    }
}
