import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class M2581 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner zz= new Scanner(System.in);
        int M = zz.nextInt();
        int N = zz.nextInt();
        int sum = 0;
        int min = 0;

        for(int i = M; i <= N; i++) {
            if(isPN(i)){
                sum += i;
                if(min == 0 )
                    min = i;
            }
        }

        System.out.printf("%d \n", sum == 0 ? -1 : sum);
        System.out.printf("%s", sum == 0 ? "" : min);
    }

    static boolean isPN(int temp) {
        boolean isPN = true;
        for(int j = 2; (j-1) < temp/2.0; j++) {
            if(temp % j == 0) {
                isPN = false;
            }
        }
        if(isPN && temp != 1) {
            return true;
        }
        return false;
    }
}
