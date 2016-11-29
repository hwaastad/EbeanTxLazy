/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.Data;

/**
 *
 * @author helge
 */
@Embeddable
@Data
public class PersonGroupId implements Serializable {

    private static final long serialVersionUID = -4918927027060937324L;

    private Long aperson;
    private Long agroup;

    public PersonGroupId(Long aperson, Long agroup) {
        this.aperson = aperson;
        this.agroup = agroup;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        PersonGroupId b = (PersonGroupId) obj;
        if (b == null) {
            return false;
        }
        return Objects.equals(b.aperson, aperson) && Objects.equals(b.agroup, agroup);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.aperson);
        hash = 59 * hash + Objects.hashCode(this.agroup);
        return hash;
    }
}
