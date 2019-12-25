/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sick.games.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Adri
 * @version 1.0 Classe principal de configuració Hibernate que té com a objectiu
 * connectar-nos amb la base de dades del nostre servidor.
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:jdbc.properties", "classpath:hibernate.properties"})
public class HibernateMySQLConfiguration {

    @Autowired
    private Environment environment;

    /**
     * Afegim els drivers de JDBC i credencials de la base de dades per tal de
     * que Spring pugui connectar-se amb la BBDD.
     *
     * @return dataSource
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    /**
     * Establir el dataSource a l'objecte sessionFactory a més d'indicar-li
     * quina carpeta contindrà les Taules Entitats i la configuració d'Hibernate
     *
     * @param dataSource
     * @return sessionFactory necessàri per a les consultes.
     */
    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.sick.games.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    /**
     * Establir les propietats d'Hibernate mitjançant el fitxer
     * /src/main/resources/jdbc.properties
     *
     * @return les propietats d'hibernate
     */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl"));
        return properties;
    }

    /**
     * Crea un objecte HibernateTransactionManager i estableix la configuració
     * feta en aquesta classe del SessionFactory.
     *
     * @param session
     * @return HibernateTransactionManeger amb el sessionFactory de la nostra
     * configuració
     */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory session) {
        HibernateTransactionManager tsManager = new HibernateTransactionManager();
        tsManager.setSessionFactory(session);
        return tsManager;
    }
}
