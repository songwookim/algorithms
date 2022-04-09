import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M7568 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rank = new int[N];
        int[] weightArr = new int[N];
        int[] keyArr = new int[N];

        int i = 0;

        while (i != N) {
            st = new StringTokenizer(br.readLine());
            weightArr[i] = Integer.parseInt(st.nextToken());
            keyArr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        for (i = 0; i < N; i++) {
            int temp = 1;
            for (int n = 0; n < N; n++) {
                if (keyArr[i] < keyArr[n] && weightArr[i] < weightArr[n]) { // 둘 다 클 경우
                    temp++;
                }
            }
            rank[i] = temp;
        }
        for (i = 0; i < N; i++) {
            System.out.printf("%d ", rank[i]);
        }
    }
}
