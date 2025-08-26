import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 왼쪽으로만 삽입, 삭제가 이루어지므로
        Deque<Character> dq_main = new ArrayDeque<>(); // 메인 deque
        Deque<Character> dq_sub = new ArrayDeque<>(); // 보조 deque

        String text = br.readLine();
        for (int i=0; i<text.length(); i++) {
            dq_main.addLast(text.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char command = st.nextToken().charAt(0);
            switch (command) {
                case 'L': // dq_main에 있던 걸 뒤에서 빼서 dq_sub의 앞에 삽입한다.
                    if (!dq_main.isEmpty()) dq_sub.addFirst(dq_main.pollLast());
                    break;
                case 'D': // dq_sub 앞에 있던 걸 빼서, dq_main의 뒤에 삽입한다.
                    if (!dq_sub.isEmpty()) dq_main.addLast(dq_sub.pollFirst());
                    break;
                case 'B': // 커서 왼쪽에 있는 문자 삭제 -> dq_main에서 뒤에서 하나 뺌
                    if (!dq_main.isEmpty()) dq_main.pollLast();
                    break;
                case 'P':
                    char input = st.nextToken().charAt(0);
                    dq_main.addLast(input);
                    break;
            }
        }
        while (!dq_sub.isEmpty()) {
            dq_main.addLast(dq_sub.pollFirst());
        }

        while (!dq_main.isEmpty()) {
            sb.append(dq_main.pollFirst());
        }

        System.out.println(sb);
        br.close();
    }
}
