package GestaoRedes;

import MatrixGraph.AdjacencyMatrixGraph;
import RedeSocial.Utilizador;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Esta classe responde à alínea 2 do Enunciado.
 * 
 * @author Rui Marinho e Fabio Silva
 */
public class AmigosComuns { 

    /**
     * Método que responde à alínea 2.
     * Os amigos comuns entre os n utilizadores mais populares da rede.
     * A popularidade de um utilizador é dada pelo seu número de amizades.
     * 
     * @param n
     * @param matrix
     * @return TreeSet<Utilizador>
     */
    public static TreeSet<Utilizador> amigosComuns(int n, AdjacencyMatrixGraph<Utilizador, Double> matrix) {
        
        if (n <= 0){
            return null;
        }
        
        if (n > matrix.numVertices()){
            return null;
        }
       
        TreeSet<Utilizador> userFriendsSet = new TreeSet<>();
        TreeSet<Utilizador> userTopN = new TreeSet<>();

        for (Utilizador user : matrix.vertices()){
            
            if (userTopN.size() < n){
                userTopN.add(user);
            }
            
            if (userTopN.size() == n){
                if (userTopN.last().compareTo(user) == -1){
                    userTopN.remove(userTopN.last());
                    userTopN.add(user);
                }
            }
        }
        
        if (!userTopN.isEmpty()){
            userFriendsSet = new TreeSet<>((Collection<? extends Utilizador>) 
                    matrix.directConnections(userTopN.pollFirst()));
        }
        
        if (n == 1){
            return userFriendsSet;
        }
        
        while (!userTopN.isEmpty()){
            TreeSet<Utilizador> tmpSet = new TreeSet<>((Collection<? extends Utilizador>) 
                    matrix.directConnections(userTopN.pollFirst()));
            userFriendsSet.retainAll(tmpSet);
        }
        return userFriendsSet;
    }
}
