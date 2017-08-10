package CosineSimilarity.SurfaceSimilarity.Helper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextToVector {
    String pattern = "\\w+";
    Pattern p = Pattern.compile(pattern);

    public HashMap<String, Integer> vectorize(String text) {
        Matcher m = p.matcher(text);
        ArrayList<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group(0).toLowerCase());
        }
        Counter<String> counts = new Counter<>();
        for (int i = 0; i < list.size(); i++) {
            counts.add(list.get(i));
        }
        HashMap<String, Integer> map = counts.returnMap();
        return map;
    }
}
