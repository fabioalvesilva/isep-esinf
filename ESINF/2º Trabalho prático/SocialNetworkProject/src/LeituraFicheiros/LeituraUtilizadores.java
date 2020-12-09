package LeituraFicheiros;

import RedeSocial.RedeCidades;
import RedeSocial.RedeSocial;
import RedeSocial.Utilizador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * Classe Leitura de Utilizadores
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class LeituraUtilizadores {
    
    private RedeSocial redeSocial;
    private RedeCidades redeCidades;
    private Set<Utilizador> utilizadores;
    
    /**
     * Construtor com parâmetros
     * 
     * @param redeCidades
     * @param utilizadores
     */
    public LeituraUtilizadores (RedeCidades redeCidades, Set<Utilizador> utilizadores){
        this.redeCidades = redeCidades;
        this.utilizadores = utilizadores;
    }
    
    /**
     * Método que para ler os Utilizadores através de um ficheiro.
     * Devolve um Set com os Utilizadores encontrados no ficheiro.
     * Adiciona o Utilizador à lista de Utilizadores da sua Cidade.
     * 
     * @return Set<Utilizador> utilizadores
     * @throws FileNotFoundException
     */
    public Set<Utilizador> lerUtilizadores(String usersFile) throws FileNotFoundException {
        
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(usersFile))) {
            
            while ((line = br.readLine()) != null){
                
                line =  line.replaceAll("\"", "");
                
                //Leitura e criação do objeto Utilizador
                String [] tempLine = line.split(",");
                String nome = tempLine[0];
                int idade = Integer.parseInt(tempLine[1]);
                String cidade = tempLine[2];
                
                Utilizador utilizador;
                
                if (redeCidades.getCidade(cidade) != null){
                    
                    utilizador = new Utilizador(nome, idade, redeCidades.getCidade(cidade));
                    
                    //Adiciona o utilizador à lista de utilizadores da cidade
                    redeCidades.getCidade(cidade).insertUtilizador(utilizador);
                    
                    utilizadores.add(utilizador);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return utilizadores;
    }
}
