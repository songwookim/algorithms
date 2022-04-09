import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1780종이의개수 {
    static int[][] arr;
    static int N;
    static int countNegative = 0, countZero = 0, countPositive = 0;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setRectangleCount(0, 0, N);
        System.out.println(countNegative);
        System.out.println(countZero);
        System.out.println(countPositive);
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
            switch (firstColor) {
                case -1:
                    countNegative++;
                    break;
                case 0:
                    countZero++;
                    break;
                case 1:
                    countPositive++;
                    break;
            }
        } else {
            int position = depth / 3;
            setRectangleCount(row, col, depth / 3);
            setRectangleCount(row, col + position, depth / 3);
            setRectangleCount(row, col + position * 2, depth / 3);

            setRectangleCount(row + position, col, depth / 3);
            setRectangleCount(row + position, col + position, depth / 3);
            setRectangleCount(row + position, col + position * 2, depth / 3);

            setRectangleCount(row + position * 2, col, depth / 3);
            setRectangleCount(row + position * 2, col + position, depth / 3);
            setRectangleCount(row + position * 2, col + position * 2, depth / 3);
        }
    }
}
