/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.stathis.week2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Stathis
 */
public class WordsInFiles {
    private HashMap<String,ArrayList<String>> mapWord;
    private ArrayList<String> fileNamesList;
    
    public WordsInFiles() {
        mapWord = new HashMap<String, ArrayList<String>>();
        fileNamesList = new ArrayList<String>();
    }
    /**
     * This method should add all the words from f into the map. If a word is not in
     * the map, then you must create a new ArrayList of type String with this word, 
     * and have the word map to this ArrayList. If a word is already in the map, 
     * then add the current filename to its ArrayList, unless the filename is already
     * in the ArrayList.
     * @param f 
     */
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String nameTxt  = f.getName(); //we need it for the key value of the HashMap
        for(String s : fr.words()){
            String trimWord = s;
            if(!mapWord.containsKey(trimWord)){
                fileNamesList = new ArrayList<>();
                fileNamesList.add(trimWord);
                mapWord.put(trimWord, fileNamesList);
            }
            else{
                fileNamesList = mapWord.get(trimWord);
                if(fileNamesList.contains(trimWord)){
                    fileNamesList.add(nameTxt);
                    mapWord.put(trimWord, fileNamesList);
                }
                else{
                    fileNamesList.add(trimWord);
                    mapWord.put(trimWord, fileNamesList);
                }
            }
            
        }
        
    }
    /**
     * This void method named buildWordFileMap that has no parameters. This method
     * first clears the map, and then uses a DirectoryResource to select a group of files. 
     * For each file, it puts all of its words into the map by calling the method 
     * addWordsFromFile. The remaining methods to write all assume that 
     * the HashMap has been built.
     */
    public void buildWordFileMap(){
        mapWord.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            addWordsFromFile(f);
            
        }
         
    } 
    
    public void printMap(){
        for(String s : mapWord.keySet()){ 
            //ArrayList<String> list = new ArrayList<String>();
            System.out.println("Key '"+ s + "' Values: ");
            fileNamesList = mapWord.get(s);
            for(int i = 0; i<fileNamesList.size(); i++){
                String w = fileNamesList.get(i);
                System.out.println(w + ", ");
            }
            System.out.println("==============================");
        }
    }
    /**
     * This method maxNumber that has no parameters. This method returns the
     * maximum number of files any word appears in, considering all words 
     * from a group of files. In the example above, there are four files considered. 
     * No word appears in all four files. Two words appear in three of the files, 
     * so maxNumber on those four files would return 3. This method assumes that 
     * the HashMap has already been constructed.
     * @return 
     */
    public Integer maxNumber(){
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(String s: mapWord.keySet()){
             list = mapWord.get(s);
            int times = list.size(); //doesnt count from 0
            map.put(s, times);
        }
        Map.Entry<String,Integer> maxEntry = null;
        for(Map.Entry<String, Integer> ent : map.entrySet()){
            if( (maxEntry == null) || (ent.getValue() > maxEntry.getValue()) ){
                maxEntry = ent;
            }
        }
        return maxEntry.getValue(); 
    }
    /**
     * This method returns an ArrayList of words that appear in exactly number files. 
     * In the example above, the call wordsInNumFiles(3) would return an ArrayList with the
     * words “cats” and “and”, and the call wordsInNumFiles(2) would return an ArrayList
     * with the words “love”, “are”, and “dogs”, all the words that appear in exactly two files.
     * @param number
     * @return ArrayList
     */
    public ArrayList<String>  wordsInNumFiles(int number){
        ArrayList<String> listWords = new ArrayList<String>();
        for(Map.Entry<String, ArrayList<String>> ent : mapWord.entrySet()){
            String w = ent.getKey();
            int numb = ent.getValue().size();
            if(numb == number){
                listWords.add(w);
            } 
        }
        return listWords;
        
    }
    
    public void printFilesIn(String word){
        ArrayList<String> lista = new ArrayList<>();
        for(String s : mapWord.keySet()){
            if(s.equals(word)){
                lista = mapWord.get(s);
                //lista.size();
                System.out.print("The word: " + s + " appers at files: ");
                for(int i = 0; i<lista.size(); i++){
                    String s3 = lista.get(i);
                    System.out.print(s3 + ", ");
                }
            }
        }
    }
}
