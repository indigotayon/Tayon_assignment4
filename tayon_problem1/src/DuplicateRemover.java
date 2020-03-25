import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

public class DuplicateRemover {
	   private Set<String> uniqueWords;
	   
	   public void remove(String dataFile)
	   {
	       String word;
		   uniqueWords = new HashSet<String>();
		
			File f = new File(dataFile);
			   try {
				Scanner sc = new Scanner(f); 
				while(sc.hasNext())
				{
					word=sc.next();
					uniqueWords.add(word.toLowerCase());
				}
				sc.close();
			}
			catch (Exception e) {
				System.out.println("Failed to make new Scanner"); 
				System.exit(0);
			}
	       
	      
	      
	   }
	  
	   
	   public void write(String outputFile) 
	   {
			File f;
			FileWriter fw = null;

			f = new File(outputFile);
			
			if(!f.exists()) {
				try {
					f.createNewFile(); }
				catch (Exception e) {
					System.out.println("Failed to make new File"); 
					System.exit(0);
				}
			}
			try {
				fw=new FileWriter(f,false); }
			catch (Exception e) {
				System.out.println("Failed to make new File Writer"); 
				System.exit(0);
			}

			Iterator itr=uniqueWords.iterator();

			while(itr.hasNext())
			{
				String str=(String)itr.next();
				try {
						fw.write(str+"\n"); }
				catch (Exception e) {
					System.out.println("Failed to write to file"); 
					System.exit(0);
				}     
			}
			try {
				fw.close(); }
			catch (Exception e) {
				System.out.println("Failed to close file");
				System.exit(0);
			}
			System.out.println("Data Written to File");
	   }
	}

