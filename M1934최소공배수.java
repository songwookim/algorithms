import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1934최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int commonDivisor = gcd(a,b);

            sb.append(a * b / commonDivisor).append("\n");
        }
        System.out.println(sb);
    }
    static private int gcd(int a, int b) {
        //if(b == 0) return a;
        return b != 0 ? gcd(b, a%b) : a;
    }
}
