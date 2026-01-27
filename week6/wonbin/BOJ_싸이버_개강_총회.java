import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        Set<String> entered = new HashSet<>();
        Set<String> attended = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            String[] log = input.split(" ");
            String time = log[0];
            String nickname = log[1];

            if (time.compareTo(S) <= 0) {
                entered.add(nickname);
            }
            else if (time.compareTo(E) >= 0 && time.compareTo(Q) <= 0) {
                if (entered.contains(nickname)) {
                    attended.add(nickname);
                }
            }
        }

        System.out.println(attended.size());
    }
}