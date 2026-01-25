import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            String input = br.readLine();

            if(check(input)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    static boolean check(String s){
        int length = s.length();
        if(s.length() == 1) return true;

        int mid = length / 2;
        for(int i = 0; i < mid; i++){
            if(s.charAt(i) == s.charAt(length - 1 - i)){
                return false;
            }
        }

        return check(s.substring(0, mid));
    }
}