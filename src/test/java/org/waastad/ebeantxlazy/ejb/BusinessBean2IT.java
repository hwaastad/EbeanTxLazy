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
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.junit.ApplicationComposerRule;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.apache.openejb.testng.PropertiesBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.waastad.dbunit.liquibase.rules.cdi.DataSet;
import org.waastad.dbunit.liquibase.rules.cdi.DbInstance;
import org.waastad.dbunit.liquibase.rules.rule.LiquibaseEnvironment;
import org.waastad.ebeantxlazy.domain.Customer;

/**
 *
 * @author helge
 */
@Slf4j
public class BusinessBean2IT {

    public BusinessBean2IT() {
    }
    
    @DbInstance
    @Resource(name = "DS")
    private DataSource dataSource;

    @Rule
    public TestRule theRule = RuleChain.outerRule(new ApplicationComposerRule(this)).around(new LiquibaseEnvironment().resourcesHolder(this));

    @Module
    @Classes(value = {EbeanInitializer.class, BusinessBean.class}, cdi = true)
    public WebApp jar() {
        return new WebApp().contextRoot("");
    }

    @Configuration
    public Properties configuration() {
        return new PropertiesBuilder()
                .p("DS", "new://Resource?type=DataSource")
                .p("DS.JdbcUrl", "jdbc:hsqldb:mem:test")
                .p("DS.LogSql", "false")
                .p("DS.jtaManaged", "false")
                .p("openejb.log.factory","slf4j")
                .build();
    }

    @Inject
    private BusinessBean businessBean;

    @Test
    @DataSet("changelog-nodata.xml")
    public void testSomeMethod() {
        businessBean.createWithAll("xxx");
        businessBean.createWithAll("yyy");
        businessBean.deletePet("xxx");
    }

}
