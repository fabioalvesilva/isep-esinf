/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fábio Silva
 */
public class frogTest {
    
    public frogTest() {
    }

    
    /**
     * Test of nWays method, of class frog.
     */
    @Test
    public void testNWays() {
        System.out.println("nWays");
        int n = 2;
        frog instance = new frog();
        int expResult = 3;
        int result = instance.nWays(n);
        assertEquals(expResult, result);
    }
    
}
