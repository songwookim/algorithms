import java.util.Scanner;

public class M11050이항계수1 {
    public static void main(String[] args) {
        Scanner zz = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = zz.nextInt();
        int K = zz.nextInt();

        int denominator = 1;
        for (int i = 0; i < K; i++) {
            denominator *= N--;
        }
        sb.append(denominator / factorial(K) );
        System.out.println(sb);
    }

    static int factorial(int N) {
        return N <= 1 ? 1 : N * factorial(N - 1);
    }
}
