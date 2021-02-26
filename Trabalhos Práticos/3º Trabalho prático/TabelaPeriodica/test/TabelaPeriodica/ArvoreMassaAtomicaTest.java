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
import java.util.LinkedList;
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
public class ArvoreMassaAtomicaTest {
    
    public ArvoreMassaAtomicaTest() {
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
     * Test of procurarPorMassaAtomica method, of class ArvoreMassaAtomica.
     */
    @Test
    public void testProcurarPorMassaAtomica() throws FileNotFoundException {
        System.out.println("Procurar por Massa Atomica");
        
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        
        Double massa = 4.0026;
        
        ArvoreMassaAtomica arvore = instance.getArvoreMassaAtomica();
        
        ElementoMassaAtomica result = arvore.procurarPorMassaAtomica(massa);
        
        assertEquals(massa, result.getElemento().getMassaAtomica());
    }

   

    /**
     * Test of pesquisaPorMassaIntervalo method, of class ArvoreMassaAtomica.
     */
    @Test
    public void testPesquisaPorMassaIntervalo() throws Exception {
        System.out.println("pesquisaPorMassaIntervalo");
        
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        instance.lerElementos(TABLEFILE);
        
        Double min = 20.0;
        Double max = 65.0;

        List<ElementoMassaAtomica> expresult = instance.getArvoreMassaAtomica().pesquisaPorMassaIntervalo(instance.getArvoreMassaAtomica(), min, max);
        
        printTable(expresult);        
    }
    
    public void printTable (List<ElementoMassaAtomica> list){
        
        System.out.printf ("%15s | %10s | %10s | %15s | %10s | %20s| %20s | %10s", 
                "Número Atómico", "Elemento", "Simbolo", "Massa Atomica", "Phase", "Tipo", "Descobridor", "Ano de Descoberta");
        System.out.println();
        for(int i = 0; i < list.size(); i++){
            System.out.printf ("%15d | %10s | %10s | %15f | %10s | %20s| %20s | %10d\n", 
                list.get(i).getElemento().getNumeroAtomico(), list.get(i).getElemento().getElemento(), 
                list.get(i).getElemento().getSimbolo(), list.get(i).getElemento().getMassaAtomica(), 
                list.get(i).getElemento().getFase(), list.get(i).getElemento().getTipo(), 
                list.get(i).getElemento().getDescobridor(), list.get(i).getElemento().getAno());
        }
        
    }
}


