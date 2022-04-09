import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M2740행렬곱셈 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int rowA, colA, rowB, colB;
        int[][] matrixA, matrixB;

        st = new StringTokenizer(br.readLine());
        rowA = Integer.parseInt(st.nextToken());
        colA = Integer.parseInt(st.nextToken());
        matrixA = getMatrix(rowA, colA);

        st = new StringTokenizer(br.readLine());
        rowB = Integer.parseInt(st.nextToken());
        colB = Integer.parseInt(st.nextToken());
        matrixB = getMatrix(rowB, colB);


        for (int i = 0; i < rowA; i++) { // 행렬A의 row
            for (int j = 0; j < colB; j++) { // 행렬B의 col
                int temp = 0;
                for (int k = 0; k < rowB; k++) { // ㅡ * ㅣ
                    temp += matrixA[i][k] * matrixB[k][j];
                }
                sb.append(temp).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] getMatrix(int row, int col) throws IOException {
        StringTokenizer st;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int temp = Integer.parseInt(st.nextToken());
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }
}
