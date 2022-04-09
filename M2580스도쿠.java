import java.io.*;
import java.util.StringTokenizer;

public class M2580스도쿠 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] sudoku = new int[9][9];
    static int count = 0;
    static int[][] empty = new int[82][2];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
//        String a = "0 3 5 4 6 9 2 7 8\n" +
//                "7 8 2 1 0 5 6 0 9\n" +
//                "0 6 0 2 7 8 1 3 5\n" +
//                "3 2 1 0 4 6 8 9 7\n" +
//                "8 0 4 9 1 3 5 0 6\n" +
//                "5 9 6 8 2 0 4 1 3\n" +
//                "9 1 7 6 5 2 0 8 0\n" +
//                "6 0 3 7 0 1 9 5 2\n" +
//                "2 5 8 3 9 4 7 6 0";
//        String b = "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0\n" +
//                "0 0 0 0 0 0 0 0 0";
//        String c = "0 2 0 9 0 5 0 0 0\n" +
//                "\n" +
//                "5 9 0 0 3 0 2 0 0\n" +
//                "\n" +
//                "7 0 0 6 0 2 0 0 5\n" +
//                "\n" +
//                "0 0 9 3 5 0 4 6 0\n" +
//                "\n" +
//                "0 5 4 0 0 0 7 8 0\n" +
//                "\n" +
//                "0 8 3 0 2 7 5 0 0\n" +
//                "\n" +
//                "8 0 0 2 0 9 0 0 4\n" +
//                "\n" +
//                "0 0 5 0 4 0 0 2 6\n" +
//                "\n" +
//                "0 0 0 5 0 3 0 7 0";
        //StringTokenizer tempSt = new StringTokenizer(b, "\n");
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine()); //tempSt.nextToken());
            for (int j = 0; j < 9; j++) {
                int input = Integer.parseInt(st.nextToken());
                sudoku[i][j] = input;
                if (input == 0) {
                    empty[count][0] = i;
                    empty[count][1] = j;
                    count++;
                }
            }
        }
        paintSudoku(0);
    }

    private static void paintSudoku(int depth) throws IOException {
        int row = empty[depth][0];
        int col = empty[depth][1];

        if (depth == count) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(sudoku[i][j] + " ");
                }
                bw.write("\n");
            }
            bw.flush();
            System.exit(0);
        }
        for (int i = 0; i < 9; i++) {
            if (check(i + 1, row, col)) {  // 해당 empty 위치에 이런 값 넣어도 되는지 확인
                sudoku[row][col] = i + 1;
                paintSudoku(depth + 1);
            }
            sudoku[row][col] = 0;
        }
    }

    private static boolean check(int checkNum, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == checkNum || sudoku[i][col] == checkNum)
                return false;

            if (i < 3) {
                int tempRow = (row / 3) * 3 + i;
                for (int j = 0; j < 3; j++) {
                    int tempCol = (col / 3) * 3 + j;
                    if (sudoku[tempRow][tempCol] == checkNum)
                        return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            int tempRow = (row / 3) * 3 + i;
            for (int j = 0; j < 3; j++) {
                int tempCol = (col / 3) * 3 + j;
                if (sudoku[tempRow][tempCol] == checkNum)
                    return false;
            }
        }
        return true;
    }
}
