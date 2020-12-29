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
public class Exercicio_3Test {
    
    public Exercicio_3Test() {
    }

   /**
     * Test of check method, of class Labirinth.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[][] actual = { 
            {1,1,1,0,1,1,0,0,0,1,1,1,1},
            {1,0,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,0,0,1,0,1,0,1,0,1,0,1},
            {1,0,0,0,1,1,1,0,1,0,1,1,1},            
            {1,1,1,1,1,0,0,0,0,1,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,1,1}                
        };
        int y = 0;
        int x = 0;
        int[][] expResult = { 
            {9,9,9,0,2,2,0,0,0,2,2,2,2},
            {1,0,9,9,9,0,2,2,2,2,2,0,2},
            {1,0,0,0,9,0,2,0,2,0,2,0,2},
            {1,0,0,0,9,2,2,0,2,0,2,2,2},            
            {1,1,1,1,9,0,0,0,0,1,0,0,0},
            {0,0,0,0,9,0,0,0,0,0,0,0,0},
            {0,0,0,0,9,9,9,9,9,9,9,9,9}                
        };
        int[][] result = Exercicio_3.check(actual, y, x);
        assertArrayEquals(expResult, result);
        
        int [] [] impossibleActual = { 
            {1,1,1,0,1,1,0,0,0,1,1,1,1},
            {1,0,1,1,1,0,1,1,1,1,1,0,1},
            {1,0,0,0,1,0,1,0,1,0,1,0,1},
            {1,0,0,0,1,1,1,0,1,0,1,1,1},            
            {1,1,1,1,1,0,0,0,0,1,0,0,0},
            {0,0,0,0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,1,1,1,1,1,1,1}                
        };
        expResult = null;
        result = Exercicio_3.check(impossibleActual, y, x);
        assertArrayEquals(expResult, result);        
        
    }
    
}
