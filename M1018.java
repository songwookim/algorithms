import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int COLUMN = Integer.parseInt(st.nextToken());
        final int ROW = Integer.parseInt(st.nextToken());

        int count = 64, tempCount, tempW = 0, tempB = 0;
        String[] Board = new String[ROW];
        for (int i = 0; i < COLUMN; i++) {
            Board[i] = br.readLine();
        }
        for (int startCol = 0; startCol <= COLUMN - 8; startCol++) {
            for (int startRow = 0; startRow <= ROW - 8; startRow++) {
                for (int tempCol = startCol; tempCol < startCol + 8; tempCol++) {
                    //tempCount += cnt(Board[startCol].charAt(startRow), Board[tempCol], tempCol, startRow);
                    tempW += cnt('W', Board[tempCol], tempCol, startRow);
                    tempB += cnt('B', Board[tempCol], tempCol, startRow);

                }
                tempCount = Math.min(tempW, tempB);
                count = Math.min(count,tempCount);

                tempW = 0;
                tempB = 0;

            }

        }
        System.out.println(count);
    }

    static int cnt(char firstAlphabet, String tempBoard, int tempCol, int startRow) {
        int count = 0;
        for (int tempRow = startRow; tempRow < startRow + 8; tempRow++) {

            char tempChar = tempBoard.charAt(tempRow);
            // 행이 홀수이고 열이 짝수일 경우 달라야 한다.
            // 행이 짝수이고 열이 홀수일 경우 달라야 한다
            if ((tempCol % 2 != 0 && tempRow % 2 == 0) || (tempCol % 2 == 0 && tempRow % 2 != 0)) {
                if (firstAlphabet == tempChar) count++;
                continue;
            }

            // 행이 짝수이고 열이 짝수일 경우 같아야 한다.
            // 행이 홀수이고 열이 홀수일 경우 같아야 한다.
            if (firstAlphabet != tempChar) count++;
        }
        return count;
    }
}
