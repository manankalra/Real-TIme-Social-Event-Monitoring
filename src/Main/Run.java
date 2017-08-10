package Main;


import CosineSimilarity.SurfaceSimilarity.GetCosine;
import Twitter.Cluster.ClusterTweets;
import Twitter.Count.GenerateMap;

import java.util.ArrayList;
import java.util.Map;

public class Run {
    public static Map<Integer, ArrayList<String>> cluster;

    public static void main(String[] args){
        /*try{
            new GenerateFiles().generateFiles();
        } catch(IOException ioe){
            System.out.println("Unable to fetch tweets.");
        } catch(TwitterException te){
            System.out.println("Unable to fetch tweets. TwitterAPI calls failed.");
        }*/
        cluster = new ClusterTweets().clusterTweets(new GenerateMap().generateMap());
        ArrayList<String> tweets = new GetCosine().getTweets(cluster);
        for(int i=0;i<tweets.size();i++){
            //System.out.println(tweets.get(i));
        }
    }
}
