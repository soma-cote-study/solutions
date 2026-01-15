import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        String[] parts = input.split("<div");

        for(int i = 1; i < parts.length; i++){
            int a = parts[i].indexOf('"');
            int b = parts[i].indexOf('"', a + 1);
            int close = parts[i].indexOf('>');

            if(a == -1 || b == -1 || close == -1 || a >= b) continue;
            String title = parts[i].substring(a + 1, b);
            sb.append("title : ").append(title).append("\n");
            String[] pSearch = parts[i].substring(close + 1).split("<p>");

            for(String p : pSearch){
                if(p.length() < 1) continue;
                boolean tag = false;
                StringBuilder temp = new StringBuilder();

                for(int k = 0; k < p.length(); k++){
                    char c = p.charAt(k);

                    if(c == '<'){
                        tag = true;
                        continue;
                    }else if(c == '>'){
                        tag = false;
                        continue;
                    }else if(!tag){
                        temp.append(c);
                    }
                }
                String space = temp.toString().trim().replaceAll("\\s+", " ");
                sb.append(space).append("\n");
            }
        }
        System.out.print(sb);

    }
}
