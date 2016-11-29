/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.PersonFinder;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
@Table(name = "t_person")
public class Person extends BaseModel {

    public static final PersonFinder find = new PersonFinder();

    private String name;

    @OneToMany(targetEntity = Pet.class, cascade = CascadeType.ALL)
    private List<Pet> pets;

//    @ManyToMany(mappedBy = "persons",cascade = CascadeType.REMOVE)
//    private List<Group> personGroups;
    @OneToMany(mappedBy = "aperson")
    public List<PersonGroup> personGroups;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    public Person(String name) {
        this.name = name;
    }

}
