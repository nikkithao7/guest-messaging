/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.controller;

import com.nt.guestmessaging.dao.CompanyDao;
import com.nt.guestmessaging.dao.EntityNotFoundException;
import com.nt.guestmessaging.model.Company;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nthao
 */
@RestController
public class CompanyController {

    @Autowired
    CompanyDao companyDao;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public List<Company> displayCompanies() throws FileNotFoundException {
        return companyDao.getAllCompanies();
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Company displayCompanyById(@PathVariable("id") int id) throws FileNotFoundException, EntityNotFoundException {
        Company company = companyDao.getCompanyById(id);

        if (company == null) {
            throw new EntityNotFoundException("Company id " + id + " does not exist. Please enter a valid company id.");
        }

        return company;
    }
}
