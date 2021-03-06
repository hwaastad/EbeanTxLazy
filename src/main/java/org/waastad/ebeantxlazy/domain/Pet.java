/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.PetFinder;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
public class Pet extends BaseModel {

  public static final PetFinder find = new PetFinder();

    private String name;
    @ManyToOne(targetEntity = Person.class)
    private Person person;

    public Pet(String name) {
        this.name = name;
    }

}
