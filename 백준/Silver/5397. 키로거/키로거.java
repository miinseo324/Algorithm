import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Character> q1 = new ArrayDeque<>();
        Deque<Character> q2 = new ArrayDeque<>();

        for (int i=0; i<n; i++) {
            String text = br.readLine();
            for (int j=0; j<text.length(); j++) {
                char command = text.charAt(j);
                switch (command) {
                    case '<':
                        if (!q1.isEmpty()) q2.addFirst(q1.pollLast());
                        break;
                    case '>':
                        if (!q2.isEmpty()) q1.addLast(q2.pollFirst());
                        break;
                    case '-':
                        if (!q1.isEmpty()) q1.pollLast();
                        break;
                    default:
                        q1.add(command);
                        break;
                }
            }
            while (!q2.isEmpty()) {
                q1.addLast(q2.pollFirst());
            }

            while (!q1.isEmpty()) {
                sb.append(q1.poll());
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
