import java.util.Scanner;

public class M2231 {
    public static void main(String[] args) {
        Scanner zz = new Scanner(System.in);
        Integer N = zz.nextInt();
        int result = 0;
        for (int i = N - N.toString().length() * 9; i < N; i++) {
            int temp = i;
            int sum = i;

            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}
