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
@Table(name = "t_person_group")
public class PersonGroup extends Model {

  public static final PersonGroupFinder find = new PersonGroupFinder();

    @EmbeddedId
    private PersonGroupId pk;

    @ManyToOne
    @JoinColumn(name = "aperson", insertable = false, updatable = false)
    private Person aperson;

    @ManyToOne
    @JoinColumn(name = "agroup", insertable = false, updatable = false)
    private Group agroup;

    @Transient
    public Person getAperson() {
        return aperson;
    }

    public void setAperson(Person aperson) {
        this.aperson = aperson;
        pk.setAperson(aperson.getId());
    }

    @Transient
    public Group getAgroup() {
        return agroup;
    }

    public void setAgroup(Group agroup) {
        this.agroup = agroup;
        pk.setAgroup(agroup.getId());
    }   
}
