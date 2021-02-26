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
public class ArvoreElementoTest {
    
    public ArvoreElementoTest() {
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
     * Test of getArvore method, of class ArvoreElemento.
     */
    @Test
    public void testGetArvore() {
        System.out.println("getArvore");
        
        
     
       // assertEquals(expResult, result);
    }

    /**
     * Test of procurarPorNome method, of class ArvoreElemento.
     */
    @Test
    public void testProcurarPorNome() throws FileNotFoundException {
        
        LeituraTabelaPeriodica lt = new LeituraTabelaPeriodica();
        lt.lerElementos(TABLEFILE);
        ArvoreElemento aE = lt.getArvoreElemento();
        
        ElementoNome eNome = aE.procurarPorNome("Magnesium");
        Elemento e = eNome.getElemento();
        assertEquals(eNome.getElemento().getElemento(), "Magnesium");
        assertEquals(e.getAno(), new Integer(1755));
        assertEquals(e.getSimbolo(),"Mg" );
        assertEquals(e.getConfigEletrao(),"[Ne] 3s2" );
        System.out.println("Procurar por Nome do Elemento");
        
        //OUTRO ELEMENTO 
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        
        String nome = "Beryllium";
        
        ElementoNome result = instance.getArvoreElemento().procurarPorNome(nome);
        
        assertEquals(result.getElemento().getElemento(), nome);

    }
}
