/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.domain;

import com.avaje.ebean.Model;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author helge
 */
@MappedSuperclass
public abstract class BaseModel extends Model {
    @Id
    @Column(name = "ID")
    private Long id;
}
