/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

/**
 * Elemento Massa Atomica
 *
 * @author Fábio Silva e Rui Marinho
 */
public class ElementoMassaAtomica implements Comparable<ElementoMassaAtomica> {

    private Elemento elemeto;

    /**
     * Construtor
     *
     * @param elemento
     */
    public ElementoMassaAtomica(Elemento elemento) {

        this.elemeto = elemento;
    }

    /**
     * Construtor Vazio
     */
    public ElementoMassaAtomica() {

        this.elemeto = new Elemento();
    }

    /**
     * Método getElemento()
     *
     * @return Elemento
     */
    public Elemento getElemento() {
        return this.elemeto;
    }

    /**
     * Método getFase()
     *
     * @return String
     */
    public String getFase() {
        return getElemento().getFase();
    }

    /**
     * Método getTipo()
     *
     * @return String
     */
    public String getTipo() {
        return getElemento().getTipo();
    }

    @Override
    public int compareTo(ElementoMassaAtomica o) {
        return this.elemeto.getMassaAtomica().compareTo(o.elemeto.getMassaAtomica());
    }

    @Override
    public String toString() {
        return "ElementoMassaAtomica{" + "elemeto=" + elemeto + '}';
    }

}
