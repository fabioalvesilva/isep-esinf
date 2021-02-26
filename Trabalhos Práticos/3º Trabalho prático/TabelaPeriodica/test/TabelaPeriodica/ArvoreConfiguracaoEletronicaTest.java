/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.AVL;
import EstruturasArvores.BST;
import EstruturasArvores.TextWord;
import LeituraFicheiro.LeituraTabelaPeriodica;
import TabelaPeriodica.ArvoreConfEletronicaInvertida;
import static Util.Constantes.TABLEFILE;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import junit.framework.Assert;
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
public class ArvoreConfiguracaoEletronicaTest {
    
    public ArvoreConfiguracaoEletronicaTest() {
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
       // System.out.println("getArvore");
        
        
     
       // assertEquals(expResult, result);
    }

    /**
     * Test Numero Nr elementos da árvore 
     */
    @Test
    public void testProcurarPorNome() throws FileNotFoundException {
       
        System.out.println("Teste Elementos Configuraçao Eletronica");
        
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("[Xe]");
        listaEsperada.add("[Ar]");
        listaEsperada.add("[Kr]");
        listaEsperada.add("[Xe] 4f14");
        listaEsperada.add("[Kr] 4d10");
        listaEsperada.add("[Rn]");
        listaEsperada.add("[Ar] 3d10");
        listaEsperada.add("[He]");
        listaEsperada.add("[Ne]");
        listaEsperada.add("[Xe] 4f14 5d10");
        listaEsperada.add("[Ar] 3d10 4s2");
        listaEsperada.add("[He] 2s2");
        listaEsperada.add("[Kr] 4d10 5s2");
        listaEsperada.add("[Ne] 3s2");
        listaEsperada.add("[Xe] 4f14 5d10 6s2");
        listaEsperada.add("[Ar] 3d5");
        listaEsperada.add("[Kr] 4d5");
        listaEsperada.add("[Xe] 4f7");

        
         Map<Integer, List<String>> map; //= new TreeMap<>();
        map = instance.getArvoreConfiguracaoEletronica().getNOcurrenciasPalavras(); //.getArvoreConfiguracaoEletronica().getWordsOccurrences();
        ArrayList<String> listaAtual =  new ArrayList<>();
        for(Integer i : map.keySet()){
            for(String s : map.get(i)){
                listaAtual.add(s);
            }
        }
        assertEquals(listaEsperada.size(), listaAtual.size());
        assertEquals(listaEsperada,listaAtual);
            /*
        //instance.getArvoreConfEletronicaInvertida().insertPalavras(map);
        System.out.println(instance.getArvoreConfEletronicaInvertida());
        //System.out.println(instance.getArvoreConfiguracaoEletronica());
        System.out.println("-----------------------");  
            ArrayList<TextWord>  arr  = new ArrayList<>();
            //Map<Integer,List<TextWord>> map2 = instance.getArvoreConfEletronicaInvertida().nodesByLevel();
            //System.out.println(instance.getArvoreConfEletronicaInvertida().posOrder());
            // System.out.println(instance.getArvoreConfEletronicaInvertida().preOrder());
           // System.out.println(instance.getArvoreConfEletronicaInvertida());
            //int tamanha = instance.getArvoreConfEletronicaInvertida().diameter();
            //instance.getArvoreConfEletronicaInvertida().elementosMaisDistantes();
            
            //instance.getArvoreConfEletronicaInvertida().elementosMaisDistantes();
            System.out.println(instance.getArvoreConfEletronicaInvertida());

            System.out.println("NOVA ARVORE");
            System.out.println(instance.getArvoreConfEletronicaInvertida());
            
            
            /*
               for (List<TextWord> listT : map2.values()){
                   for (TextWord t : listT){
                     arr.add(t);
                    }   
               }
               ArvoreConfEletronicaCompleta acec = new ArvoreConfEletronicaCompleta();
               
               acec.insertLevelOrder( arr);
               
               //System.out.println(arr);
              
                       //System.out.println(coiso);
               //LinkedList<TextWord> cenas = (LinkedList<TextWord>) instance.getArvoreConfEletronicaInvertida().pos();
                    
               //map.toString();
        */
  
    }
}
