/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.PersonGroupFinder;
import com.avaje.ebean.Model;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author helge
 */
@Entity
@Table(name = "person_group")
public class PersonGroup extends Model {

  public static final PersonGroupFinder find = new PersonGroupFinder();

    @EmbeddedId
    private PersonGroupId pk;

    @ManyToOne
    @JoinColumn(name = "person", insertable = false, updatable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "group", insertable = false, updatable = false)
    private Group group;

    @Transient
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        pk.setPerson(person.getId());
    }

    @Transient
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
        pk.setGroup(group.getId());
    }   
}
