

package midterm;
import java.util.Stack;

public class problem3 {
    
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
    
        int low = Integer.MIN_VALUE;
        for (int v : preorder) {
        
            if (v < low) return false;
      
            while (!stack.isEmpty() && v > stack.peek()) {
          
                low = stack.pop();
            }
      
            stack.push(v);
        }
        return true;
    }

    public static void main(String[] args) {
        problem3 solution = new problem3();
        
        int[] preorder1 = {5, 2, 1, 3, 6};
        System.out.println("Example:");
        System.out.println("Input: " + java.util.Arrays.toString(preorder1));
        System.out.println("Output: " + solution.verifyPreorder(preorder1));
        
    }
}

