package Twitter.Count;

import Twitter.Helper.ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GenerateMap {
    public final String loc = "test\\part-00000";

    public Map<String, Integer> sort(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public Map<String, Integer> generateMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String pattern = "^\\(u'(#\\w+)', (\\d+)\\)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = null;
        try {
            BufferedReader bufferedReader = new ReadFile().readFile(loc);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                m = p.matcher(line);
                if (m.find()) {
                    map.put(m.group(1), Integer.parseInt(m.group(2)));
                } else {
                    System.out.println("No match found.");
                    continue;
                }
            }
        } catch (FileNotFoundException f) {
            System.out.println("Unable to open file: " + loc);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + loc);
        }
        return sort(map);
    }
}