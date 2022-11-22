package dmit2015.config;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/datasources/h2databaseDS",
        callerQuery = "SELECT password FROM CallerUser WHERE username = ?",
        groupsQuery = "SELECT groupname FROM CallerGroup WHERE username = ?",
        priority = 5
)

@DataSourceDefinitions({
    @DataSourceDefinition(
            name="java:app/datasources/h2databaseDS",
            className="org.h2.jdbcx.JdbcDataSource",
//            url="jdbc:h2:file:~/databases/dmit2015-microservices-demodb",
            url="jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
            user="sa",
            password="sa"),
})

@FacesConfig
@ApplicationScoped
public class ApplicationConfig {
}

