import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class M1260_DFSBFS_인접행렬 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    static int[][] nodes;
    static boolean[] visited;

    static int edgNum;
    static int verNum;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        verNum = Integer.parseInt(st.nextToken());
        edgNum = Integer.parseInt(st.nextToken());
        int startNum = Integer.parseInt(st.nextToken());

        nodes = new int[verNum + 1][verNum + 1];
        visited = new boolean[verNum + 1];

        for (int i = 0; i < edgNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes[start][to] = 1;
            nodes[to][start] = 1;
        }

        dfs(startNum);
        System.out.println(sb);

        sb = new StringBuffer();
        visited = new boolean[verNum + 1];

        bfs(startNum);
        System.out.println(sb);
    }

    private static void dfs(int num) {
        visited[num] = true;
        sb.append(num).append(" ");

        for (int i = 1; i < verNum+1; i++) {
            if (!visited[i] && nodes[num][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(" ");
            for (int i = 1; i < verNum+1; i++) {
                if (!visited[i] && nodes[temp][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
