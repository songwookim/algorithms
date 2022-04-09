import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M12015LIS_이진탐색 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer> LIS;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        LIS = new ArrayList<>();
        LIS.add(nums[0]);

        for (int i = 1; i < n; i++) {
            doBinarySearch(nums[i]);
        }
        System.out.println(LIS.size());
    }

    private static void doBinarySearch(int num) {
        int lo = 0, hi = LIS.size();
        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (LIS.get(mid) >= num) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == LIS.size() && lo != 0) {
            LIS.add(num);
        } else {
            LIS.set(lo, num);
        }
    }
}
