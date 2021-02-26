/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeituraFicheiro;

import EstruturasArvores.TextWord;
import TabelaPeriodica.ArvoreConfEletronicaInvertida;
import TabelaPeriodica.ArvoreConfiguracaoEletronica;
import TabelaPeriodica.ArvoreMassaAtomica;
import TabelaPeriodica.ArvoreNrAtomico;
import TabelaPeriodica.ArvoreElemento;
import TabelaPeriodica.ArvoreSimbolo;
import TabelaPeriodica.Elemento;
import TabelaPeriodica.ElementoMassaAtomica;
import TabelaPeriodica.ElementoNrAtomico;
import TabelaPeriodica.ElementoNome;
import TabelaPeriodica.ElementoSimbolo;
import Util.ProjectUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Fábio Silva e Fábio Silva
 */
public class LeituraTabelaPeriodica {

    private ArvoreMassaAtomica arvoreMassaAtomica;
    private ArvoreNrAtomico arvoreNrAtomico;
    private ArvoreElemento arvoreElemento;
    private ArvoreSimbolo arvoreSimbolo;
    private ArvoreConfiguracaoEletronica arvoreConfEletronica;
    private ArvoreConfEletronicaInvertida arvoreConfElecInvertida;

    /**
     * Classe responsável pela leitura dos ficheiros
     */
    public LeituraTabelaPeriodica() {

        this.arvoreMassaAtomica = new ArvoreMassaAtomica();
        this.arvoreNrAtomico = new ArvoreNrAtomico();
        this.arvoreElemento = new ArvoreElemento();
        this.arvoreSimbolo = new ArvoreSimbolo();
        this.arvoreConfEletronica = new ArvoreConfiguracaoEletronica();
        this.arvoreConfElecInvertida = new ArvoreConfEletronicaInvertida();
    }

    /**
     * Método que para ler os elementos da tabela periodica através de um
     * ficheiro.
     *
     * @param ficheiro
     * @throws FileNotFoundException
     */
    public void lerElementos(String ficheiro) throws FileNotFoundException {

        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiro))) {

            br.readLine();

            while ((line = br.readLine()) != null) {

                line = line.replaceAll("\"", "");

                //Leitura e criação do objeto elemento
                String[] tempLine = line.trim().split(",");
                for (int i = 0; i < tempLine.length; i++) {
                    tempLine[i] = tempLine[i].trim();
                }

                int numeroAtomico = ProjectUtils.stringIsAnInteger(tempLine[0]);
                String elemento = tempLine[1];
                String simbolo = tempLine[2];
                Double pesoAtomico = ProjectUtils.isNumeric(tempLine[3]);
                Double massaAtomica = ProjectUtils.isNumeric(tempLine[4]);
                int periodo = ProjectUtils.stringIsAnInteger(tempLine[5]);
                int grupo = ProjectUtils.stringIsAnInteger(tempLine[6]);
                String fase = tempLine[7];
                String tipo = tempLine[9];
                String descobridor = tempLine[18];
                Integer ano = ProjectUtils.stringIsAnInteger(tempLine[19]);
                String configEletrao = tempLine[21];

                Elemento e = new Elemento(numeroAtomico, elemento, simbolo, pesoAtomico,
                        massaAtomica, periodo, grupo, fase, tipo, descobridor, ano,
                        configEletrao);

                splitConfiguracaoEletronica(configEletrao);

                arvoreMassaAtomica.insert(new ElementoMassaAtomica(e));
                arvoreNrAtomico.insert(new ElementoNrAtomico(e));
                arvoreElemento.insert(new ElementoNome(e));
                arvoreSimbolo.insert(new ElementoSimbolo(e));

            }

            arvoreConfElecInvertida.insertPalavras(arvoreConfEletronica.getNOcurrenciasPalavras());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    public ArvoreMassaAtomica getArvoreMassaAtomica() {
        return arvoreMassaAtomica;
    }

    /**
     *
     * @return
     */
    public ArvoreNrAtomico getArvoreNrAtomico() {
        return arvoreNrAtomico;
    }

    /**
     *
     * @return
     */
    public ArvoreElemento getArvoreElemento() {
        return arvoreElemento;
    }

    /**
     *
     * @return
     */
    public ArvoreSimbolo getArvoreSimbolo() {
        return arvoreSimbolo;
    }

    /**
     *
     * @return
     */
    public ArvoreConfiguracaoEletronica getArvoreConfiguracaoEletronica() {
        return arvoreConfEletronica;
    }

    /**
     *
     * @return
     */
    public ArvoreConfEletronicaInvertida getArvoreConfEletronicaInvertida() {
        return arvoreConfElecInvertida;
    }

    public void transformarArvoreBinaria() {

        arvoreConfElecInvertida.transformarArvoreBinaria();
    }

    private void splitConfiguracaoEletronica(String confEletronica) {
        confEletronica = confEletronica.trim();
        if (!confEletronica.isEmpty()) {
            StringBuilder sb = new StringBuilder(confEletronica);
            sb.insert(confEletronica.length(), " "); //Adicionar pelo index -1 quando 1 palavra 
            confEletronica = sb.toString();
            while (confEletronica.lastIndexOf(" ") != -1) {
                confEletronica = confEletronica.substring(0, confEletronica.lastIndexOf(" "));
                arvoreConfEletronica.insertPalavra(new TextWord(confEletronica, 1));
            }
        }

    }
}
