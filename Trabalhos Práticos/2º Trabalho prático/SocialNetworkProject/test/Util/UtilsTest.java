/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fábio Silva
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of distance method, of class Utils.
     */
    @Test
    public void testDistance() {
        System.out.println("##Teste distancias##");
        
        double lat1 = -58.37723;
        double lon1 = -34.61315;
        double lat2 = -33.45694;
        double lon2 = -70.64827;
        
        double lat3 = -57.63591;
        double lon3 = -25.30066;
        double lat4 = -68.15;
        double lon4 = -16.5;
        
        double expResult = 3846.53;
        double expResult1 = 1248.29;
        
        double result = Utils.distance(lat1, lon1, lat2, lon2);
        double result1 = Utils.distance(lat3, lon3, lat4, lon4);
        
        assertEquals(expResult, result, 0.0);
        assertEquals(expResult1, result1, 0.0);

        
    }

    /**
     * Test of ordenaPorValor method, of class Utils.
     */
    @Test
    public void testOrdenaPorValor() {
        System.out.println("ordenaPorValor");
        
        Map <String, Double> map = new TreeMap<>();
        Map <String, Double> expResult = new TreeMap<>();
        
        map.put("Porto", 4.0);
        map.put("Lisboa", 6.0);
        map.put("Leiria", 3.5);
        map.put("Santa Maria da Feira", 1.0);
        
        expResult.put("Santa Maria da Feira", 1.0);
        expResult.put("Leiria", 3.5);
        expResult.put("Porto", 4.0);
        expResult.put("Lisboa", 6.0);
        
        Map result = Utils.ordenaPorValor(map);
        assertEquals(expResult, result);
    }
    
}
