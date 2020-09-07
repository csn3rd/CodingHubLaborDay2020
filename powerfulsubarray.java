import java.io.*;
import java.util.*;

public class powerfulsubarray {
    public static void main(String[] args) throws Exception {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));    
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
        
        st = new StringTokenizer(f.readLine());
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int element = Integer.parseInt(st.nextToken());
            int prev = indices.getOrDefault(element, -1);
            if (prev != -1) {
                ans = Math.min(ans, i-prev+1);
            }
            indices.put(element, i);
        }
        
        if (ans == Integer.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(ans);
        }

        out.close();
    }
}