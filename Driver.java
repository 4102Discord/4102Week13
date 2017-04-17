import java.io.*;
import java.util.*;

/**
 * 
 */
public class Driver{    
    
   public static List<String> txt= new ArrayList<String>();    
   
    public static void main(String [] args)throws IOException {
     		
      try{
            //read the entire text into an arrayList
            FileInputStream fstream = new FileInputStream("noodle.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;             
            
            //replace " with space
            while ((strLine = br.readLine()) != null)   {                
                txt.add(strLine.replace("\""," ").trim());           
            }       
            in.close();        
        }    
        catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
      }      
       
	  tweet t = new tweet(txt); 
      t.getTweetData();
	  t.maxRetweet();
	  
      User u = new User(txt,t);
      u.getData();
      u.findUserTweetedTheMost();
	  u.findUserWithMaxFollower();
	  
   }
   
}