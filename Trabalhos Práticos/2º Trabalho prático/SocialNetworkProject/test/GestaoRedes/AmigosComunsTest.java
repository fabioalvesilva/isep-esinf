package GestaoRedes;

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
public class AmigosComunsTest {
    
 
    
    public AmigosComunsTest() {

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
    public void testAmigosComuns() throws FileNotFoundException {
        System.out.println("Test de amigos em comum com ficheiros SMALL");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(SMALLCOUNTRIESFILE);
        controlador.lerFronteiras(SMALLBORDERSFILE);
        controlador.lerUtilizadores(SMALLUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(SMALLRELATIONSHIPSFILE);

        TreeSet<Utilizador> userTopN = AmigosComuns.amigosComuns(2, controlador.getRedeSocial().getMatrix());
        
        assertEquals(userTopN.first().getNome(), "u31");
        System.out.println("O utilizador em comum quando o N = 2 deve ser " + userTopN.first().getNome());
    }
    
        /**
     * Test of amigosComuns method, of class AmigosComuns.
     */
    @Test
    public void testAmigosComunsBIG() throws FileNotFoundException {
        System.out.println("Test de amigos em comum com ficheiros BIG");
        
        Controlador controlador = new Controlador();
      
        controlador.lerPaises(BIGCOUNTRIESFILE);
        controlador.lerFronteiras(BIGBORDERSFILE);
        controlador.lerUtilizadores(BIGUSERSFILE);
        controlador.adicionarUtilizadores();
        controlador.lerRelacoes(BIGRELATIONSHIPSFILE);
        
        TreeSet<Utilizador> userTopN = AmigosComuns.amigosComuns(2, controlador.getRedeSocial().getMatrix());
        
        assertEquals(userTopN.size(), 36);
        System.out.println("O número de utilizadores em comum quando o N = 2 deve ser " + userTopN.size());
    }
    
}
