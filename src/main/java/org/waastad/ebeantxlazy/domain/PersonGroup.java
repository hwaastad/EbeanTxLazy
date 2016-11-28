/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.PersonGroupFinder;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
@Table(name = "persongroup")
public class PersonGroup extends BaseModel {

  public static final PersonGroupFinder find = new PersonGroupFinder();

    private String name;

    @JoinTable(name = "person_persongroup", joinColumns = {
        @JoinColumn(name = "person_group", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "person", referencedColumnName = "id")})
    @ManyToMany()
    private List<Person> persons;

    public PersonGroup(String name) {
        this.name = name;
    }

}
