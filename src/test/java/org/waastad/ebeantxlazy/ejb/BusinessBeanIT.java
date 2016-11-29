/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.ejb;

import com.avaje.ebean.config.PersistBatch;
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
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.waastad.dbunit.liquibase.rules.cdi.DataSet;
import org.waastad.dbunit.liquibase.rules.cdi.DbInstance;
import org.waastad.dbunit.liquibase.rules.rule.LiquibaseEnvironment;
import org.waastad.ebeantxlazy.domain.Customer;
import org.waastad.ebeantxlazy.domain.Person;
import org.waastad.ebeantxlazy.domain.PersonGroup;
import org.waastad.ebeantxlazy.domain.PetAttribute;

/**
 *
 * @author helge
 */
@Slf4j
public class BusinessBeanIT {

    public BusinessBeanIT() {
    }

    @DbInstance
    @Resource(name = "DS")
    private DataSource dataSource;

    @Rule
    public TestRule theRule = RuleChain.outerRule(new ApplicationComposerRule(this)).around(new LiquibaseEnvironment().resourcesHolder(this));

    @Module
    @Classes(value = {EbeanInitializer.class, BusinessBean.class}, cdi = true)
    public EjbJar jar() {
        return new EjbJar();
    }

    @Configuration
    public Properties configuration() {
        return new PropertiesBuilder()
//                .p("DS", "new://Resource?type=DataSource")
//                .p("DS.JdbcUrl", "jdbc:hsqldb:mem:test")
                .p("DS", "new://Resource?type=DataSource")
                .p("DS.JdbcDriver","org.postgresql.Driver")
                .p("DS.username","helge")
                .p("DS.JdbcUrl", "jdbc:postgresql://localhost/whatever?stringtype=unspecified")
                .p("DS.LogSql", "false")
                .p("DS.jtaManaged", "false")
                .p("openejb.logfactory", "slf4j")
                .build();
    }

    @Inject
    private BusinessBean businessBean;

    @Test
    @DataSet(value = "changelog-data.xml")
    public void testSomeMethod() {
        try {
            List<PersonGroup> all = PersonGroup.find.all();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @DataSet(value = "changelog-data.xml")
    public void testSomeMethod2() {
        int size = PetAttribute.find.all().size();
        List<Person> all = Person.find.all();
        try {
            businessBean.deleteUsersStep("p-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int sizeNew = PetAttribute.find.all().size();
        Assert.assertNotEquals(size,sizeNew);
    }

}
