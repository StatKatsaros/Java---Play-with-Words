/*
 * Write a program to print out the main characters in one of Shakespeare’s plays, 
 * those with the most speaking parts. You should identify a speaking part by reading 
 * the file line-by-line and finding the location of the first period on the line. 
 * Then you will assume that everything up to the first period is the name of a character 
 * and count how many times that occurs in the file. You will only print those characters 
 * that appear more often than others. Notice our method is somewhat error prone. 
 * For example, a period is also used to indicate the end of a sentence. 
 * By printing out only those characters that appear a lot, we will get 
 * rid of most of the errors. Periods that indicate the end of a sentence 
 * will likely be a unique phrase so you won’t print that as it would just occur once or maybe twice.
 */
package gr.stathis.week2;

import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Stathis
 */
public class CharactersInPlay {

    private ArrayList<String> nameCharacters;
    private ArrayList<Integer> CharFreqs;

    public CharactersInPlay() {
        nameCharacters = new ArrayList<String>();
        CharFreqs = new ArrayList<Integer>();
    }

    public void update(String person) {
        int index = nameCharacters.indexOf(person);
        //personTrim = personTrim.toLowerCase();
        if (index == -1) {
            nameCharacters.add(person);
            CharFreqs.add(1);
//            System.out.println(person + " PositionOfnameCharacters: " + nameCharacters.indexOf(person) + 
//                    " PositionOfCharFreqs: " );

        } 
        else {
            int freqs = CharFreqs.get(index);
            CharFreqs.set(index, freqs + 1);
//            System.out.println( person + " PositionOfnameCharacters: " + index + " having value: "
//            + nameCharacters.get(index) + " ValueOfCharFreqs: " + freqs);
        }


    }
    /**
     * opens a file, and reads the file linebyline.
     * For each line, if there is a period on the line, extract the possible name of the
     * speaking part, and call update to count it as an occurrence for this person. 
     * Make sure you clear the appropriate instance variables before each new file.
     */
    public void findAllCharacters(){
        FileResource source = new FileResource();
        for(String s : source.lines()){
            StringBuilder sb = new StringBuilder();
            int index = s.indexOf(".");
            if(index == -1){
                sb.setLength(0); //clear it
                sb.trimToSize();
                //System.out.println("no . found at this line");
            }
            else{//there is '.'
                sb.append(s, 0, index);
                //System.out.println(sb.toString());
            }
            update(sb.toString().trim());
            sb.setLength(0);
            sb.trimToSize();
            
                
            
        }
    }
    
    public void test(){
        if(nameCharacters.contains("")){
            int index = nameCharacters.indexOf("");
            nameCharacters.remove("");
            CharFreqs.remove(index);
                    
        }
        
        for(int i = 0; i<nameCharacters.size(); i++){
            //System.out.print("Index "+ i +" nameCharacters: " + "<<" + nameCharacters.get(i)+ ">>");
            //System.out.println(" CharFreqs: " + CharFreqs.get(i));
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){//checkit and with toLowerChar()
        if(nameCharacters.contains("")){
            int index = nameCharacters.indexOf("");
            nameCharacters.remove("");
            CharFreqs.remove(index);
                    
        }
        if (num1 <= num2){
            for(int i = 0; i<nameCharacters.size(); i++){
                if((CharFreqs.get(i) >= num1) && ((CharFreqs.get(i) <= num2))){
                    System.out.print("Index "+ i +" nameCharacters: " + "<<" + nameCharacters.get(i)+ ">>");
                    System.out.println(" CharFreqs: " + CharFreqs.get(i));
                }
            }
        }
        else{
           for(int i = 0; i<nameCharacters.size(); i++){
                if((CharFreqs.get(i) <= num1) && ((CharFreqs.get(i) >= num2))){
                    System.out.print("Index "+ i +" nameCharacters: " + "<<" + nameCharacters.get(i)+ ">>");
                    System.out.println(" CharFreqs: " + CharFreqs.get(i));
                }
            } 
        }
    }
    
    public int findMax(){
        int max = CharFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < CharFreqs.size(); k++){
            if (CharFreqs.get(k) > max){
                max = CharFreqs.get(k);
                maxIndex = k;
            }
        }
        //System.out.println("At " + maxIndex + " nameCharacters: <<" + nameCharacters.get(maxIndex) + ">> " 
        //        + CharFreqs.get(maxIndex) + " times." );
        return maxIndex;
    }
    
}
