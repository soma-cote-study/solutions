import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String name;
        boolean isFolder;

        Node(String name, boolean isFolder) {
            this.name = name;
            this.isFolder = isFolder;
        }
    }

    static Map<String, List<Node>> file = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child = st.nextToken();
            int type = Integer.parseInt(st.nextToken());

            file.putIfAbsent(parent, new ArrayList<>());
            file.get(parent).add(new Node(child, type == 1));
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String path = br.readLine();
            String[] partPath = path.split("/");
            String target = partPath[partPath.length - 1];

            Set<String> distinct = new HashSet<>();
            int[] total = {0};

            search(target, distinct, total);

            sb.append(distinct.size()).append(" ").append(total[0]).append("\n");
        }

        System.out.print(sb);
    }

    static void search(String currentFolder, Set<String> distinct, int[] total) {
        if (!file.containsKey(currentFolder)) {
            return;
        }

        for (Node child : file.get(currentFolder)) {
            if (child.isFolder) {
                search(child.name, distinct, total);
            } else {
                distinct.add(child.name);
                total[0]++;
            }
        }
    }
}