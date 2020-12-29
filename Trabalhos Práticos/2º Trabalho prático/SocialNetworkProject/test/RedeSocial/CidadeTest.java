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
public class CidadeTest {

    public CidadeTest() {

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
    public void testCriarCidade() {

        Cidade c1 = new Cidade("Lisboa", (double) 10, (double) 10);
        Cidade c2 = new Cidade("Lisboa", (double) 10, (double) 10);
        Cidade c3 = new Cidade("Moscovo", (double) 11, (double) 11);
        Utilizador u1 = new Utilizador("u1", 10, c1);
        Utilizador u2 = new Utilizador("u2", 10, c1);

        assertEquals(c1.getNome(), "Lisboa");
        assertEquals(c1.getLatitude(), (double) 10, 0.0);
        assertEquals(c1.getLongitude(), (double) 10, 0.0);
        c1.insertUtilizador(u1);
        c1.insertUtilizador(u2);
        assertEquals(c1.listaUtilizadoresSize(), 2);
        assertFalse(c1.equals(c3));
        assertTrue(c1.equals(c2));

    }

}
