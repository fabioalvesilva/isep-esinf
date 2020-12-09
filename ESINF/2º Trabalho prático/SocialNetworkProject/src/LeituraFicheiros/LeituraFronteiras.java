package LeituraFicheiros;

import RedeSocial.Distancia;
import RedeSocial.Pais;
import RedeSocial.RedeCidades;
import Util.Utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

/**
 * Classe Leitura de Fronteiras
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class LeituraFronteiras {

    private RedeCidades redeCidades;
    private Set<Pais> listaPaises;

    /**
     * Construtor com parâmetros
     * 
     * @param redeCidades
     * @param paises
     */
    public LeituraFronteiras(RedeCidades redeCidades, Set<Pais> paises) {
        
        this.redeCidades = redeCidades;
        this.listaPaises = paises;
    }
    
    /**
     * Método que para ler as fronteiras através de um ficheiro.
     */
    public void lerFronteiras (String bordersFile){
         
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(bordersFile))) {
            
            while ((line = br.readLine()) != null) {
                
                line =  line.replaceAll("\"", "");

                String [] tempLine = line.split(",");
                tempLine[1] = tempLine[1].trim();
                
                Pais tmpPais = null;
                Pais tmpPaisAdj = null;
                
                //Procurar o País e o País Adjacente
                for (Pais pais : listaPaises){
                    if(pais.getNome().equalsIgnoreCase(tempLine[0])){
                        
                        tmpPais = pais;
                    }
                    
                    if(pais.getNome().equalsIgnoreCase(tempLine[1])){
                        
                        tmpPaisAdj = pais;
                    }
                }
                
                double lat1 = tmpPais.getCapital().getLatitude();
                double lat2 = tmpPaisAdj.getCapital().getLatitude();
                double lon1 = tmpPais.getCapital().getLongitude();
                double lon2 = tmpPaisAdj.getCapital().getLongitude();
                
                //Calcula a distancia entre duas cidades      
                Double distancia = Utils.distance(lat1,lon1,lat2,lon2);
                
                //Criar o Edge
                Distancia edge = new Distancia(distancia, tmpPais.getCapital(), 
                           tmpPaisAdj.getCapital());
                        
                //Adicionar a Cidade adjacente à lista de Cidades adjacentes
                redeCidades.insertDistancia(edge);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
