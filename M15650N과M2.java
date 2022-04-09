
import java.io.*;
import java.util.StringTokenizer;

public class M15650N과M2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    static int[] he;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];
        he = new int[M];

        dfs(0, 1);
        bw.flush();
    }

    public static void dfs(int depth, int phase) throws IOException {
        if (depth == M) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = phase; i <= N; i++) {
            //if (!visit[i]) {
            //visit[i] = true;
            arr[depth] = i;
            dfs(depth + 1, i + 1);
            //    visit[i] = false;
            //}
        }
    }
}
