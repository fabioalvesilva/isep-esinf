package RedeSocial;

import GestaoRedes.*;
import LeituraFicheiros.Controlador;
import MatrixGraph.AdjacencyMatrixGraph;
import RedeSocial.Utilizador;
import java.io.FileNotFoundException;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static Util.Constantes.*;

/**
 * Classe AmigosComunsTest que corresponde à alínea 2.
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class PaisTest {
    
 
    
    public PaisTest() {

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
     * Test of amigosComuns method, of class AmigosComuns.
     */
    @Test
    public void testCriarPais() {

        Cidade c1 = new Cidade("Lisboa", (double) 10, (double) 10);
        Cidade c2 = new Cidade("Lisboa", (double) 10, (double) 10);
        Cidade c3 = new Cidade("Moscovo", (double) 11, (double) 11);
        Utilizador u1 = new Utilizador("u1", 10, c1);
        Utilizador u2 = new Utilizador("u2", 10, c1);
        Distancia d1 = new Distancia((double) 10, c1, c3);
        
        Pais p = new Pais("Portugal", c1.getNome(), "Europa", 11, 10, 10);
        Pais p2 = new Pais("Russia", "Moscovo", "Europa", 12, 11, 11);

        assertEquals(d1.getDistancia(), (double) 10, 0.0);
        assertEquals(c1.getLongitude(), (double) 10, 0.0);
        assertEquals(p.getNome(),"Portugal");

    }
    
}
