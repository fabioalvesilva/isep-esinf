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
public class Exercicio_1Test {
    
    public Exercicio_1Test() {
    }

    /**
     * Test of reverseString method, of class Exercicio_1.
     */
    @Test
    public void testReverseString() {
        System.out.println("reverseString");
        String str = "fabio";
        Exercicio_1 instance = new Exercicio_1();
        String expResult = "oibaf";
        String result = instance.reverseString(str);
        assertEquals(expResult, result);
    }
    
}
