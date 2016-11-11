/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.ejb;

import java.util.List;
import java.util.Properties;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.junit.ApplicationComposerRule;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testng.PropertiesBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.waastad.dbunit.liquibase.rules.cdi.DataSet;
import org.waastad.dbunit.liquibase.rules.cdi.DbInstance;
import org.waastad.dbunit.liquibase.rules.rule.LiquibaseEnvironment;
import org.waastad.ebeantxlazy.domain.Customer;

/**
 *
 * @author helge
 */
@Slf4j
public class BusinessBeanJtaIT {

    public BusinessBeanJtaIT() {
    }

    @DbInstance
    @Resource(name = "DS")
    private DataSource dataSource;

    @Rule
    public TestRule theRule = RuleChain.outerRule(new ApplicationComposerRule(this)).around(new LiquibaseEnvironment().resourcesHolder(this));

    @Module
    @Classes(value = {EbeanInitializerJta.class, BusinessBean.class}, cdi = true)
    public EjbJar jar() {
        return new EjbJar();
    }

    @Configuration
    public Properties configuration() {
        return new PropertiesBuilder()
                .p("DS", "new://Resource?type=DataSource")
                .p("DS.JdbcUrl", "jdbc:hsqldb:mem:test")
                .p("DS.LogSql", "false")
                .p("DS.jtaManaged", "true")
                .p("openejb.LogFactory","slf4j")
                .build();
    }

    @Inject
    private BusinessBean businessBean;

    @Test
    @DataSet(value = "changelog.xml")
    public void testSomeMethod() {
        List<Customer> findAll = businessBean.findAll();
        findAll.forEach(cnsmr -> {
            log.info("Customer: {}", cnsmr.getName());
            cnsmr.getPersons().forEach(p -> {
                log.info("Person: {}", p.getName());
                p.getPets().forEach(pet -> {
                    log.info("Pet: {}", pet.getName());
                });
            });
        });
    }

}
