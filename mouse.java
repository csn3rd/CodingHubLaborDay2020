import java.io.*;
import java.util.*;

public class mouse {
    public static final int mod = 1000000007;
    
    public static void main(String[] args) throws Exception {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));    
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        boolean[][] trap = new boolean[n+1][m+1];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            trap[a][b] = true;
        }

        int[][] dp = new int[n+1][m+1];
        
        if (!trap[1][1]) {
            dp[1][1] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if ((i != 1 || j != 1) && !trap[i][j]) {
                    dp[i][j] = (int)(((long)(dp[i-1][j] + dp[i][j-1]))%mod);
                }
            }
        }
        
        out.println(dp[n][m]);        
        out.close();
    }
}