/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.ejb;

import com.avaje.ebean.Ebean;
import java.util.List;
import javax.ejb.Stateless;
import org.waastad.ebeantxlazy.domain.Customer;
import org.waastad.ebeantxlazy.domain.Person;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean {

    public List<Customer> findAll() {
        return Customer.find.all();
    }

    public void deleteUsers() {
        Ebean.beginTransaction();
        try {
            List<Person> all = Person.find.all();
            Ebean.deleteAll(all);
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
    }
}
