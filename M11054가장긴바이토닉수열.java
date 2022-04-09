import java.io.*;
import java.util.StringTokenizer;

public class M11054가장긴바이토닉수열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] arr;
    static Integer[] maxIdx;

    static Integer[] dp1, dp2;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        maxIdx = new Integer[N];//new ArrayList<Integer>();
        dp1 = new Integer[N];
        dp2 = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            max = Math.max(max, input);
        }
        int a = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == max) {
                maxIdx[a++] = i;
            }
        }
        max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(LIS(i) + LDS(i) - 1, max);
        }
        bw.write(max + "");

        bw.flush();
    }

    private static int LIS(int depth) {
        if (dp1[depth] == null) {
            dp1[depth] = 1;

            for (int i = depth - 1; i >= 0; i--) {
                if (arr[i] < arr[depth])
                    dp1[depth] = Math.max(LIS(i) + 1, dp1[depth]);
            }
        }
        return dp1[depth];
    }

    private static int LDS(int depth) {
        if (dp2[depth] == null) {
            dp2[depth] = 1;

            for (int i = depth + 1; i < N; i++) {
                if (arr[i] < arr[depth])
                    dp2[depth] = Math.max(LDS(i) + 1, dp2[depth]);
            }
        }
        return dp2[depth];
    }
}
