/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.nt.guestmessaging.model.Company;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author nthao
 */
public interface CompanyDao {
    
    List<Company> getAllCompanies() throws FileNotFoundException ;

    Company getCompanyById(int id) throws FileNotFoundException ;

}
