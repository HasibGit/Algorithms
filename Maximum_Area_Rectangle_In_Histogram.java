import java.util.*;

public class Maximum_Area_Rectangle_In_Histogram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] heights = new int[n];
        for(int i = 0;i < n;i++){
            heights[i] = input.nextInt();
        }
        int maxArea = Integer.MIN_VALUE;
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);

        int i = 1;

        while (true){
            if(heights[i] >= heights[stack.peek()]){
                stack.add(i);
                i++;
            }
            else{
                while (heights[stack.peek()] > heights[i]){
                    int top = stack.pop();
                    if(stack.isEmpty()){
                     area = heights[top] * i;
                     maxArea = Math.max(maxArea,area);
                     break;
                    }
                    else{
                        area = heights[top] * (i - stack.peek() - 1);
                        maxArea = Math.max(maxArea,area);
                    }
                }
                stack.add(i);
                i++;
            }
            if(i == heights.length){
                while (!stack.isEmpty()){
                    int top = stack.pop();
                    if(stack.isEmpty()){
                        area = heights[top] * i;
                        maxArea = Math.max(maxArea,area);
                        break;
                    }
                    else{
                            area = heights[top] * (i - stack.peek() - 1);
                            maxArea = Math.max(maxArea,area);
                    }
                }
                break;
            }
        }
        System.out.println("Maximum rectangular area of the histogram : " + maxArea);
    }
}
