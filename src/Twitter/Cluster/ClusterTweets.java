package Twitter.Cluster;


import Twitter.Helper.ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ClusterTweets {
    public final int numEvents = 3;
    public final String loc = "tweets.txt";

    public Object[] selectTopHashtags(Map<String, Integer> map) {
        Set<String> keys = map.keySet();
        Object[] topTags = new Object[numEvents];
        for (int i = 0; i < numEvents; i++) {
            topTags[i] = keys.toArray()[i];
        }
        return topTags;
    }

    public Map<Integer, ArrayList<String>> clusterTweets(Map<String, Integer> map){
        Object[] topTags = selectTopHashtags(map);
        Map<Integer, ArrayList<String>> cluster = new HashMap<Integer, ArrayList<String>>();
        for(int i=0;i<numEvents;i++){
            cluster.put(i, new ArrayList<String>());
        }
        try {
            BufferedReader bufferedReader = new ReadFile().readFile(loc);
            String tweet = null;
            while ((tweet = bufferedReader.readLine()) != null) {
                String[] splitTweet = tweet.split(" ");
                for(int i=0;i<topTags.length;i++){
                    for(int j=0;j<splitTweet.length;j++){
                        if(topTags[i].equals(splitTweet[j])){
                            ArrayList<String> temp = cluster.get(i);
                            temp.add(tweet);
                            cluster.put(i, temp);
                        }
                    }
                }
            }
        } catch (FileNotFoundException f) {
            System.out.println("Unable to open file: " + loc);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + loc);
        }
        return cluster;
    }
}
