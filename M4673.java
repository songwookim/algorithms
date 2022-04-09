public class M4673 {

    public static void printSN() {
        boolean[] chkSNArr = new boolean[10001];  // 어차피 boolean을 써야돼서 int 말고 boolean 배열 생성
        for(int i =0; i < 10000; i++) {
            if(sn(i+1) <= 10000) {
                chkSNArr[ sn(i + 1) ] = true; // SN이 아닌 인자 부분만 True
            }
        }
        for(int i =1; i <= 10000; i++) {
            if(!chkSNArr[i]) {
                System.out.println(i);
            }
        }
    }

    public static int sn(int n) {
        int temp = n;

        while(n > 0) {
            temp += n % 10;
            n /= 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        M4673.printSN();
    }
}
