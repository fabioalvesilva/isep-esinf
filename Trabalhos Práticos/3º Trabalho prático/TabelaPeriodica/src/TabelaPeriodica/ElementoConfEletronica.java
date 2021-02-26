/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

/**
 * Elemento Configuração Eletronica
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ElementoConfEletronica implements Comparable<ElementoConfEletronica> {

    private Elemento elemeto;

    /**
     * Construtor
     *
     * @param elemento
     */
    public ElementoConfEletronica(Elemento elemento) {

        this.elemeto = elemento;
    }

    /**
     * Construtor vazio
     */
    public ElementoConfEletronica() {

        this.elemeto = new Elemento();
    }

    @Override
    public int compareTo(ElementoConfEletronica o) {
        return this.elemeto.getConfigEletrao().compareTo(o.elemeto.getConfigEletrao());
    }

}
