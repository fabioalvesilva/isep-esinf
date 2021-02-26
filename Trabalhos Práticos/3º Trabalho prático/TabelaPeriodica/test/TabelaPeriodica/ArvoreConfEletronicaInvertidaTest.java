/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.BST;
import EstruturasArvores.TextWord;
import LeituraFicheiro.LeituraTabelaPeriodica;
import static Util.Constantes.TABLEFILE;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
public class ArvoreConfEletronicaInvertidaTest {

    public ArvoreConfEletronicaInvertidaTest() {
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
     * Test of insertPalavras method, of class ArvoreConfEletronicaInvertida.
     */
    @Test
    public void testInsertPalavras() {
        Map<Integer, List<String>> mapPalavras = new HashMap<>(); 
        ArrayList<String>   listaPalavras1  = new ArrayList<>();
        ArrayList<String>   listaPalavras2  = new ArrayList<>();
        ArrayList<String>   listaPalavras3  = new ArrayList<>();
        ArrayList<String>   listaPalavras4  = new ArrayList<>(); // A ser Ignorada
        
         listaPalavras1.add("[Xe]");
        listaPalavras2.add("[Ar]");
        listaPalavras2.add("[Kr]");
        listaPalavras3.add("[Xe] 4f14");
        listaPalavras3.add("[Kr] 4d10");
        listaPalavras3.add("[Rn]");
        listaPalavras3.add("[Ar] 3d10");
        listaPalavras3.add("[He]");
        listaPalavras3.add("[Ne]");
        //9 Elementos TOTAL
        //Elementos que serao Ignorados
        listaPalavras4.add("[Xe] 4f14 5d10");
        listaPalavras4.add("[Ar] 3d10 4s2");
        listaPalavras4.add("[He] 2s2");
        listaPalavras4.add("[Kr] 4d10 5s2");
        listaPalavras4.add("[Ne] 3s2");
        mapPalavras.put(new Integer (10), listaPalavras1);
        mapPalavras.put(new Integer (9), listaPalavras2);
        mapPalavras.put(new Integer (8), listaPalavras3);
        mapPalavras.put(new Integer (2), listaPalavras4); // A ser Ignorada
        
        ArvoreConfEletronicaInvertida arv = new ArvoreConfEletronicaInvertida();
        arv.insertPalavras(mapPalavras);
        assertEquals(arv.size(), 9);
    }

    /**
     * Test of elementosMaisDistantes method, of class
     * ArvoreConfEletronicaInvertida.
     */
    @Test
    public void testElementosMaisDistantes() throws FileNotFoundException {
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        //instance.transformarArvoreBinaria();
        
        ArvoreConfEletronicaInvertida arv = instance.getArvoreConfEletronicaInvertida();
        
        HashMap<Integer, List<TextWord>> map = arv.elementosMaisDistantes();
        map.get(0);
        assertEquals(map.size(), 1);
        boolean expect = true;
        boolean actual =  map.containsKey(9); //TAMANHO DA KEY  9
        assertEquals(expect, actual);

    }

    /**
     * Test of longestPath method, of class ArvoreConfEletronicaInvertida.
     *//*
    @Test
    public void testLongestPath() {
        System.out.println("longestPath");
        BST.Node<TextWord> root = null;
        ArvoreConfEletronicaInvertida instance = new ArvoreConfEletronicaInvertida();
        ArrayList<TextWord> expResult = null;
        ArrayList<TextWord> result = instance.longestPath(root);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of arvoreCompleta method, of class ArvoreConfEletronicaInvertida.
     *//*
    @Test
    public void testArvoreCompleta() {
        System.out.println("arvoreCompleta");
        ArvoreConfEletronicaInvertida instance = new ArvoreConfEletronicaInvertida();
        instance.arvoreCompleta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of printGivenLevel method, of class ArvoreConfEletronicaInvertida.
     *//*
    @Test
    public void testPrintGivenLevel() {
        System.out.println("printGivenLevel");
        BST.Node root = null;
        int level = 0;
        ArvoreConfEletronicaInvertida instance = new ArvoreConfEletronicaInvertida();
        instance.printGivenLevel(root, level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of transformarArvoreBinaria method, of class
     * ArvoreConfEletronicaInvertida.
     */
    @Test
    public void testTransformarArvoreBinaria() throws FileNotFoundException {
        System.out.println("transformarArvoreBinaria");

        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        instance.transformarArvoreBinaria();

        int height = instance.getArvoreConfEletronicaInvertida().height();

        // Mapa com nos por nivel de altura
        Map<Integer, List<TextWord>> map = instance.getArvoreConfEletronicaInvertida().nodesByLevel();

        int nrElementosFila2 = map.get(2).size();
        int nrElementosFila4 = map.get(6).size();

        assertTrue("A altura da arvore é 6, o nivel 2 tem 4 elementos e o nivel 4 tem 16 elementos",
                height == 6 && nrElementosFila2 == 4 && nrElementosFila4 == 64);

         
    System.out.println (instance.getArvoreConfEletronicaInvertida());
    }

  
    /**
     * Test of find method, of class ArvoreConfEletronicaInvertida.
     *//*
    @Test
        public void testFind() {
        System.out.println("find");
        BST.Node<TextWord> node = null;
        TextWord elemento = null;
        ArvoreConfEletronicaInvertida instance = new ArvoreConfEletronicaInvertida();
        BST.Node<TextWord> expResult = null;
        BST.Node<TextWord> result = instance.find(node, elemento);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
