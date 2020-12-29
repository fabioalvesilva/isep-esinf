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
import java.util.TreeMap;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static Util.Constantes.*;

/**
 * Classe ProximidadesTest que corresponde à alínea 4
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class ProximidadesTest {

    public ProximidadesTest() {

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
     * Test of amigosNasProximidades method, of class Proximidades com o User 10.
     */
    @Test
    public void testAmigosNasProximidadesUser10() throws FileNotFoundException {
        System.out.println("##Teste de Amigos Nas Proximidades com ficheiros SMALL##");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);
        
        Graph<Cidade, Distancia> grafoCidades = controlador.getRedeCidades().getGraph();
        AdjacencyMatrixGraph<Utilizador, Double> redeSocial = controlador.getRedeSocial().getMatrix();
        
        LinkedList<Utilizador> users = new LinkedList<>();
        Utilizador userTemp = null;
        
        for (Utilizador user: controlador.getUtilizadores()){
            users.add(user);
            if(user.getNome().equals("u10")){
                userTemp = user;
            }
        }
        
        int n = 1;
        
        System.out.println("USER 10 + N 1 - Número de amigo é 1");
        
        TreeMap<Cidade, TreeSet<Utilizador>> treeMap = Proximidades.amigosNasProximidades(users, grafoCidades, n, userTemp, redeSocial);
        
        assertEquals(treeMap.size(), 1);
        assertEquals("u3", treeMap.get(treeMap.firstKey()).first().getNome());
        
    }
    
    
    /**
     * Test of amigosNasProximidades method, of class Proximidades com o User 10.
     */
    @Test
    public void testAmigosNasProximidadesUserBIG() throws FileNotFoundException {
        System.out.println("##Teste de Amigos Nas Proximidades com ficheiros BIG##");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);
        
        Graph<Cidade, Distancia> grafoCidades = controlador.getRedeCidades().getGraph();
        AdjacencyMatrixGraph<Utilizador, Double> redeSocial = controlador.getRedeSocial().getMatrix();
        
        LinkedList<Utilizador> users = new LinkedList<>();
        Utilizador userTemp = null;
        
        for (Utilizador user: controlador.getUtilizadores()){
            users.add(user);
            if(user.getNome().equals("u3")){
                userTemp = user;
            }
        }
        
        int n = 1;
        
        System.out.println("USER 10 + N 1 - Número de amigo é 1");
        
        TreeMap<Cidade, TreeSet<Utilizador>> treeMap = Proximidades.amigosNasProximidades(users, grafoCidades, n, userTemp, redeSocial);
        
        assertEquals(treeMap.size(), 21);
        assertEquals("u3", treeMap.get(treeMap.firstKey()).first().getNome());
        
    }
    
}
