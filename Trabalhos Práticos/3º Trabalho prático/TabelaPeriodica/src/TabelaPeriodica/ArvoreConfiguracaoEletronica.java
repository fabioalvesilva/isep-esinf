/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

import EstruturasArvores.*;
import EstruturasArvores.TextWord;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Fábio Silva
 */
public class ArvoreConfiguracaoEletronica extends TREE_WORDS {

    /**
     * Construtor
     */
    public ArvoreConfiguracaoEletronica() {

        new TREE_WORDS();
    }

    /**
     * Metodo inserir palavra
     * @param elemento
     */
    public void insertPalavra(TextWord elemento) {
        insert(elemento);
    }

    /**
     * Método que devolve o nr de ocurrencias de cada TextWord
     * @return Map<Integer, List<String>>
     */
    public Map<Integer, List<String>> getNOcurrenciasPalavras() {
        Map<Integer, List<String>> tMap = new TreeMap<>(Collections.reverseOrder());;
        tMap.putAll(getWordsOccurrences());
        tMap.remove(1); //remove Word Counts with 1;
        return tMap;

    }

}
