package LeituraFicheiros;

import RedeSocial.RedeSocial;
import RedeSocial.Utilizador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * Classe Leitura Relacoes
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class LeituraRelacoes {
    
    private RedeSocial redeSocial;
    private Set<Utilizador> utilizadores;
    
    /**
     * Construtor com parâmetros
     * 
     * @param redesocial
     * @param utilizadores
     */
    public LeituraRelacoes(RedeSocial redesocial, Set<Utilizador> utilizadores) {
       this.redeSocial = redesocial;
       this.utilizadores = utilizadores;
    }
    
    /**
     * Método que para ler as relações através de um ficheiro.
     */
    public void lerRelacoes(String relationshipsFile){
         
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(relationshipsFile))) {
            
            while ((line = br.readLine()) != null) {
                
                line =  line.replaceAll("\"", "");

                String [] tempLine = line.split(",");
                tempLine[1] = tempLine[1].trim();
                tempLine[0] = tempLine[0].trim();
                
                Utilizador u1 = null;
                Utilizador u2 = null;
                
                //Procurar o User e 
                for (Utilizador user : utilizadores){ 
                    
                    if(user.getNome().equals(tempLine[0])){
                        
                        u1 = user;
                    }
                    else if(user.getNome().equals(tempLine[1])){
                        
                        u2 = user;
                    }
                    if ((u1 != null) && (u2 != null) ) break;
                }
                
                    this.redeSocial.insertConexao(u1, u2);
            }
       

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
