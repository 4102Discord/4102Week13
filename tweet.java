import java.lang.*;
import java.util.*; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
/**
 * 
 */
public class tweet
{
    private String tweetContent;
    private String date;
    private int retweet;
    HashMap <String, tweet> tweetList = new HashMap<String, tweet>();  
    List<String> txt= new ArrayList<String>();
    
    /**
     * Constructor for objects of class tweet
     */
    public tweet(List<String> text)
    {
        txt = text;
        this.date = date;
        this.retweet = retweet;        
    }

     public int getRetweet (){
        return this.retweet;
    }
    
     public void setRetweet (String c){
        this.retweet = Integer.parseInt(c);
    }
    
    public String getDate (){
        return this.date;
    }
    
     public void setDate (String c){
        this.date = c;
    }
    
     public void setTweetContent (String c){
        this.tweetContent = c;
    }
    
     public String getTweetContent (){
        return this.tweetContent;
    }
    
     public String toString(){
        return("       Retweet  "+this.retweet +" Date  "+ this.date);
       }   
             
     /**
     * 
     */
    public void getTweetData()
    {       
        String date = "";
        String tweetContent = "";        
        String rt= "";      
        String patternString1 = ".*\\[.*\\]\\s.*\\s\\d{0,}\\s\\d{0,}.*";    
        Pattern pattern = Pattern.compile(patternString1);
        String arr = ""; 
            for (int j = 0; j < txt.size(); j++){  
                Matcher matcher = pattern.matcher(txt.get(j));
                if(matcher.find()) {    
                    tweet t = new tweet(txt);
                    date = matcher.group().split("\\[")[1].split("\\]")[0].trim(); 
    
                    arr = matcher.group().split("\\]\\s")[1].trim(); 
                    arr.replace("]"," ");
                    String [] arr1 = arr.split(" "); 
                    tweetContent = arr.replace(arr1[arr1.length-2]+" "+arr1[arr1.length-1]," ").trim();
                                                     
                    rt = arr1[arr1.length-1];                              
                    t.setDate(date);
                    t.setRetweet(rt);
                    tweetList.put(tweetContent,t);
                }                     
            }               
           /*
            for (String key :tweetList.keySet()) {                 
                        
                   System.out.printf("%-30s%-30s\n",key,tweetList.get(key));                   
                
            }
              */  
    }

    public void maxRetweet(){
        List<Integer> retweetCount = new ArrayList<Integer>();
        System.out.println("Max retweet");
        for (String key: tweetList.keySet()){
            retweetCount.add(tweetList.get(key).getRetweet());
            Collections.sort(retweetCount);
        }
    
        for (String key: tweetList.keySet())
        {
            if ((tweetList.get(key)).getRetweet()== retweetCount.get(retweetCount.size()-1)){                
                   System.out.printf("%-120s%-30s\n",key,tweetList.get(key).getRetweet());                   
            }

            if ((tweetList.get(key)).getRetweet()== retweetCount.get(retweetCount.size()-2)){                
                   System.out.printf("%-120s%-30s\n",key,tweetList.get(key).getRetweet());                   
            }

            if ((tweetList.get(key)).getRetweet()== retweetCount.get(retweetCount.size()-3)){                
                   System.out.printf("%-120s%-30s\n",key,tweetList.get(key).getRetweet());                   
            }
        
        }

    }
}    
