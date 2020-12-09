package RedeSocial;


import RedeSocial.Utilizador;
import RedeSocial.CidadeTest;
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
public class UtilizadorTest {
    
 
    
    public UtilizadorTest() {

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
    public void testCriarUtilizador()  {
     
     Cidade c = new Cidade("Lisboa", (double) 10, (double) 10);
     
     Utilizador u1 = new Utilizador("u1", 10, c);
     Utilizador u2 = new Utilizador("u1", 10, c);
     assertEquals(u1.getNome(), "u1");
     assertEquals(u1.getNrAmigos(), 0);
    u1.incrementNrAmigos();
    assertEquals(u1.getNrAmigos(), 1);
        assertTrue(u1.equals(u2));
        

    }
    
 
    
}
