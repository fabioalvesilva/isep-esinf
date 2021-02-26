/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaPeriodica;

/**
 * Classe Elemento
 *
 * @author Fábio Silva e Rui Marinho
 */
public class Elemento {

    private Integer numeroAtomico;
    private String elemento;
    private String simbolo;
    private Double pesoAtomico;
    private Double massaAtomica;
    private int periodo;
    private int grupo;
    private String fase;
    private String tipo;
    private String descobridor;
    private Integer ano;
    private String configEletrao;

    /**
     *
     * @param numeroAtomico
     * @param elemento
     * @param simbolo
     * @param pesoAtomico
     * @param massaAtomica
     * @param periodo
     * @param grupo
     * @param fase
     * @param tipo
     * @param descobridor
     * @param ano
     * @param configEletrao
     */
    public Elemento(int numeroAtomico, String elemento, String simbolo, Double pesoAtomico,
            Double massaAtomica, int periodo, int grupo, String fase, String tipo,
            String descobridor, Integer ano, String configEletrao) {

        this.numeroAtomico = numeroAtomico;
        this.elemento = elemento;
        this.simbolo = simbolo;
        this.pesoAtomico = pesoAtomico;
        this.massaAtomica = massaAtomica;
        this.periodo = periodo;
        this.grupo = grupo;
        this.fase = fase;
        this.tipo = tipo;
        this.descobridor = descobridor;
        this.ano = ano;
        this.configEletrao = configEletrao;
    }

    /**
     * Construtor vazio
     */
    public Elemento() {

        this.numeroAtomico = null;
        this.elemento = null;
        this.simbolo = null;
        this.pesoAtomico = null;
        this.massaAtomica = null;
        this.periodo = 0;
        this.grupo = 0;
        this.fase = null;
        this.tipo = null;
        this.descobridor = null;
        this.ano = 0;
        this.configEletrao = null;
    }

    /**
     * Método getNumeroAtomico()
     *
     * @return Integer
     */
    public Integer getNumeroAtomico() {
        return numeroAtomico;
    }

    /**
     * Método getElemento()
     *
     * @return String
     */
    public String getElemento() {
        return elemento;
    }

    /**
     * Método getSimbolo()
     *
     * @return String
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Método getPesoAtomico()
     *
     * @return Double
     */
    public Double getPesoAtomico() {
        return pesoAtomico;
    }

    /**
     * Método getMassaAtomica()
     *
     * @return Double
     */
    public Double getMassaAtomica() {
        return massaAtomica;
    }

    /**
     * Método getPeriodo()
     *
     * @return periodo
     */
    public int getPeriodo() {
        return periodo;
    }

    /**
     * Método getGrupo()
     *
     * @return int
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * Método getFase()
     *
     * @return String
     */
    public String getFase() {
        return fase;
    }

    /**
     * Método getTipo()
     *
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método getDescobridor()
     *
     * @return String
     */
    public String getDescobridor() {
        return descobridor;
    }

    /**
     * Método getAno()
     *
     * @return Integer
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * Método getConfigEletrao()
     *
     * @return String
     */
    public String getConfigEletrao() {
        return configEletrao;
    }

    /**
     * Método setNumeroAtomico
     *
     * @param numeroAtomico
     */
    public void setNumeroAtomico(Integer numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }

    /**
     * Método setElemento
     *
     * @param elemento
     */
    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    /**
     * Método setSimbolo
     *
     * @param simbolo
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * Método setPesoAtomico
     *
     * @param pesoAtomico
     */
    public void setPesoAtomico(Double pesoAtomico) {
        this.pesoAtomico = pesoAtomico;
    }

    /**
     * Método setMassaAtomica
     *
     * @param massaAtomica
     */
    public void setMassaAtomica(Double massaAtomica) {
        this.massaAtomica = massaAtomica;
    }

    /**
     * Método setPeriodo
     *
     * @param periodo
     */
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    /**
     * Método setGrupo
     *
     * @param grupo
     */
    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    /**
     * Método setFase
     *
     * @param fase
     */
    public void setFase(String fase) {
        this.fase = fase;
    }

    /**
     * Método setTipo
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método setDescobridor
     *
     * @param descobridor
     */
    public void setDescobridor(String descobridor) {
        this.descobridor = descobridor;
    }

    /**
     * Método setAno
     *
     * @param ano
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * Método setConfigEletrao
     *
     * @param configEletrao
     */
    public void setConfigEletrao(String configEletrao) {
        this.configEletrao = configEletrao;
    }

}
