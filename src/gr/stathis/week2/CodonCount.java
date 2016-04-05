package gr.stathis.week2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stathis
 */
import edu.duke.FileResource;
import java.util.*;

public class CodonCount {

    private HashMap<String, Integer> recordsMap;

    public void CountDNA() {
        recordsMap = new HashMap<>();

    }

    public void buildCodonMap(int start, String dna) {
        recordsMap.clear();
        dna = dna.toUpperCase();
        FileResource fr = new FileResource();
        int dnaLength = 0;
        for (String word : fr.words()) {
            String trimWord = word.trim().toUpperCase();
            //it is possible that trimWord.length goes OutOfBound because cant be always be %3=0
            if(dna.length()%3 == 0){
                dnaLength = dna.length();
            }
            if(dna.length()%3 == 1){
                dnaLength = dna.length()-1;
            }
            if(dna.length()%3 == 2){
                dnaLength = dna.length()-2;
            }
            for (int i = start; i < (dnaLength - start); i += 3) {
                String codon = trimWord.substring(i, i + 3);//care that i+3 goes out of bounds
                if (!recordsMap.containsKey(codon)) {
                    recordsMap.put(codon, 1);
                } else {
                    recordsMap.put(codon, recordsMap.get(codon) + 1);
                }
            }
        }
        for(String w : recordsMap.keySet()){
            int value = recordsMap.get(w);
            System.out.println(w+"\t"+value);
        }
        System.out.println("The size of unique codons is: "+recordsMap.size());
    }
    
    public void getMostCommonCodon(){
        int max = 0;
        String pCodon = "";
        if(recordsMap.isEmpty()){
            System.out.println("The HashMap is empty");
        }
        else{
            for(String w : recordsMap.keySet()){
               int current = recordsMap.get(w);
               if(current > max){
                   max = current;
                   //pCodon = w;
               }
            }
            
        }
        //System.out.println("The most common codon is: " + pCodon + " with "+ max + " times");
        for(String s : recordsMap.keySet()){
            if(recordsMap.containsValue(max)){
                System.out.println("The most common codon is: " + s +" with "+ max + " times!");
            }
        }
    }
    
    public void printCodonCounts(int start,int end){
        for(String w : recordsMap.keySet()){
            if((recordsMap.get(w)>=start) &&(recordsMap.get(w)<=end)){
                System.out.println(w +"\t"+recordsMap.get(w));
            }
        }
        
    }
}
