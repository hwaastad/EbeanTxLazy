/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.ejb;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.HsqldbPlatform;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.waastad.ebeantxlazy.domain.Customer;
//import no.datametrix.daxauthentication.domain.User;
//import no.datametrix.daxauthentication.producer.UserProvider;

/**
 *
 * @author helge
 */
@Singleton
@Startup
@Slf4j
public class EbeanInitializer {

    @Resource(name = "DS")
    private DataSource ds;

    private EbeanServer ebeanServer;

    @PostConstruct
    public void construct() {
        log.info("Initializing eBean Server....");
        ServerConfig config = new ServerConfig();
        config.loadFromProperties();
        config.setDataSource(ds);
        config.setName("ebeanServer");
        config.setUseJtaTransactionManager(false);
        config.setAutoCommitMode(false);
        config.setDatabasePlatform(new HsqldbPlatform());
        config.setRegister(true);
        config.setDefaultServer(true);
        config.addPackage(Customer.class.getPackage().getName());
        
//        config.setDdlGenerate(true);
//        config.setDdlRun(true);
        this.ebeanServer = EbeanServerFactory.create(config);
    }

    @PreDestroy
    public void destroy() {
        log.info("Shutting down eBean Server....");
        this.ebeanServer.shutdown(true, true);
    }
}
