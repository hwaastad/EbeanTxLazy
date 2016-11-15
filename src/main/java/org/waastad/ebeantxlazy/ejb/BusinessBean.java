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
import org.waastad.ebeantxlazy.domain.Pet;
import org.waastad.ebeantxlazy.domain.PetGroups;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean {

    public List<Customer> findAll() {
        return Customer.find.all();
    }

    public void createWithAll(String name) {
        Ebean.beginTransaction();
        try {
            Customer c = new Customer(name);
            Person p = new Person(name);
            c.getPersons().add(p);
            Pet pet = new Pet(name);
            p.getPets().add(pet);

            PetGroups petGroups = new PetGroups();
            petGroups.setPet(pet);
            petGroups.setPersonId(p);
            p.getPetGroups().add(petGroups);

            c.save();
            Ebean.commitTransaction();
        } finally {
            Ebean.endTransaction();
        }
    }

    public void deletePet(String name) {
        Pet findByName = Pet.find.findByName(name);
//        findByName.getPetGroups().forEach((pg) -> {
//            pg.setPet(null);
//        });
        findByName.delete();
    }
}
