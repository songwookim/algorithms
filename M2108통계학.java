import java.io.*;
import java.util.Arrays;
import java.util.TreeMap;

public class M2108통계학 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] countSort = new int[8001]; // -4000 ~ 4000

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            countSort[input + 4000] += 1;

            sum += input;
            if (min > input) min = input;
            if (max < input) max = input;
        }

        bw.write(Math.round(sum / (double) N) + "\n");
        bw.write(medianNumber(countSort, min + 4000, max + 4000, N) + "\n");
        bw.write(mostFreqAndLeastSecondSmallestNumber(countSort, min + 4000, max + 4000, N) + "\n");
        bw.write(max - min + "\n");

        bw.flush();
    }

    private static int medianNumber(int[] countArr, int min, int max, int N) {
        int countMedian = 0;
        int i;
        for (i = min; i < max + 1; i++) {
            countMedian += countArr[i];
            if (countMedian >= Math.round(N / 2.0)) break;
        }
        return i - 4000;
    }

    private static int mostFreqAndLeastSecondSmallestNumber(int[] countArr, int min, int max, int N) {
        int mostFreq = Arrays.stream(countArr).max().getAsInt();

        Integer result = null;
        for (int i = min; i < max + 1; i++) {
            if (countArr[i] == mostFreq) {
                if (result == null) {
                    result = i - 4000;
                    continue;
                }
                result = i - 4000;
                break;
            }
        }
        return result;
    }
}
