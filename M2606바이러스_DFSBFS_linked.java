import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class M2606바이러스_DFSBFS_linked {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();

    static ArrayList[] nodes;
    static boolean[] visited;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[start].add(to);
            nodes[to].add(start);
        }
        for (int i = 0; i < N; i++) {
            Collections.sort(nodes[i]);
        }
        visited = new boolean[N + 1];
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int num) {
        visited[num] = true;

        for (Object i : nodes[num]) {
            if (!visited[(int) i]) {
                dfs((Integer) i);
                count++;

            }
        }
    }
}
