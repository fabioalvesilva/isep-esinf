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
import static Util.Constantes.*;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;
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
import javafx.util.Pair;

/**
 * Classe CaminhoTerresteTest que corresponde à alínea 6.
 *
 * @author Fábio Silva e Rui Marinho
 */
public class CaminhoTerresteTest {

    public CaminhoTerresteTest() {
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
     * Test de input invalido
     */
    @Test
    public void testCaminnhoTerrestreSmall() throws FileNotFoundException {
        System.out.println("Caminho Terrestre entre 2 cidades");

        Controlador controlador = new Controlador();

        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);

        //n cidades
        int n = 2;
        //TreeSet<Utilizador> users = controlador.getUtilizadores();
        Utilizador userTemp1 = null;
        Utilizador userTemp2 = null;
        Graph<Cidade, Distancia> graph = controlador.getRedeCidades().getGraph();
        AdjacencyMatrixGraph<Utilizador, Double> matrix = controlador.getRedeSocial().getMatrix();
        LinkedList<Cidade> caminho = new LinkedList<>();
        Double distancia = (double) 0;

        n = 2;
        for (Utilizador user : controlador.getUtilizadores()) {
            if (user.getNome().equals("u3")) {
                userTemp1 = user;
            }
            if (user.getNome().equals("u33")) {
                userTemp2 = user;
            }
        }
        LinkedList<Pair<Cidade, Double>> list = CaminhoTerrestre.caminhoTerrestre(graph, matrix, n, userTemp1, userTemp2);
        assertEquals(userTemp1.getCidade(), list.getFirst().getKey());
        assertEquals(userTemp2.getCidade(), list.getLast().getKey());
        System.out.println("Caminho Small " + list.getFirst().getValue());
        assertEquals((Double) 14381.929999999998, list.getFirst().getValue());

    }

    //u353,19,viena
    //u354,19,zagreb
    @Test
    public void testCaminnhoTerrestreBig() throws FileNotFoundException {
        System.out.println("Caminho Terrestre entre 2 cidades");

        Controlador controlador = new Controlador();

        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);

        //n cidades
        int n = 2;
        //TreeSet<Utilizador> users = controlador.getUtilizadores();
        Utilizador userTemp1 = null;
        Utilizador userTemp2 = null;
        Graph<Cidade, Distancia> graph = controlador.getRedeCidades().getGraph();
        AdjacencyMatrixGraph<Utilizador, Double> matrix = controlador.getRedeSocial().getMatrix();
        LinkedList<Cidade> caminho = new LinkedList<>();
        Double distancia = (double) 0;

        n = 2;
        for (Utilizador user : controlador.getUtilizadores()) {
            if (user.getNome().equals("u445")) {
                userTemp1 = user;
            }
            if (user.getNome().equals("u435")) {
                userTemp2 = user;
            }
        }
        LinkedList<Pair<Cidade, Double>> list = CaminhoTerrestre.caminhoTerrestre(graph, matrix, n, userTemp1, userTemp2);
        assertEquals(userTemp1.getCidade(), list.getFirst().getKey());
        assertEquals(userTemp2.getCidade(), list.getLast().getKey());
        assertEquals((Double) 14549.61, list.getFirst().getValue());

    }

    @Test
    public void testInputInvalidoCaminnhoTerrestre() throws FileNotFoundException {
        System.out.println("Input invalido ");

        Controlador controlador = new Controlador();

        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);
        Graph<Cidade, Distancia> graph = controlador.getRedeCidades().getGraph();
        AdjacencyMatrixGraph<Utilizador, Double> matrix = controlador.getRedeSocial().getMatrix();

        LinkedList<Pair<Cidade, Double>> list = CaminhoTerrestre.caminhoTerrestre(graph, matrix, 1, null, null);
        assertEquals(null, list);
    }

    @Test
    public void testCaminnhoTerrestreImpossivel() throws FileNotFoundException {
        System.out.println("Input invalido ");

        Controlador controlador = new Controlador();

        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);

        Graph<Cidade, Distancia> graph = controlador.getRedeCidades().getGraph();
        AdjacencyMatrixGraph<Utilizador, Double> matrix = controlador.getRedeSocial().getMatrix();
        Utilizador userTemp1 = null;
        Utilizador userTemp2 = null;
        for (Utilizador user : controlador.getUtilizadores()) {
            if (user.getNome().equals("u530")) {
                userTemp1 = user;
            }
            if (user.getNome().equals("u598")) {
                userTemp2 = user;
            }
        }

        LinkedList<Pair<Cidade, Double>> list = CaminhoTerrestre.caminhoTerrestre(graph, matrix, 10, userTemp1, userTemp2);
        assertEquals(null, list);
    }

    @Test
    public void testCaminnhoTerrestreParaEleMesmo() throws FileNotFoundException {
        System.out.println("Input invalido ");

        Controlador controlador = new Controlador();

        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);

        Graph<Cidade, Distancia> graph = controlador.getRedeCidades().getGraph();
        AdjacencyMatrixGraph<Utilizador, Double> matrix = controlador.getRedeSocial().getMatrix();
        Utilizador userTemp1 = null;
        Utilizador userTemp2 = null;
        for (Utilizador user : controlador.getUtilizadores()) {
            if (user.getNome().equals("u530")) {
                userTemp1 = user;
            }
        }

        LinkedList<Pair<Cidade, Double>> list = CaminhoTerrestre.caminhoTerrestre(graph, matrix, 10, userTemp1, userTemp1);
        assertEquals(null, list);
    }

}
