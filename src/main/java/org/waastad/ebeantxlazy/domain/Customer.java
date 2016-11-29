/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.CustomerFinder;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
@Table(name = "t_customer")
public class Customer extends BaseModel {

  public static final CustomerFinder find = new CustomerFinder();


    private String name;

    @OneToMany(targetEntity = Person.class)
    private List<Person> persons;

    public Customer(String name) {
        this.name = name;
    }

}
