import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M10816이분탐색빈도계산 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        int lengthData = Integer.parseInt(br.readLine());
        int[] data = getArr(lengthData, br.readLine());

        int lengthFinds = Integer.parseInt(br.readLine());
        int[] finds = getArr(lengthFinds, br.readLine());

        Arrays.sort(data);
        for (int findNum : finds) {
            sb.append(upperBound(data,findNum)-lowerBound(data, findNum)).append(" ");
        }
        System.out.println(sb);

    }


    private static int upperBound(int[] data, int findNum) {
        int lo = 0;
        int hi = data.length;
        int mid;

        while (lo < hi) {
            mid = (lo + hi) / 2;

            if (findNum < data[mid]) {
                hi = mid;

            } else  {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int lowerBound(int[] data, int findNum) {
        int lo = 0;
        int hi = data.length ;
        int mid;

        while (lo < hi) {
            mid = (lo + (hi)) / 2;

            if (findNum <= data[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int[] getArr(int n, String input) {
        StringTokenizer st = new StringTokenizer(input);
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        return temp;
    }
}
