import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // deque: 양 끝에서 삽입 삭제가 모두 가능함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        String command;

        int n = Integer.parseInt(br.readLine().trim());

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            command = st.nextToken();
            if (command.equals("push_front")) deque.addFirst(Integer.parseInt(st.nextToken()));
            else if (command.equals("push_back")) deque.addLast(Integer.parseInt(st.nextToken()));
            else if (command.equals("pop_front")) sb.append(deque.isEmpty() ? -1:deque.pollFirst()).append("\n");
            else if (command.equals("pop_back")) sb.append(deque.isEmpty() ? -1:deque.pollLast()).append("\n");
            else if (command.equals("size")) sb.append(deque.size()).append("\n");
            else if (command.equals("empty")) sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            else if (command.equals("front")) sb.append(deque.isEmpty() ? -1:deque.peekFirst()).append("\n");
            else if (command.equals("back")) sb.append(deque.isEmpty() ? -1:deque.peekLast()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}