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
public class ArvoreNrAtomicoTest {
    
    public ArvoreNrAtomicoTest() {
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
     * Test of getArvore method, of class ArvoreNrAtomico.
     */
    @Test
    public void testGetArvore() {
        System.out.println("getArvore");
       
    }

    /**
     * Test of procurarPorNrAtomico method, of class ArvoreNrAtomico.
     */
    @Test
    public void testProcurarPorNrAtomico() throws FileNotFoundException {
        System.out.println("Procurar Por Numero Atomico");
        
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        
        Integer numero = 12;
        
        ArvoreNrAtomico arvore = instance.getArvoreNrAtomico();
        
        ElementoNrAtomico result = arvore.procurarPorNrAtomico(numero);
        
        assertEquals(numero, result.getElemento().getNumeroAtomico());
    }
    
}
