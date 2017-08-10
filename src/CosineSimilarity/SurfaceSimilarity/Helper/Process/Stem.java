package CosineSimilarity.SurfaceSimilarity.Helper.Process;


import java.io.*;

public class Stem {
    public String stemTweet(String unprocessed) {
        StringBuffer result = new StringBuffer();
        try {
            PrintWriter out = new PrintWriter("single.txt");
            out.print(unprocessed);
            out.close();
        } catch (FileNotFoundException f) {
        }
        Stemmer stemmer = new Stemmer();
        char[] w = new char[501];
        try {
            FileInputStream in = new FileInputStream("single.txt");
            try {
                while (true) {
                    int ch = in.read();
                    if (Character.isLetter((char) ch)) {
                        int j = 0;
                        while (true) {
                            ch = Character.toLowerCase((char) ch);
                            w[j] = (char) ch;
                            if (j < 500) {
                                j++;
                            }
                            ch = in.read();
                            if (!Character.isLetter((char) ch)) {
                                for (int c = 0; c < j; c++) {
                                    stemmer.add(w[c]);
                                }
                                stemmer.stem();
                                {
                                    String u;
                                    u = stemmer.toString();
                                    result.append(u);
                                    result.append(" ");
                                }
                                break;
                            }
                        }
                    }
                    if (ch < 0) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error.");
            }
        } catch (FileNotFoundException f) {
        }
        String processed = result.toString();
        //System.out.println(result);
        return processed;
    }
}
