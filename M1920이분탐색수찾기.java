import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class M1920이분탐색수찾기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        int lengthData = Integer.parseInt(br.readLine());
        int[] data = getArr(lengthData, br.readLine());

        int lengthFinds = Integer.parseInt(br.readLine());
        int[] finds = getArr(lengthFinds, br.readLine());

        Arrays.sort(data);

        for (int findNum : finds) {
            int lo = -1;
            int hi = lengthData;
            int mid = (lo + hi) / 2;
            boolean flag = true;

            while(flag) {
                if(data[mid] == findNum) {
                    flag = false;
                } else if(data[mid] < findNum) {
                    lo = mid ;
                    mid = (lo+hi)/2;
                } else {
                    hi = mid;
                    mid = (lo+hi)/2;
                }
                if(lo == mid || hi == mid || !flag) {
                    sb.append(flag? 0 : 1).append("\n");
                    flag = false;
                }
            }
        }
        System.out.println(sb);
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
