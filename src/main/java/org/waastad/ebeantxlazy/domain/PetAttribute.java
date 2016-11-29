/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.PetAttributeFinder;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
@Table(name = "t_pet_attribute")
public class PetAttribute extends BaseModel {

  public static final PetAttributeFinder find = new PetAttributeFinder();


    private String name;
    private String value;

    @ManyToOne(targetEntity = Pet.class)
    @JoinColumn(name = "pet_id",referencedColumnName = "id")
    private Pet pet;
    
    public PetAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

}
