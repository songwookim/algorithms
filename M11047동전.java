import java.io.*;
import java.util.StringTokenizer;

public class M11047동전 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int K;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            coin[i] = input;
            if (K / input > 0) max = i;
        }

        int count = 0;
        while (true) {
            if (K == 0) break;
            if (K / coin[max] == 0) {
                max--;
                continue;
            }
            K = K - coin[max];
            count++;
        }
        bw.write(count + "");
        bw.flush();
    }
}
