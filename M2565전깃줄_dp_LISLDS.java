import java.io.*;
import java.util.StringTokenizer;

public class M2565전깃줄_dp_LISLDS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static int[] A;
    static int[] B;
    static Integer[] dp1, dp2;


    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        dp1 = new Integer[N];
        dp2 = new Integer[N];
        A = new int[N];
        B = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(LISLine(i) + LDSLine(i) - 1, max);
        }

        bw.write(N - max + "");
        bw.flush();
    }

    private static int LISLine(int depth) {
        if (dp1[depth] == null) {
            dp1[depth] = 1;

            for (int i = 0; i < N; i++) {
                if (check1(depth, i)) { // 안 꼬이는 선의 갯수
                    dp1[depth] = Math.max(dp1[depth], LISLine(i) + 1);
                }
            }
        }
        return dp1[depth];
    }

    private static int LDSLine(int depth) {
        if (dp2[depth] == null) {
            dp2[depth] = 1;

            for (int i = 0; i < N; i++) {
                if (check2(depth, i)) { // 안 꼬이는 선의 갯수
                    dp2[depth] = Math.max(dp2[depth], LDSLine(i) + 1);
                }
            }
        }
        return dp2[depth];
    }

    private static boolean check1(int depth, int i) {
        return A[depth] < A[i] && B[depth] < B[i];
    }

    private static boolean check2(int depth, int i) {
        return A[depth] > A[i] && B[depth] > B[i];
    }
}
