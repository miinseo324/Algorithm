import java.util.*;
import java.io.*;

public class Main {
    static int[] left = new int[26];
    static int[] right = new int[26];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim()); // 노드의 개수 주어진다.

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int root = st.nextToken().charAt(0) - 'A'; // 'A'부터 0으로
            int x = st.nextToken().charAt(0);
            left[root] = (x == '.' ? -1: x - 'A');
            x = st.nextToken().charAt(0);
            right[root] = (x == '.' ? -1: x - 'A');
        }

            preOrder(0); sb.append('\n');
            inOrder(0); sb.append('\n');
            postOrder(0); sb.append('\n');

        System.out.println(sb);
        }

    // 전위 순회
    public static void preOrder(int start) {
        if (start == -1) return;
        // 루
        sb.append((char)(start+'A'));
        // 왼
        preOrder(left[start]);
        // 오
        preOrder(right[start]);
    }

    // 중위 순회
    public static void inOrder(int start) {
        if (start == -1) return;
        // 왼
        inOrder(left[start]);
        // 루
        sb.append((char)(start+'A'));
        // 오
        inOrder(right[start]);
    }

    // 후위 순회
    public static void postOrder(int start) {
        if (start == -1) return;
        // 왼
        postOrder(left[start]);
        // 오
        postOrder(right[start]);
        // 루
        sb.append((char)(start+'A'));
    }

}