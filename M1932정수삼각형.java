import java.io.*;
import java.util.StringTokenizer;

public class M1932정수삼각형 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] cost;
    static int[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        cost = dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                if (i == N - 1) {
                    dp[i][j] = cost[i][j];
                }
            }
        }
        tri(N - 1);

        bw.write(dp[0][0] + "");
        bw.flush();
    }

    private static void tri(int depth) {
        if (depth == 0) return;
        for (int i = 0; i < depth; i++) {
            dp[depth - 1][i] = Math.max(dp[depth][i], dp[depth][i + 1]) + cost[depth - 1][i];
        }
        tri(depth - 1);
    }
}
