import java.io.*;

public class M9663N_Queen {
    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int cnt = 0;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        countQueen(0);
        bw.write(cnt + "");
        bw.flush();
    }

    private static void countQueen(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check(depth, i)) { // 다음 depth에 대해 돌다리 두들겨보기
                arr[depth + 1] = i + 1;
                countQueen(depth + 1);
            }
        }
    }

    private static boolean check(int depth, int i) {
        if (arr[depth] != 0) {
            for (int j = 1; j < depth + 1; j++) {  // 과거 값과 비교
                if (arr[j] - depth + 1 - j == 1) ;
                if (i + 1 == arr[j]) return false;   // 가로선 처리
                if (i + 1 == arr[j] + depth + 1 - j || i + 1 == arr[j] - (depth + 1 - j)) // 대각선 처리 (정삼각형)
                    return false;
            }
        }
        return true;
    }
}
