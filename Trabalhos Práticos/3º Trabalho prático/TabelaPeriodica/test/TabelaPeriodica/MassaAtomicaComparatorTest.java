/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

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
public class MassaAtomicaComparatorTest {
    
    public MassaAtomicaComparatorTest() {
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
     * Test of compare method, of class MassaAtomicaComparator.
     */
    @Test
    public void testCompare() throws FileNotFoundException {
        System.out.println("Comparator Massa Atomica para a ordenação de tabela");
        
        MassaAtomicaComparator comparator = new MassaAtomicaComparator();
        LeituraTabelaPeriodica instance = new LeituraTabelaPeriodica();
        
        instance.lerElementos(TABLEFILE);
        
        // Discoverer: Davy - Year: 1808 - Atomic Number: 20
        ElementoMassaAtomica a = instance.getArvoreMassaAtomica().procurarPorMassaAtomica(40.08);
        // Discoverer: Davy - Year: 1807 - Atomic Number: 11
        ElementoMassaAtomica b = instance.getArvoreMassaAtomica().procurarPorMassaAtomica(22.9897693);
        
        // Discoverer: Prehistoric - Year: null - Atomic Number: 16
        ElementoMassaAtomica c = instance.getArvoreMassaAtomica().procurarPorMassaAtomica(32.07);
        // Discoverer: Prehistoric - Year: null - Atomic Number: 26
        ElementoMassaAtomica d = instance.getArvoreMassaAtomica().procurarPorMassaAtomica(55.84);
        
        int expResultA = -1;
        int resultA = comparator.compare(a, b);
        
        int expResultB = -1;
        int resultB = comparator.compare(c, d);
        
        assertEquals(expResultA, resultA);
        assertEquals(expResultB, resultB);
    }
    
}
