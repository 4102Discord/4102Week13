import java.lang.*;
import java.util.*; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class User
{
    private int count;
    private int followers;  
    HashMap <String, User> userList = new HashMap<String, User>();  
    List<String> txt= new ArrayList<String>();	
    tweet t = new tweet(txt); 

    /**
     * Constructor for objects of class User
     */
    public User(List<String> text)
    {
        txt = text;       
        this.count = count;
        this.followers = followers; 
    }
    
    public int getCount (){
        return this.count;
    }
    
    public void setCount(int c){
        this.count = c;
    }
    
   	public int getFollower (){
        return this.followers;
    }
    
     public void setFollower (String c){
        this.followers = Integer.parseInt(c);
    }    

    /**
     * This methods splits each line of the text to get the user name and number of followers and add them into the user objects
     */
    public void getData()
    {
        String name ="";  	     
        String patternString1 = ".*\\[.*\\]\\s.*\\s\\d{0,}\\s\\d{0,}.*";    
        Pattern pattern = Pattern.compile(patternString1);
        String arr = ""; 
        String flw = "";
            for (int j = 0; j < txt.size(); j++){  
                Matcher matcher = pattern.matcher(txt.get(j));
                if(matcher.find()) {
                    name = matcher.group().split("\\[")[0].trim();					  
                    if (userList.get(name) == null) {
                        User u = new User(txt);                    
                        u.setCount(1);
                        arr = matcher.group().split("\\]\\s")[1].trim();  
                        String [] arr1 = arr.split(" ");
                        flw = flw = arr1[arr1.length-2];
                        u.setFollower(flw); 
                        userList.put(name,u);						
                    } 
                    else if (userList.get(name).getCount() >= 1) {
                        userList.get(name).setCount(userList.get(name).getCount()+1);						
                    }                    
                }               
            }         
            
    }
    
    /**
     *  This method finds the top n users who have tweeted the most related to the search string for the entire timeline 
 	 *	Write the ouput in the file "maxTweets.txt"
     */
    public void maxTweets(){
	try {
            FileWriter writer = new FileWriter("maxTweets.txt", true);        
            List<Integer> retweetCount = new ArrayList<Integer>();        
 			List<Integer> counts= new ArrayList<Integer>();
        	for (String key :userList.keySet()) {                  
             	counts.add(userList.get(key).getCount()); 
             	Collections.sort(counts, Collections.reverseOrder() );      
       		}         
        
       		writer.write("\nTop 10 users tweeted the most\r\n");           
        	List<String> list = new ArrayList<String>();     
            for (int i=0; i<10; i++){                   
                for (String key : userList.keySet()) {                   
                  	if ((userList.get(key)).getCount()== counts.get(i)){    
						if (list.size()>9) 
							break;    
					if (!list.contains(key))                    			
						list.add(key);                   			     
                  	} 						
                }     
            }

			for (int i = 0; i < list.size(); i++) {					
				writer.write(list.get(i)+" tweeted total "+ +counts.get(i)+" times\r\n"); 				
			}
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }    

	
    /**
     * This method finds the top n users who have the maximum followers
 	 * Write the ouput in the file "maxFollowers.txt"
     */
    public void maxFollowers(){
	try {
            FileWriter writer = new FileWriter("maxFollowers.txt", true);        
            List<Integer> followers= new ArrayList<Integer>();
        	List<String> list1 = new ArrayList<String>();     
       		for (String key :userList.keySet()) {                  
            	 followers.add(userList.get(key).getFollower()); 
             	Collections.sort(followers, Collections.reverseOrder());      
	        }                 
			writer.write("Top 10 users have the most followers\r\n");  	
  			 for (int i=0; i<10; i++){                   
                	for (String key : userList.keySet()) {                   
                  		if ((userList.get(key)).getFollower()== followers.get(i)){    
							if (list1.size()>9) 
								break;    
							if (!list1.contains(key))                    			
								list1.add(key);	                     			     
                  		} 						
                }     
            }

			for (int i = 0; i < list1.size(); i++) {					
					writer.write(list1.get(i)+" has total "+ followers.get(i)+" followers \r\n"); 				
			}
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
          } 
    }    	
}
