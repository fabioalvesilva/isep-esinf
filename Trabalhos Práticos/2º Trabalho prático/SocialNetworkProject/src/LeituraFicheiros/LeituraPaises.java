package LeituraFicheiros;

import RedeSocial.Pais;
import RedeSocial.RedeCidades;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * Classe Leitura de Paises
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class LeituraPaises {
   
    private RedeCidades redeCidades;
    private Set<Pais> listaPaises;
    
    /**
     * Construtor com parâmetros
     * 
     * @param redeCidades
     * @param listaPaises
     */
    public LeituraPaises (RedeCidades redeCidades, Set<Pais> listaPaises){
        
        this.redeCidades = redeCidades;
        this.listaPaises = listaPaises;
        
    }
    
    /**
     * Método que para ler os países através de um ficheiro.
     * 
     * @throws FileNotFoundException
     */
    public void lerPaises(String countriesFile) throws FileNotFoundException {
        
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(countriesFile))) {
            
            while ((line = br.readLine()) != null){
                
                line =  line.replaceAll("\"", "");
                
                //Leitura e criação dos objetos Pais e Cidade
                String [] tempLine = line.split(",");
                tempLine[0] = tempLine[0].trim();
                tempLine[1] = tempLine[1].trim();
                tempLine[2] = tempLine[2].trim();
                tempLine[3] = tempLine[3].trim();
                tempLine[4] = tempLine[4].trim();
                tempLine[5] = tempLine[5].trim();
                
                String nomePais = tempLine[0];
                String continente = tempLine[1];
                double populacao = Double.parseDouble(tempLine[2]);
                String capital = tempLine[3];
                double latitude = Double.parseDouble(tempLine[4]);
                double longitude = Double.parseDouble(tempLine[5]);
                
                Pais pais = new Pais (nomePais, capital, continente, populacao, latitude, longitude);
                
                //Adicionar a cidade do pais na redeCidades
                redeCidades.insertCidade(pais.getCapital());
                
                listaPaises.add(pais);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
