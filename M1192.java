import java.io.*;

public class M1192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int Nth = Integer.parseInt(br.readLine()); // Nth 범위 : rangeNthMin < Nth < rangeNthMax
        int rangeNthMax = 0, denominator;          // 결과 분수 : numerator / denominator
        for (denominator = 0; denominator <= Nth; denominator++) {
            rangeNthMax += denominator;
            if (rangeNthMax >= Nth) break;
        }

        String fractionalNum = "";
        int rangeNthMin = rangeNthMax - denominator + 1;
        int numerator = 1;
        int temp = denominator;

        while (rangeNthMin != Nth) {
            rangeNthMin++;
            numerator++;
            denominator--;
        }
        fractionalNum = temp % 2 == 0 ? numerator + "/" + denominator : denominator + "/" + numerator;
        bw.write(fractionalNum);

        br.close();
        bw.close();

    }
}
