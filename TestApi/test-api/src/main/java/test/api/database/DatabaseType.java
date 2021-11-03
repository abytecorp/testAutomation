package test.api.database;

public enum DatabaseType {
    MYSQL("org.hibernate.dialect.MySQL57Dialect");

    private final String dialect;

    public String getDialect() {
        return dialect;
    }

    DatabaseType(String dialect) {
        this.dialect = dialect;
    }
}
