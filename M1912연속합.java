import java.io.*;
import java.util.StringTokenizer;

public class M1912연속합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] dp;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N];
        arr= new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[N - 1] = arr[N - 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, recur(i));
        }
        bw.write(max+"");
        bw.flush();
    }

    private static int recur(int depth) {
        if (dp[depth] == null) {
            dp[depth] = Math.max(recur(depth + 1) + arr[depth], arr[depth]);
        }
        return dp[depth];

    }
}
