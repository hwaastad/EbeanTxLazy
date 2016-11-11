/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.ebeantxlazy.ejb;

import java.util.List;
import javax.ejb.Stateless;
import org.waastad.ebeantxlazy.domain.Customer;

/**
 *
 * @author helge
 */
@Stateless
public class BusinessBean {

    public List<Customer> findAll() {
        return Customer.find.all();
    }
}
