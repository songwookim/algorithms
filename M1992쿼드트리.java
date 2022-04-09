import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1992쿼드트리 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        setRectangleCount(0, 0, N);
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
                sb.append(firstColor);
        } else {
            int position = depth / 2;
            sb.append("(");
            setRectangleCount(row, col, depth / 2);
            setRectangleCount(row, col + position, depth / 2);
            setRectangleCount(row + position, col, depth / 2);
            setRectangleCount(row + position, col + position, depth / 2);

            sb.append(")");
        }
    }
}
