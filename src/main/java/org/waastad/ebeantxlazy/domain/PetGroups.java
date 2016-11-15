/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
public class PetGroups extends BaseModel{
    
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Person personId;
    
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pet pet;
}
