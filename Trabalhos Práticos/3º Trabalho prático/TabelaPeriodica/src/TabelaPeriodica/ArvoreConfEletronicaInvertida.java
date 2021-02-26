/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.AVL;
import EstruturasArvores.BST;
import EstruturasArvores.TextWord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Rui Marinho e Fabio Silva
 */
public class ArvoreConfEletronicaInvertida extends BST<TextWord> {

    /**
     * Construtor
     */
    public ArvoreConfEletronicaInvertida() {

        new BST();
    }

    /**
     *
     * @param listaPalavras
     */
    public void insertPalavras(Map<Integer, List<String>> listaPalavras) {
        for (Integer i : listaPalavras.keySet()) {
            if (i > 2) { // so configs eletronicas com repeticoes acima de 2 
                List<String> tmpList = listaPalavras.get(i);
                for (String s : tmpList) {
                    insert(new TextWord(s, i));
                }
            }
        }
    }

    /**
     * Este método responde à alínea 2 c)
     *
     * @return HashMap<Integer, List<TextWord>>
     */
    public HashMap<Integer, List<TextWord>> elementosMaisDistantes() {

        HashMap<Integer, List<TextWord>> map = new HashMap<>();

        //Caminho Subtree Left 
        ArrayList<TextWord> left = longestPath(this.root.getLeft());

        //Caminho Subtree Right
        ArrayList<TextWord> right = longestPath(this.root.getRight());

        //Distancia
        Integer tamanho = left.size() + right.size(); // Tamanho left + tamanho right 

        ArrayList<TextWord> listaFim = new ArrayList<>();
        listaFim.add(left.get(left.size() - 1));//get folha left 
        listaFim.add(left.get(right.size() - 1));//get folha Right
        map.put(tamanho, listaFim);

        return map;

    }

    /**
     *
     * @param root
     * @return ArrayList<TextWord>
     */
    public ArrayList<TextWord> longestPath(Node<TextWord> root) {

        //Verifica se o root é null
        if (root == null) {
            ArrayList<TextWord> output = new ArrayList<>();
            return output;
        }

        // Chamada Recursiva à direita
        ArrayList<TextWord> right = longestPath(root.getRight());

        // Chamada Recursiva à direita
        ArrayList<TextWord> left = longestPath(root.getLeft());

        // Comparar o size das duas  ArrayList e insere de acordo com o elemnto currente 
        if (right.size() < left.size()) {
            left.add(root.getElement());
        } else {
            right.add(root.getElement());
        }

        // Trtorno da ArrayList 
        return (left.size() > right.size() ? left : right);
    }

    /**
     *
     */
    public void transformarArvoreBinaria() {

        int tamanhoArvore = this.size();
        int n = (int) log2(tamanhoArvore + 1);

        if (Math.pow(2, n) - 1 > tamanhoArvore) {
            n++;
        }

        Set<TextWord> listaDeElementos = new TreeSet<>();
        Set<String> elementosInseridos = new TreeSet<>();
        
        for (TextWord w : this.inOrder()) {
            listaDeElementos.add(w);
            elementosInseridos.add(w.getWord());
        }

        for (Integer key : this.nodesByLevel().keySet()) {
            if (key < this.height()) {

                int nrElementoPorNivelMax = (int) (Math.pow(2, key + 1));

                int nrElementosKey = this.nodesByLevel().get(key + 1).size();

                List<TextWord> listaTextWord = new ArrayList<>();

               

                listaTextWord = this.nodesByLevel().get(key);

                if (nrElementosKey != nrElementoPorNivelMax) {
                    for (TextWord w : listaTextWord) {
                        Node<TextWord> word = find(this.root(), w);

                        if (word != null) {
                            if (word.getLeft() == null) {

                                Node<TextWord> node = new Node(procurarTextWordLeft(listaDeElementos, w, elementosInseridos), null, null);
                                word.setLeft(node);
                                elementosInseridos.add(node.getElement().getWord());
                            }

                            if (word.getRight() == null) {

                                Node<TextWord> node = new Node(procurarTextWordRight(listaDeElementos, w, elementosInseridos), null, null);
                                word.setRight(node);
                                elementosInseridos.add(node.getElement().getWord());
                            }
                        }
                    }
                }
            }
        }

    }

    /**
     * Criar string para inserir na arvore num ramo à esquerda
     * @param listaDeElementos
     * @param palavra
     * @param elementosInseridos
     * @return
     */
    public TextWord procurarTextWordLeft(Set<TextWord> listaDeElementos, TextWord palavra, Set<String> elementosInseridos) {

        TextWord tmp = new TextWord(alterarStringLeft(palavra.getWord()), 1);

        while (elementosInseridos.contains(tmp.getWord())) {
            
                tmp = new TextWord(alterarStringLeft(tmp.getWord()), 1);
            }
        
        return tmp;
    }

    /**
     * Criar string para inserir na arvore num ramo à direita
     * @param listaDeElementos
     * @param palavra
     * @param elementosInseridos
     * @return
     */
    public TextWord procurarTextWordRight(Set<TextWord> listaDeElementos, TextWord palavra, Set<String> elementosInseridos) {

        TextWord tmp = new TextWord(alterarStringRight(palavra.getWord()), 1);

        while (elementosInseridos.contains(tmp.getWord())) {

            tmp = new TextWord(alterarStringRight(tmp.getWord()), 1);
        }

        return tmp;
    }

    /**
     * Altera a string
     * @param palavra
     * @return
     */
    public String alterarStringLeft(String palavra) {

        char ultimoChar = palavra.charAt(palavra.length() - 1);

        int valorChar = (int) ultimoChar;

        int novoValorChar = valorChar - 1;

        char novoChar = (char) novoValorChar;
        
        String tmp = (palavra.substring(0, palavra.length() - 1)) + novoChar;

        return tmp;
    }

    /**
     * Altera a String
     * @param palavra
     * @return
     */
    public String alterarStringRight(String palavra) {

        char ultimoChar = palavra.charAt(palavra.length() - 1);

        int valorChar = (int) ultimoChar;

        int novoValorChar = valorChar + 1;

        char novoChar = (char) novoValorChar;
        
        String tmp = palavra + novoChar;

        return tmp;
    }

    @Override
    protected Node<TextWord> find(Node<TextWord> node, TextWord elemento) {

        if (node == null) {
            return null;
        }
        if (node.getElement().getWord() == elemento.getWord()) {
            return node;
        }
        if (node.getElement().getWord().compareTo(elemento.getWord()) > 0) {
            return find(node.getLeft(), elemento);
        } else {
            return find(node.getRight(), elemento);
        }
    }

    private double log2(double n) {
        return Math.log(n) / Math.log(2);
    }

}
