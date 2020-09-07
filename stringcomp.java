import java.io.*;
import java.util.*;

public class stringcomp {
    public static void main(String[] args) throws Exception {
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));    
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String n = f.readLine();
        String m = f.readLine();
        
        HashSet<Character> mchars = new HashSet<Character>();
        for (int i = 0; i < m.length(); i++) {
            mchars.add(m.charAt(i));
        }
        
        int size = mchars.size();
        
        int start = 0;
        int ans = Integer.MAX_VALUE;
        
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        
        int unique = 0;
        for (int i = 0; i < n.length(); i++) {
            char curr = n.charAt(i);
            int num = counts.getOrDefault(curr, 0);
            counts.put(curr, num+1);
            
            if (num == 0 && mchars.contains(n.charAt(i))) {
                unique++;
            }
            
            if (unique == size) {
                int count = counts.get(n.charAt(start));
                while (count > 1 || !mchars.contains(n.charAt(start))) {
                    if (count > 1 || !mchars.contains(n.charAt(start))) {
                        counts.replace(n.charAt(start), count-1);
                    }
                    start++;
                    count = counts.get(n.charAt(start));
                }
                
                ans = Math.min(ans, i-start+1);                
            }
        }

        if (ans == Integer.MAX_VALUE) {
            out.println("N/A");
        } else {
            out.println(ans);
        }
        
        out.close();
    }
}
