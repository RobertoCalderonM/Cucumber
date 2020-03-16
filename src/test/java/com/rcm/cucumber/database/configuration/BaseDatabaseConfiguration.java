package com.rcm.cucumber.database.configuration;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration @Lazy
@PropertySource({"classpath:database.properties"})
@EnableJpaRepositories(
        basePackages = "com.rcm.cucumber.database.base.repositories",
        entityManagerFactoryRef = "baseEntityManager",
        transactionManagerRef = "baseTransactionManager")

public class BaseDatabaseConfiguration {

    @Primary
    @Bean(name = "baseDataSource")
    @ConfigurationProperties(prefix = "spring.base")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "baseEntityManager")
    public LocalContainerEntityManagerFactoryBean baseEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("baseDataSource") DataSource dataSource
    ) {
            return builder
                    .dataSource(dataSource)
                    .packages("com.rcm.cucumber.database.base.models")
                    .build();
    }

    @Primary
    @Bean(name = "baseTransactionManager")
    public PlatformTransactionManager baseTransactionManager(
            @Qualifier("baseEntityManager") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
