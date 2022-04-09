public class 버블정렬 {
    private static int[] arr;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        int N = 10;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * 10);
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N - i; j++) {
                if (arr[j - 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        for (int a : arr) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
