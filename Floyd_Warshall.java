import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd_Warshall {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int nodes = input.nextInt();
        int edges = input.nextInt();
        int[][] matrix = new int[nodes+1][nodes+1];
        for(int i = 1;i <= nodes;i++){
            for(int j = 1;j <= nodes;j++){
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0;i < edges;i++){
            int src = input.nextInt();
            int dest = input.nextInt();
            int weight = input.nextInt();
            matrix[src][dest] = weight;
        }

        for(int k = 1;k <= nodes;k++){
            for(int i = 0;i <= nodes;i++){
                for(int j = 0;j <= nodes;j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }

        for(int i = 1;i <= nodes;i++){
            for(int j = 1;j <= nodes;j++){
                if(i != j){ // no self loops
                    System.out.println("Shortest path between  " + i + " to " + j + " : " + matrix[i][j]);
                }
            }
        }
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
