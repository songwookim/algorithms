import java.io.*;
import java.util.StringTokenizer;

public class M14889스타트와링크 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] linkArr;
    static boolean[] indexArr;
    static boolean[] visit;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());//"8");
        linkArr = new int[N][N];

        String input = "0 5 4 5 4 5 4 5\n" +
                "4 0 5 1 2 3 4 5\n" +
                "9 8 0 1 2 3 1 2\n" +
                "9 9 9 0 9 9 9 9\n" +
                "1 1 1 1 0 1 1 1\n" +
                "8 7 6 5 4 0 3 2\n" +
                "9 1 9 1 9 1 0 9\n" +
                "6 5 4 3 2 1 9 0";
        StringTokenizer st;
        //st = new StringTokenizer(input, "\n");
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //String temp = st.nextToken();
            //StringTokenizer st1 = new StringTokenizer(temp);
            for (int j = 0; j < N; j++) {
                linkArr[i][j] = Integer.parseInt(st.nextToken());//st1.nextToken());
            }
        }

        indexArr = new boolean[N];
        getMinAbility(0, 0);

        bw.write(min + "");
        bw.flush();
    }

    private static void getMinAbility(int depth, int phase) {
        if (depth == N / 2) {
            int result1 = 0;
            int result2 = 0;

            // 선택된 idx 외 능력치 총합
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    int tempAbility = linkArr[i][j] + linkArr[j][i];
                    if (indexArr[i] && indexArr[j]) {
                        result1 += tempAbility;
                        continue;
                    }
                    if (!indexArr[i] && !indexArr[j]) {
                        result2 += tempAbility;
                    }
                }
            }
            min = Math.min(min, Math.abs(result1 - result2));
        }
        for (int i = phase; i < N; i++) { //0~3
            indexArr[i] = true;
            getMinAbility(depth + 1, i + 1);
            indexArr[i] = false;
        }
    }

}
