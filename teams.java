import java.io.*;
import java.util.*;

public class teams {
	public static void main(String[] args) throws Exception {
		
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> teamIds = new HashSet<Integer>();
		Member[] members = new Member[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			members[i] = new Member(a,b);
			teamIds.add(b);
		}
		Arrays.sort(members);
		
		int numTeams = teamIds.size();
		
		int start = 0;
		int ans = Integer.MAX_VALUE;
		
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		
		int unique = 0;
		for (int i = 0; i < n; i++) {
			int num = counts.getOrDefault(members[i].id, 0);
			counts.put(members[i].id, num+1);
			
			if (num == 0) {
				unique++;
			}
			
			if (unique == numTeams) {
				int count = counts.get(members[start].id);
				while (count > 1) {
					if (count > 1) {
						counts.replace(members[start].id, count-1);
					}
					start++;
					count = counts.get(members[start].id);;
				}
				
				ans = Math.min(ans, members[i].x - members[start].x);				
			}
		}
		
		out.println(ans);
		out.close();
	}
}

class Member implements Comparable {
	int x;
	int id;
	
	public Member(int a, int b) {
		x = a;
		id = b;
	}

	@Override
	public int compareTo(Object o) {
		return x - ((Member)o).x;
	}
	
	@Override
	public boolean equals(Object o) {
		return x == ((Member)o).x && id == ((Member)o).id;
	}
}
