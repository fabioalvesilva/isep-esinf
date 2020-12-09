/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoRedes;

import LeituraFicheiros.Controlador;
import MatrixGraph.AdjacencyMatrixGraph;
import RedeSocial.RedeSocial;
import RedeSocial.Utilizador;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static Util.Constantes.*;

/**
 * Classe ConectividadeTest que corresponde à alínea 3
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class ConectividadeTest {

    
    public ConectividadeTest() throws FileNotFoundException {

    
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
     * Test of verificarConectividade method, of class Conectividade.
     */
    @Test
    public void testVerificarConectividade() throws FileNotFoundException {
        
        System.out.println("\n##Verificar se a matriz é conexa com ficheiros SMALL##");
    
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);
        
        boolean resultado = Conectividade.verificarConectividade(controlador.getRedeSocial().getMatrix());
        
        assertEquals(true, resultado);
        
        double minPath = Conectividade.caminhoMinimoPossivel(controlador.getRedeSocial().getMatrix());
        
        System.out.println("A Matriz é conexa e o mínimo caminho possível = " + minPath);
        
    }
    
     /**
     * Test of verificarConectividade method, of class Conectividade.
     */
    @Test
    public void testVerificarConectividadeBIG() throws FileNotFoundException {
        
        System.out.println("\n##Verificar se a matriz é conexa com ficheiros BIG##");
    
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);
        
        boolean resultado = Conectividade.verificarConectividade(controlador.getRedeSocial().getMatrix());
        
        assertEquals(false, resultado);
        
        System.out.println("A matriz não é conexa.");
    }
    
    

    /**
     * Test of caminhoMinimoPossivel method, of class Conectividade.
     */
    @Test
    public void testCaminhoMinimoPossivel() throws FileNotFoundException {
        System.out.println("\n##Caminho Minimo Possivel com ficheiros BIG##");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);
        
        AdjacencyMatrixGraph<Utilizador, Double> graph = controlador.getRedeSocial().getMatrix();
        
        double caminhos = Conectividade.caminhoMinimoPossivel(graph);
        
        assertEquals(5.0, caminhos, 0);
         
        System.out.println("O mais longo dos caminhos mais curtos = " + caminhos); 
        
    }
}
