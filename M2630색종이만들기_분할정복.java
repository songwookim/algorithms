import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M2630색종이만들기_분할정복 {
    static int[][] arr;
    static int whiteCount = 0, blueCount = 0;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = 0;
            while (st.hasMoreTokens()) {
                arr[i][temp++] = Integer.parseInt(st.nextToken());
            }
        }
        setRectangleCount(0, 0, N);
        sb.append(whiteCount).append("\n").append(blueCount);
        System.out.println(sb);
    }

    static void setRectangleCount(int row, int col, int depth) {
        int firstColor = arr[row][col];
        boolean isSameColor = true;
        for (int i = row; i < row + depth; i++) {
            for (int j = col; j < col + depth; j++) {
                if (arr[i][j] != firstColor) {
                    isSameColor = false;
                    break;
                }
            }
        }
        if (isSameColor) {
            if (arr[row][col] == 0) whiteCount++;
            else blueCount++;
        } else {
            int position = depth / 2;
            setRectangleCount(row, col, depth / 2);
            setRectangleCount(row + position, col + position, depth / 2);
            setRectangleCount(row + position, col, depth / 2);
            setRectangleCount(row, col + position, depth / 2);
        }
    }
}
