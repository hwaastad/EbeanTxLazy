/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.PetFinder;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "t_pet")
public class Pet extends BaseModel {

    public static final PetFinder find = new PetFinder();

    private String name;
    @Column(name = "person_id")
    @ManyToOne(targetEntity = Person.class)
    private Person person;
    @OneToMany(targetEntity = PetAttribute.class, cascade = CascadeType.ALL)
    private List<PetAttribute> pets;

    public Pet(String name) {
        this.name = name;
    }

}
