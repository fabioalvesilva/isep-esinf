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
public class fibonnacciTest {
    
    public fibonnacciTest() {
    }

    /**
     * Test of fib method, of class fibonnacci.
     */
    @Test
    public void testFib() {
        System.out.println("fib");
        int n = 7;
        int expResult = 13;
        int result = fibonnacci.fib(n);
        assertEquals(expResult, result);
    }
    
}
