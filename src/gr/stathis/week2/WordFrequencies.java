package gr.stathis.week2;

/**
 *
 * @author Stathis
 * @author Duke Software Team
 */

/**
 * Find out how many times each word occurs, and
 * in particular the most frequently occurring word.
 * 
 */

import edu.duke.FileResource;
import java.util.ArrayList;

public class WordFrequencies
        
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies(ArrayList<String> myWords, ArrayList<Integer> myFreqs) {
        this.myWords = myWords;
        this.myFreqs = myFreqs;
    }
    
    
    

    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        //The java.util.ArrayList.clear() method removes all of the elements from this list.
        //The list will be empty after this call returns.
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        
        for(String s : resource.words()){//every word add without the "," "." etc
            s = s.toLowerCase();
            int index = myWords.indexOf(s); //found the index based on s element, same index is both ArrayLists
            if (index == -1){ // -1 not found the element at myWords 
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);//we link the two ArrayLists
                myFreqs.set(index,freq+1);
            }
        }
    }

    public void tester(){
        findUnique();
        System.out.println("Number of unique words: "+myWords.size());
        for (int i = 0; i<myWords.size(); i++){
            
            System.out.println(myFreqs.get(i) +" " +  myWords.get(i));
        }
        int index = findMax();
        System.out.println("The word that occurs most often and its count are: "+myWords.get(index)+" "+myFreqs.get(index));
    }
    
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    
            
}

