/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import org.waastad.ebeantxlazy.domain.finder.GroupFinder;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author helge
 */
@Entity
@Data
@Table(name = "t_group")
public class Group extends BaseModel {

    public static final GroupFinder find = new GroupFinder();

    private String name;

//    @JoinTable(name = "person_persongroup", joinColumns = {
//        @JoinColumn(name = "person_group", referencedColumnName = "id")}, inverseJoinColumns = {
//        @JoinColumn(name = "person", referencedColumnName = "id")})
//    @ManyToMany()
//    private List<Person> persons;
//    @OneToMany
//    private List<PersonGroup> personGroups;
    @OneToMany(mappedBy = "agroup")
    public List<PersonGroup> personGroups;

    public Group(String name) {
        this.name = name;
    }

}
