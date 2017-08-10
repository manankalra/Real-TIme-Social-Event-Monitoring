package Twitter.Helper;


import java.io.*;

public class ReadFile {
    public BufferedReader readFile(String loc){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            fileReader = new FileReader(loc);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException f) {
            System.out.println("Unable to open file: " + loc);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + loc);
        }
        return bufferedReader;
    }
}
