import java.util.*;

public class Main{
    static int N;
    static int M;
    static int[] trees;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();
        trees = new int[N];

        int max = 0;
        for(int i = 0; i < N; i++)
        {
            trees[i] = in.nextInt();
            max = Math.max(max, trees[i]);
        }

        int left = 0, right = max;
        int result = 0;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            long sum = 0;
            for(int tree : trees)
            {
                if(tree > mid)
                {
                    sum += tree - mid;
                }
            }
            if(sum >= M)
            {
                result = mid;
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}