import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class M17103골드바흐파티션 {
    private static boolean[] isCompositeNum = new boolean[1000001];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int input;
        int count;
        isCompositeNum[0] = true;
        isCompositeNum[1] = true;
        setIsCompositeNum();
        while (N-- > 0) {
            input = Integer.parseInt(br.readLine());
            count = 0;
            for (int i = 2; i < input / 2 + 1; i++) {
                if (!isCompositeNum[i] && !isCompositeNum[input - i]) { // 합성수가 아닌 두 수 = 두 소수
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
    
    static void setIsCompositeNum() { // 에라토스테네스체
        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (isCompositeNum[i]) continue; // 체크된 거면 넘어가기
            for (int tempComNum = (int) Math.pow(i, 2); tempComNum <= 1000000; tempComNum += i) {
                isCompositeNum[tempComNum] = true;            // 2~root(k) 까지 k배수 제외
            }
        }

    }
}
