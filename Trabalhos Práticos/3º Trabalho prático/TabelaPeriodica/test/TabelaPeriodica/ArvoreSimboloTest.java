/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.AVL;
import EstruturasArvores.BST;
import LeituraFicheiro.LeituraTabelaPeriodica;
import static Util.Constantes.TABLEFILE;
import java.io.FileNotFoundException;
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
public class ArvoreSimboloTest {
    
    public ArvoreSimboloTest() {
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
     * Test of getArvore method, of class ArvoreSimbolo.
     *//*
    @Test
    public void testGetArvore() {
        System.out.println("getArvore");
        ArvoreSimbolo instance = new ArvoreSimbolo();
        AVL expResult = null;
        AVL result = instance.
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of procurarPorSimbolo method, of class ArvoreSimbolo.
     */
    @Test
    public void testProcurarPorSimbolo() throws FileNotFoundException {
        System.out.println("Procurar por Simbolo");
        
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        
        String simbolo = "H";
        
        ElementoSimbolo result = instance.getArvoreSimbolo().procurarPorSimbolo(simbolo);
        
        assertEquals(simbolo, result.getElemento().getSimbolo());
    }
    
}
