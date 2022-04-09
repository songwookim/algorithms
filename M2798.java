import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M2798 {
    public static void main(String[] args) throws IOException {
        String input;
        int max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        input = br.readLine();
        st = new StringTokenizer(input);

        int[] arr = new int[100];
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        for (int a = 0; a < N - 2; a++) {
            for (int b = a + 1; b < N - 1; b++) {
                for (int c = b + 2; c < N; c++) {
                    int tempSum = arr[a] + arr[b] + arr[c];
                    max = tempSum <= M && tempSum >= max ? tempSum : max;
                }
            }
        }
        System.out.println(max);
    }
}
