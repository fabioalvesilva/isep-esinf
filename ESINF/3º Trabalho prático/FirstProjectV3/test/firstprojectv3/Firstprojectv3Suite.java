/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstprojectv3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Fábio Silva
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({firstprojectv3.mainTest.class, firstprojectv3.Exercicio5ListTest.class, firstprojectv3.Exercicio2ListTest.class, firstprojectv3.Exercicio1Test.class, firstprojectv3.Exercicio3ListTest.class, firstprojectv3.Exercicio4ListTest.class})
public class Firstprojectv3Suite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
