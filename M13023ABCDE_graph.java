/*
 * BOJ13023
 * 2020.01.23
 * Hyeonseong
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M13023ABCDE_graph
{
    static int n; // 사람의 수
    static int m; // 친구 관계의 수
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringTokenizer st ;
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=0;i<n;i++) {
            dfs(i,1);
        }
        System.out.println("0");
    }

    public static void dfs(int now, int cnt) {
        if(cnt==5) {
            System.out.println("1");
            System.exit(0);
        }
        visited[now] = true;
        for(int i=0;i<graph[now].size();i++) {
            int next = graph[now].get(i);
            if(!visited[next]) {
                dfs(next,cnt+1);
            }
        }
        visited[now] = false;
    }
}
