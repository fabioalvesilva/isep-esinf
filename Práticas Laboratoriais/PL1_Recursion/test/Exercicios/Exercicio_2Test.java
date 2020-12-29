/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicios;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fábio Silva
 */
public class Exercicio_2Test {
    
    public Exercicio_2Test() {
    }

    /**
     * Test of productTwoInt method, of class Exercicio_2.
     */
    @Test
    public void testProductTwoInt() {
        System.out.println("productTwoInt");
        int m = 10;
        int n = 5;
        Integer expResult = 50;
        Integer result = Exercicio_2.productTwoInt(m, n);
        assertEquals(expResult, result);
    }
    
}
