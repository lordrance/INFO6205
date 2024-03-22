

package midterm;
import java.util.Stack;

public class problem3 {
    
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        // 初始化最小值为最小整数
        int low = Integer.MIN_VALUE;
        for (int v : preorder) {
            // 如果遇到的值小于栈中的任何值，则不是有效的前序遍历
            if (v < low) return false;
            // 如果当前值大于栈顶元素，说明我们正在遍历的是右子树
            while (!stack.isEmpty() && v > stack.peek()) {
                // 更新我们在当前右子树中应有的最小值
                low = stack.pop();
            }
            // 将当前值压入栈中
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

