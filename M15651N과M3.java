import java.io.*;
import java.util.StringTokenizer;

public class M15651N과M3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    static int[] he ;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        dfs(0);
        bw.flush();
    }

    public static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                //visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                //visit[i] = false;
            }
        }
    }
}
