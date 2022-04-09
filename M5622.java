import java.io.*;
import java.util.Locale;

public class M5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().toUpperCase();
        String[] inputArr = input.split("");
        int len = inputArr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int temp = (int) inputArr[i].charAt(0) - (int) 'A';
            if (temp >= (int) 'S' - (int) 'A') {
                temp--;
                if (temp == (int) 'Z' - (int) 'A' - 1) {
                    temp--;
                }
            }
            sum += temp / 3 + 3;
        }
        bw.write("" + sum);
        bw.flush();

        br.close();
        bw.close();

    }
}
