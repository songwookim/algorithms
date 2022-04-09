import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class M12865배낭 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Integer[][] dp;
    static int[][] items;
    static int N, maxWeight;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        maxWeight = Integer.parseInt(st.nextToken());

        dp = new Integer[101][100001];
        items = new int[101][2]; // 0 : 무게, 1: 가치

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

//        for (int i = 0; i < N; i++) {
//            recur(i, items[i][0]);
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < N; i++) {
//            for(Integer value : dp[i]) {
//                if(value == null) continue;
//                max = Math.max(max, value);
//            }
//        }
//        bw.write(max + "");
        bw.write(recur(N-1, maxWeight) + "");
        bw.flush();
    }

    private static int recur(int depth, int nowWeight) {
        if(depth < 0)
            return 0;
        if (dp[depth][nowWeight] == null) {

            if(items[depth][0] > nowWeight) {
                dp[depth][nowWeight] = recur(depth -1, nowWeight);
            }
            //dp[depth][nowWeight] = items[depth][1];
            else {
                dp[depth][nowWeight] = Math.max(recur(depth-1, nowWeight), recur(depth-1, nowWeight - items[depth][0]) + items[depth][1]);
            }
//            for (int i = depth + 1; i < N; i++) {
//                int addedWeight = nowWeight + items[i][0];
//                if (addedWeight <= maxWeight) {
//                    dp[depth][nowWeight] = Math.max(recur(i, addedWeight) + items[depth][1], dp[depth][nowWeight]);
//                }
//            }
        }
        return dp[depth][nowWeight];

    }
}
