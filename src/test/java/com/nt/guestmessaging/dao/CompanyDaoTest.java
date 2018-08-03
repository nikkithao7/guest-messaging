/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.nt.guestmessaging.model.Company;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author nthao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompanyDaoTest {

    @Autowired
    CompanyDao dao;

    List<Company> companyList = new ArrayList<>();

    public CompanyDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        companyList = dao.getAllCompanies();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllCompanies method, of class CompanyDao.
     */
    @Test
    public void testGetAllCompanies() throws Exception {
        assertEquals(5, companyList.size());
    }

    /**
     * Test of getCompanyById method, of class CompanyDao.
     */
    @Test
    public void testGetCompanyById() throws Exception {
        Company company = dao.getCompanyById(1);

        assertEquals("Hotel California", company.getcompany());
    }

}
