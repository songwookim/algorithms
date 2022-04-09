import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M11444피보나치6분할정복 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    private static long mod = 1000000007;
    static long[][] squareMatrix;
    static int N = 2;

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());
        
        squareMatrix = new long[][]{{1,1},{1,0}};
        squareMatrix = recur(n);
        sb.append(squareMatrix[0][1]);
        System.out.println(sb);
    }
    private static long[][] recur(long n) {
        if (n == 1) {
            return squareMatrix;
        }
        long[][] temp = recur(n / 2);
        if (n % 2 == 1) {
            return getMultipliedMatrix(getMultipliedMatrix(temp, temp), squareMatrix);
        }
        return getMultipliedMatrix(temp, temp);
    }

    private static long[][] getMultipliedMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] resultMatrix = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tempElement = 0;
                for (int k = 0; k < N; k++) {
                    tempElement += (matrix1[i][k] % mod * matrix2[k][j] % mod) % mod;
                }
                resultMatrix[i][j] = tempElement % mod;
            }
        }
        return resultMatrix;
    }
}
