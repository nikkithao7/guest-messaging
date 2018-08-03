/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nt.guestmessaging.model.Company;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nthao
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {

    private List<Company> companyList = new ArrayList<>();

    @Override
    public List<Company> getAllCompanies() throws FileNotFoundException {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader("Companies.json"));
        Type type = new TypeToken<List<Company>>() {
        }.getType();
        companyList = gson.fromJson(br, type);
        return companyList;
    }

    @Override
    public Company getCompanyById(int id) throws FileNotFoundException {
        getAllCompanies();

        for (Company c : companyList) {
            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }

}
