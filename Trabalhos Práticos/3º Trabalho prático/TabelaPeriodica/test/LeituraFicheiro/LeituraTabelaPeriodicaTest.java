/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeituraFicheiro;

import TabelaPeriodica.ArvoreElemento;
import TabelaPeriodica.ArvoreMassaAtomica;
import TabelaPeriodica.ArvoreNrAtomico;
import TabelaPeriodica.ArvoreSimbolo;
import static Util.Constantes.TABLEFILE;
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
public class LeituraTabelaPeriodicaTest {
    
    public LeituraTabelaPeriodicaTest() {
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
     * Test of lerElementos method, of class LeituraTabelaPeriodica.
     */
    @Test
    public void testLerElementos() throws Exception {
        
        System.out.println("Ler Elementos");
        
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        
        
        instance.lerElementos(TABLEFILE);
        boolean treesCreation  = false;
        if (instance.getArvoreConfEletronicaInvertida() != null &&
                instance.getArvoreConfiguracaoEletronica() != null &&
                instance.getArvoreMassaAtomica()  != null && 
                instance.getArvoreNrAtomico() != null && 
                instance.getArvoreSimbolo() != null)  treesCreation = true;
        
         assertEquals(instance.getArvoreMassaAtomica().isEmpty(), false);
         assertEquals(instance.getArvoreConfEletronicaInvertida().isEmpty(), false);
         assertEquals(instance.getArvoreConfiguracaoEletronica().isEmpty(), false);
         assertEquals(instance.getArvoreNrAtomico().isEmpty(), false);
         assertEquals(instance.getArvoreSimbolo().isEmpty(), false);
        assertEquals(treesCreation, true);
        
    }

    /**
     * Test of getArvoreMassaAtomica method, of class LeituraTabelaPeriodica.
     */
    @Test
    public void testGetArvoreMassaAtomica() {
        System.out.println("getArvoreMassaAtomica");
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        assertEquals(instance.getArvoreMassaAtomica().isEmpty(), true);
        
        

    }

    /**
     * Test of getArvoreNrAtomico method, of class LeituraTabelaPeriodica.
     */
    @Test
    public void testGetArvoreNrAtomico() {
        System.out.println("getArvoreNrAtomico");
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();

         assertEquals(instance.getArvoreNrAtomico().isEmpty(), true);
    }

    /**
     * Test of getArvoreElemento method, of class LeituraTabelaPeriodica.
     */
    @Test
    public void testGetArvoreElemento() {
        System.out.println("getArvoreElemento");
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        
         assertEquals(instance.getArvoreElemento().isEmpty(), true);
    }

    /**
     * Test of getArvoreSimbolo method, of class LeituraTabelaPeriodica.
     */
    @Test
    public void testGetArvoreSimbolo() {
        System.out.println("getArvoreSimbolo");
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        
         assertEquals(instance.getArvoreSimbolo().isEmpty(), true);

    }
    
}
