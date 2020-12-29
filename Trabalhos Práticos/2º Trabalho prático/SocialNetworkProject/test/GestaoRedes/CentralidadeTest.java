/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoRedes;

import GraphBase.Graph;
import LeituraFicheiros.Controlador;
import MatrixGraph.AdjacencyMatrixGraph;
import RedeSocial.Cidade;
import RedeSocial.Distancia;
import RedeSocial.Utilizador;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Set;
import javafx.util.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static Util.Constantes.*;
import java.util.TreeSet;

/**
 * Classe CentralidadeTest que corresponde à alínea 5
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class CentralidadeTest {
    

    
    public CentralidadeTest() {
        

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
     * Test of cidadesComMaiorCentralidade method, of class Centralidade.
     */
    @Test
    public void getCidadesMaiorCentralidade() throws FileNotFoundException {
        System.out.println("##Teste Cidades com maior centralidade com ficheiros SMALL##");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);
        
        //percentagem de users 
        double p = 5.0;
        
        //n cidades
        int n = 2;
        
        Set<Cidade> expResult = new TreeSet<>();
        
        expResult.add(controlador.getRedeCidades().getCidade("lapaz"));
        expResult.add(controlador.getRedeCidades().getCidade("quito"));
        
        Set <Cidade> result = Centralidade.getCidadesMaiorCentralidade(controlador.getRedeSocial().getMatrix(), controlador.getRedeCidades().getGraph(), p, n);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of cidadesComMaiorCentralidade method, of class Centralidade.
     */
    @Test
    public void testGetCidadesMaiorCentralidadeBIG() throws FileNotFoundException {
        System.out.println("Teste Cidades com maior centralidade com ficheiros BIG");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);
        
        //Percentagem de users 
        double p = 2.5;
        
        //n cidades
        int n = 10;
        
        Set<Cidade> expResult = new TreeSet<>();
        
        expResult.add(controlador.getRedeCidades().getCidade("belgrado"));
        expResult.add(controlador.getRedeCidades().getCidade("erevan"));
        expResult.add(controlador.getRedeCidades().getCidade("oslo"));
        
        Set <Cidade> result = Centralidade.getCidadesMaiorCentralidade(controlador.getRedeSocial().getMatrix(), controlador.getRedeCidades().getGraph(), p, n);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of fechoTransitivo method, of class Centralidade.
     */
    @Test
    public void testFechoTransitivo() {
        System.out.println("fechoTransitivo");
        Graph<Cidade, Distancia> redeCidades = null;
        double[][] caminhos = null;
        double[][] expResult = null;
        double[][] result = Centralidade.fechoTransitivo(redeCidades, caminhos);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matrizDistancias method, of class Centralidade.
     */
    @Test
    public void testMatrizDistancias() {
        System.out.println("matrizDistancias");
        AdjacencyMatrixGraph<Utilizador, Double> redeUtilizadores = null;
        Graph<Cidade, Distancia> redeCidades = null;
        int n = 0;
        LinkedList<Cidade> listaCidades = null;
        double[][] expResult = null;
        double[][] result = Centralidade.matrizDistancias(redeUtilizadores, redeCidades, n, listaCidades);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matrizMediasCidades method, of class Centralidade.
     */
    @Test
    public void testMatrizMediasCidades() throws FileNotFoundException {
        System.out.println("##Matriz Medias da Cidades com ficheiro SMALL##");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);
        
        Graph<Cidade, Distancia> graph = controlador.getRedeCidades().getGraph();
        double[][] matrizFloyd = null;
        int numUsers = 0;
        double p = 0.0;
        int n = 0;
        
        LinkedList<Cidade> listCidades = null;
        Set<Pair<Cidade, Double>> expResult = null;
        Set<Pair<Cidade, Double>> result = Centralidade.matrizMediasCidades(graph, matrizFloyd, numUsers, p, n, listCidades);
        assertEquals(expResult, result);
    }

    /**
     * Test of percentagemUtilizadoresCidade method, of class Centralidade.
     */
    @Test
    public void testPercentagemUtilizadoresCidade() throws FileNotFoundException {
        System.out.println("##Percentagem Utilizadores Cidade com ficheiro SMALL##");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);
        
        Cidade c = controlador.getRedeCidades().getCidade("brasilia");
        Cidade e = controlador.getRedeCidades().getCidade("quito");
        Cidade t = controlador.getRedeCidades().getCidade("lima");
        
        double p = 15.0;
        
        int totalUtilizadores = controlador.getRedeCidades().getNumCidades();
        
        boolean expResultC = true;
        boolean expResultE = true;
        boolean expResultT = false;
        
        boolean resultC = Centralidade.percentagemUtilizadoresCidade(c, p, totalUtilizadores);
        boolean resultE = Centralidade.percentagemUtilizadoresCidade(e, p, totalUtilizadores);
        boolean resultT = Centralidade.percentagemUtilizadoresCidade(t, p, totalUtilizadores);
        
        assertEquals(expResultC, resultC);
        assertEquals(expResultE, resultE);
        assertEquals(expResultT, resultT);
    }
    
    /**
     * Test of percentagemUtilizadoresCidade method, of class Centralidade.
     */
    @Test
    public void testPercentagemUtilizadoresCidadeBIG() throws FileNotFoundException {
        System.out.println("##Percentagem Utilizadores Cidade com ficheiro BIG##");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);
        
        Cidade c = controlador.getRedeCidades().getCidade("brasilia");
        Cidade e = controlador.getRedeCidades().getCidade("quito");
        Cidade t = controlador.getRedeCidades().getCidade("lima");
        Cidade a = controlador.getRedeCidades().getCidade("moscovo");
        
        double p = 15.0;
        
        int totalUtilizadores = controlador.getRedeCidades().getNumCidades();
        
        boolean expResultC = true;
        boolean expResultE = true;
        boolean expResultT = true;
        boolean expResultA = false;
        
        boolean resultC = Centralidade.percentagemUtilizadoresCidade(c, p, totalUtilizadores);
        boolean resultE = Centralidade.percentagemUtilizadoresCidade(e, p, totalUtilizadores);
        boolean resultT = Centralidade.percentagemUtilizadoresCidade(t, p, totalUtilizadores);
        boolean resultA = Centralidade.percentagemUtilizadoresCidade(a, p, totalUtilizadores);
        
        assertEquals(expResultC, resultC);
        assertEquals(expResultE, resultE);
        assertEquals(expResultT, resultT);
        assertEquals(expResultA, resultA);
    }
    
}
