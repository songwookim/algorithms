import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class M11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while(N > 1) {
            int temp = 2;
            while(!(N % temp == 0 && isPN(temp))) {
                temp++;
            }
            N /= temp;
            System.out.println(temp);
        }
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
