/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.stathis.week2;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Stathis
 */
public class Test {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        WordFrequencies wf = new WordFrequencies();
//        wf.tester();
//        CharactersInPlay cp = new CharactersInPlay();
//        cp.findAllCharacters();
//        cp.test();
//        cp.findMax();
//        cp.charactersWithNumParts(9, 16);
//        CodonCount cc = new CodonCount();
//        cc.CountDNA();
////        //cc.buildCodonMap(0, "CGTTCAAGTTCAA");
////        System.out.println("==========================================");
//        cc.buildCodonMap(1, "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC");
//        System.out.println("==========================================");
//        cc.buildCodonMap(2, "CGTTCAAGTTCAA");
//        cc.getMostCommonCodon();
        //cc.printCodonCounts(1, 2);


        WordsInFiles wf = new WordsInFiles();
        wf.buildWordFileMap();
//        wf.printMap();
////        int n = wf.maxNumber();
        ArrayList<String> listb = wf.wordsInNumFiles(4);
        System.out.println(listb.size());
        
//        wf.printFilesIn("tree");


    }
}
