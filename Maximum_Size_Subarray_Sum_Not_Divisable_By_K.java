/*
     Key Concept :

     suppose, sum % x == 0
     if we remove any element from sum that is divisable by k
     then without that element, sum % x != 0 ***

 */




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Maximum_Size_Subarray_Sum_Not_Divisable_By_K {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            int x = input.nextInt();

            int[] arr = new int[n+1];

            int total = 0;
            for(int i = 1;i <= n;i++){
                arr[i] = input.nextInt();
                total += arr[i];
            }

            if(total % x != 0){
                pw.println(n);
            }

            else{
                int p1 = 1;
                int p2 = n;
                boolean con = false;
                for(p1 = 1;p1 <= n;p1++){
                    if(arr[p1] % x != 0){
                        con = true;
                        break;
                    }
                }
                for(p2 = n;p2 >= 1;p2--){
                    if(arr[p2] % x != 0){
                        con = true;
                        break;
                    }
                }
                if(!con){
                    pw.println(-1);
                }
                else{
                    int len1 = n - p1;
                    int len2 = p2 - 1;

                    pw.println(Math.max(len1,len2));
                }
            }

            t--;
        }

        pw.flush();
        pw.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
