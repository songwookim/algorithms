import java.io.*;

public class M9251LCS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[] dp;
    static int N;

    static String a, b;

    public static void main(String[] args) throws IOException {
        String tempA = br.readLine();
        String tempB = br.readLine();
        a = tempA.length() > tempB.length() ? tempB : tempA;
        b = tempA.length() > tempB.length() ? tempA : tempB;

        N = a.length();//Math.min(a.length(), b.length());
        dp = new Integer[N];

        dp[N - 1] = 0;
//        for (int i = 0; i < b.length(); i++) {
//            if (a.charAt(a.length() - 1) == b.charAt(i)) {
//                dp[N - 1] = 1;
//                break;
//            }
//        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(recur(i, 0), max);
        }
        bw.write(max + "");
        bw.flush();
    }

    private static int recur(int depth, int depthSub) {
        if (depth == N - 1) {
            for (int i = depthSub; i < b.length(); i++) {
                if (a.charAt(depth) == b.charAt(i)) {
                    return dp[depth] = 1;
                }
            }
            return dp[depth] = 0;
        }
        if (dp[depth] == null) {
            dp[depth] = 0;

            for (int i = depthSub; i < b.length(); i++) {
                if (a.charAt(depth) == b.charAt(i)) {
                    dp[depth] = Math.max(recur(depth + 1, i + 1) + 1, dp[depth]);
                }
            }
        }
        if (depthSub == b.length()-1 && depth < N-1) {
            for (int i = depth + 1; i < N; i++) {
                if (a.charAt(i) == b.charAt(depthSub)) {
                    return dp[depth] = 1;
                }
            }
            return dp[depth] = 0;
        }
        return dp[depth];
    }
}
