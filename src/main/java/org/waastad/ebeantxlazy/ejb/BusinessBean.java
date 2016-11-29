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
import org.waastad.ebeantxlazy.domain.Group;
import org.waastad.ebeantxlazy.domain.Person;
import org.waastad.ebeantxlazy.domain.PersonGroup;
import org.waastad.ebeantxlazy.domain.PersonGroupId;
import org.waastad.ebeantxlazy.domain.Pet;
import org.waastad.ebeantxlazy.domain.PetAttribute;

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

    public void deleteUsersStep(String name) {
        Ebean.beginTransaction();
        try {
            PetAttribute.find.deleteByName(name);
            Pet.find.deleteByName(name);
            PersonGroup.find.deleteByName(name);
            Person.find.deleteByName(name);
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
    }

    public void addToGroup(String name, Long groupId) {
        Ebean.beginTransaction();
        try {
            Person byyName = Person.find.byName(name);
            Group byId = Group.find.byId(2L);
            PersonGroup group = new PersonGroup(byyName, byId);
            group.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
    }
}
