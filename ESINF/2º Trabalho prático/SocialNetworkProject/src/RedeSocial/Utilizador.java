package RedeSocial;

import java.util.Objects;

/**
 * Classe Utilizador
 * 
 * @author Fábio Silva e Rui Marinho
 */
public class Utilizador implements Comparable {

    private String nome;
    private int idade;
    private Cidade cidade;
    private int nrAmigos;

    /**
     * Construtor com parâmetros
     * 
     * @param nome
     * @param idade
     * @param cidade
     */
    public Utilizador(String nome, int idade, Cidade cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.nrAmigos = 0;
    }

    /**
     * Devolve o nome do Utilizador
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve a Cidade do Utilizador
     * 
     * @return cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * Devolve o número de amigos do Utilizador
     * 
     * @return nrAmigos
     */
    public int getNrAmigos() {
        return nrAmigos;
    }

    /**
     * Incrementa o número de amigos do Utilizador
     */
    public void incrementNrAmigos() {
        this.nrAmigos = this.nrAmigos + 1;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilizador other = (Utilizador) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }
    
    /**
     * Método que compara objectos do mesmo tipo
     * 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Object o) {
        if(this.equals(o)) return 0;
        if(this.getClass().equals(o.getClass())){
        Utilizador u = (Utilizador) o;
        if (this.nrAmigos == u.nrAmigos) {
                return 0;
            } else if (this.nrAmigos > u.nrAmigos) {
                return 1;
            } else {
                return -1;
            }
        }
        return -1;
    }
}

    

