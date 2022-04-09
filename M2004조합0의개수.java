import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M2004조합0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int a1 = getTrailingZeros(N);
        int a2 = getTrailingZeros(K);
        int a3 = getTrailingZeros(N - K);

        int b1 = getCountTwo(N);
        int b2 = getCountTwo(K);
        int b3 = getCountTwo(N - K);

        int count5 = a1 - (a2 + a3);
        int count2 = b1 - (b2 + b3);

        sb.append(Math.min(count5,count2));

        System.out.print(sb);
    }

    static int getCountTwo(int n) {
        int count = 0;
        for (int i = 1; ; i++) {
            int temp = n / (int) Math.pow(2, i);
            count += temp;
            if (temp == 0)
                break;
        }
        return count;
    }

    static int getTrailingZeros(int n) {
        int count = 0;
        for (int i = 1; ; i++) {
            int temp = n / (int) Math.pow(5, i);
            count += temp;
            if (temp == 0)
                break;
        }
//        while(n >= 5) {
//            count += n / 5;
//            n /= 5;
//        }

        return count;
    }
}
