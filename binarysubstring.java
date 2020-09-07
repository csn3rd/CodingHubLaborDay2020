import java.io.*;
import java.util.*;

public class binarysubstring {
    public static void main(String[] args) throws Exception {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));    
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String s = f.readLine();
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        
        out.println(((long)count*(count-1))/2);
        out.close();
    }
}

