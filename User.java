import java.lang.*;
import java.util.*; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;

/**
 * This class read data from the file and create record of each user
 */
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
    public User(List<String> text, tweet t1)
    {
        txt = text;
        t = t1;
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
   
    public String toString(){
        return("Followers  "+this.followers +" Counts  "+ this.count);
       }   
    
    /**
     * 
     */
    public void getData()
    {
        String name ="";
        String date = "";        
        String patternString1 = ".*\\[.*\\]\\s.*\\s\\d{0,}\\s\\d{0,}.*";    
        Pattern pattern = Pattern.compile(patternString1);
        String arr = ""; 
        String flw = "";
            for (int j = 0; j < txt.size(); j++){  
                Matcher matcher = pattern.matcher(txt.get(j));
                if(matcher.find()) {
                    name = matcher.group().split("\\[")[0].trim();                
                    if (userList.get(name) == null) {
                        User u = new User(txt,t );                    
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
            /*
            for (String key :userList.keySet()) {                   
                   System.out.printf("%-30s%-30s\n",key,userList.get(key));                   
                }
            */      
    }
    
    /**
     * Find top 3 users tweeted the most
     */
    public void findUserTweetedTheMost(){
        List<Integer> counts= new ArrayList<Integer>();
        for (String key :userList.keySet()) {                  
             counts.add(userList.get(key).getCount()); 
             Collections.sort(counts);      
        }         
        //System.out.println(counts);
        //System.out.println(counts.size());
        //System.out.println(Collections.max(counts)); 
        
        System.out.println("\nTop 3 users tweeted the most");     
         for (String key : userList.keySet()) {                  
                if ((userList.get(key)).getCount()== counts.get(counts.size()-1)){                
                   System.out.printf("%-30s%-30s\n",key,userList.get(key).getCount());                  
                }

                 if ((userList.get(key)).getCount()== counts.get(counts.size()-2)){                
                   System.out.printf("%-30s%-30s\n",key,userList.get(key).getCount());                  
                }

                 if ((userList.get(key)).getCount()== counts.get(counts.size()-3)){                
                   System.out.printf("%-30s%-30s\n",key,userList.get(key).getCount());                             
                }

        }
    }
    
    /**
     * Find top 3 users with max followers
     */
    public void findUserWithMaxFollower(){
        List<Integer> followers= new ArrayList<Integer>();
        
        for (String key :userList.keySet()) {                  
             followers.add(userList.get(key).getFollower()); 
             Collections.sort(followers);      
        }         
        
        //System.out.println(followers);
        //System.out.println(followers.size());
        //System.out.println(Collections.max(counts));   
        
        System.out.println("\nTop 3 users have the most followers");         
         for (String key : userList.keySet()) {                  
                if ((userList.get(key)).getFollower()== followers.get(followers.size()-1)){                
                   System.out.printf("%-30s%-30s\n",key,userList.get(key).getFollower());                   
                }

                 if ((userList.get(key)).getFollower()== followers.get(followers.size()-2)){                
                   System.out.printf("%-30s%-30s\n",key,userList.get(key).getFollower());                   
                }

                 if ((userList.get(key)).getFollower()== followers.get(followers.size()-3)){                
                   System.out.printf("%-30s%-30s\n",key,userList.get(key).getFollower());                   
                }

        }
    }
}
