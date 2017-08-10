package CosineSimilarity.SurfaceSimilarity;

import CosineSimilarity.SurfaceSimilarity.Helper.CalculateCosine;
import CosineSimilarity.SurfaceSimilarity.Helper.Process.Stem;
import CosineSimilarity.SurfaceSimilarity.Helper.Process.StopWords;
import CosineSimilarity.SurfaceSimilarity.Helper.TextToVector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetCosine {

    public ArrayList<String> getTweets(Map<Integer, ArrayList<String>> clustered) {
        ArrayList<String> tweets = new ArrayList<String>();
        TextToVector tv = new TextToVector();
        CalculateCosine cal = new CalculateCosine();
        int x = 0, y = 0;
        float max = 0;
        for (Map.Entry<Integer, ArrayList<String>> m : clustered.entrySet()) {
            ArrayList<String> tempTweets = m.getValue();
            ArrayList<HashMap<String, Integer>> vectors = new ArrayList<HashMap<String, Integer>>();
            for(int i=0;i<tempTweets.size();i++){
                vectors.add(tv.vectorize(new Stem().stemTweet(new StopWords().removeStopWords(tempTweets.get(i)))));
            }
            for(int j=0;j<vectors.size()-1;j++){
                for(int k=j+1;k<vectors.size();k++){
                    float cos = cal.calculate(vectors.get(j), vectors.get(k));
                    if (cos >= max) {
                        max = cos;
                        x = j;
                        y = k;
                    }
                }
            }
            tweets.add(tempTweets.get(x));
            //tweets.add(tempTweets.get(y));
        }
        return tweets;
    }
}