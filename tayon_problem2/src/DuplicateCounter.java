import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DuplicateCounter
{
   private Map<String, Integer> uniqueWords;
  
   public DuplicateCounter(){
       uniqueWords = new HashMap<String,Integer>();
   }
  
   public void count(String dataFile){
      
       Scanner infile = null;
       try {
           infile = new Scanner(new File(dataFile));
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
           System.exit(0);
       }
       while(infile.hasNext()) {
           String word = infile.next().toLowerCase();
           Integer count = uniqueWords.get(word); 
           if(count == null)
               count = 1;
           else
               count = count + 1;
           uniqueWords.put(word, count);
       }
       infile.close();
   }
  
   public void write(String outputFile){
       
       try {
           PrintWriter outfile = new PrintWriter(new File(outputFile));
           for(String k : uniqueWords.keySet()) {
               outfile.println(k + " " + uniqueWords.get(k));
           }
           outfile.close();
           
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
           System.exit(0);
       }
   }
}
